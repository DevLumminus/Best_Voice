package com.avozdedeus.avozdedeusjpc.audio.analysis

import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import be.tarsos.dsp.util.fft.FFT
import be.tarsos.dsp.util.fft.HannWindow
import com.avozdedeus.avozdedeusjpc.audio.domain.MusicalKey
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import java.io.FileOutputStream
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.ln
import kotlin.math.roundToInt
import kotlin.math.sqrt

sealed class AudioKeyAnalysisResult {
    data class Success(
        val key: MusicalKey,
        val confidence: Float
    ) : AudioKeyAnalysisResult()

    data class Failure(val message: String) : AudioKeyAnalysisResult()
}

fun interface AudioKeyAnalyzer {
    fun analyze(uri: Uri): AudioKeyAnalysisResult
}

@Singleton
internal class DefaultAudioKeyAnalyzer @Inject constructor(
    @ApplicationContext private val application: Context
) : AudioKeyAnalyzer {

    override fun analyze(uri: Uri): AudioKeyAnalysisResult {
        return try {
            val uriKey = buildUriKey(application, uri)
            val audioFile = resolveCachedAudioFile(application, uri, uriKey)
            val decoded = AndroidAudioPcmDecoder.decode(
                file = audioFile,
                maxDurationSec = KEY_ANALYSIS_MAX_DURATION_SEC
            )
            val estimate = AudioKeyEstimator.estimate(decoded)
                ?: return AudioKeyAnalysisResult.Failure("Tom do audio indisponivel.")

            AudioKeyAnalysisResult.Success(
                key = estimate.key,
                confidence = estimate.confidence
            )
        } catch (t: Throwable) {
            AudioKeyAnalysisResult.Failure(t.message ?: t.javaClass.simpleName)
        }
    }

    private fun buildUriKey(context: Context, uri: Uri): String {
        val displayName = queryDisplayName(context.contentResolver, uri).orEmpty()
        val size = querySize(context.contentResolver, uri)
        return "${uri}|$displayName|$size"
    }

    private fun resolveCachedAudioFile(context: Context, uri: Uri, uriKey: String): File {
        val ext = extensionForUri(context.contentResolver, uri)
        val outFile = File(context.cacheDir, "key_cache_${uriKey.hashCode()}$ext")
        if (outFile.exists() && outFile.length() > 0L) {
            return outFile
        }

        copyUriToCacheFile(context, uri, outFile)
        return outFile
    }

    private fun copyUriToCacheFile(context: Context, uri: Uri, outFile: File) {
        val inputStream = context.contentResolver.openInputStream(uri)
            ?: throw IllegalStateException("Nao foi possivel abrir o URI do audio.")
        inputStream.use { input ->
            FileOutputStream(outFile).use { output ->
                input.copyTo(output)
            }
        }
        if (!outFile.exists() || outFile.length() == 0L) {
            throw IllegalStateException("Arquivo de audio copiado esta vazio.")
        }
    }

    private fun extensionForUri(resolver: android.content.ContentResolver, uri: Uri): String {
        val mime = resolver.getType(uri)?.lowercase(Locale.US)
        val fromMime = when (mime) {
            "audio/wav", "audio/x-wav", "audio/wave" -> ".wav"
            "audio/mpeg", "audio/mp3" -> ".mp3"
            "audio/ogg", "application/ogg" -> ".ogg"
            "audio/flac" -> ".flac"
            "audio/mp4", "audio/m4a", "audio/x-m4a" -> ".m4a"
            else -> null
        }
        if (fromMime != null) return fromMime

        val name = queryDisplayName(resolver, uri)
        val dot = name?.lastIndexOf('.') ?: -1
        if (name != null && dot >= 0 && dot < name.length - 1) {
            return name.substring(dot).lowercase(Locale.US).take(6)
        }
        return ".bin"
    }

    private fun queryDisplayName(resolver: android.content.ContentResolver, uri: Uri): String? {
        val projection = arrayOf(OpenableColumns.DISPLAY_NAME)
        resolver.query(uri, projection, null, null, null)?.use { cursor ->
            if (cursor.moveToFirst()) {
                val idx = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                if (idx >= 0) return cursor.getString(idx)
            }
        }
        return null
    }

    private fun querySize(resolver: android.content.ContentResolver, uri: Uri): Long {
        val projection = arrayOf(OpenableColumns.SIZE)
        resolver.query(uri, projection, null, null, null)?.use { cursor ->
            if (cursor.moveToFirst()) {
                val idx = cursor.getColumnIndex(OpenableColumns.SIZE)
                if (idx >= 0 && !cursor.isNull(idx)) {
                    return cursor.getLong(idx)
                }
            }
        }
        return -1L
    }
}

internal data class AudioKeyEstimate(
    val key: MusicalKey,
    val confidence: Float
)

internal object AudioKeyEstimator {
    fun estimate(decoded: DecodedPcm): AudioKeyEstimate? {
        val sampleRateHz = decoded.sampleRateHz.toDouble()
        if (decoded.pcmBytes.size < 2 || sampleRateHz <= 0.0) {
            return null
        }

        val chroma = DoubleArray(KEY_CLASS_COUNT)
        val fft = FFT(KEY_BUFFER_SIZE, HannWindow())
        val fftBuffer = FloatArray(KEY_BUFFER_SIZE)
        val magnitude = FloatArray(KEY_BUFFER_SIZE / 2)
        val phase = FloatArray(KEY_BUFFER_SIZE / 2)
        val totalSamples = decoded.pcmBytes.size / 2
        var frameStartSample = 0
        var voicedFrameCount = 0

        while (frameStartSample < totalSamples) {
            fftBuffer.fill(0f)
            var squareSum = 0.0
            val copyLength = minOf(KEY_BUFFER_SIZE, totalSamples - frameStartSample)

            for (index in 0 until copyLength) {
                val sample = readPcm16Sample(decoded.pcmBytes, frameStartSample + index)
                fftBuffer[index] = sample
                squareSum += sample.toDouble() * sample.toDouble()
            }

            val rms = sqrt(squareSum / copyLength.coerceAtLeast(1).toDouble())
            if (rms >= KEY_MIN_RMS) {
                fft.powerPhaseFFT(fftBuffer, magnitude, phase)
                addFrameChroma(
                    magnitude = magnitude,
                    sampleRateHz = sampleRateHz,
                    chroma = chroma
                )
                voicedFrameCount += 1
            }

            frameStartSample += KEY_HOP_SIZE
        }

        if (voicedFrameCount < KEY_MIN_VOICED_FRAMES || chroma.sum() <= 0.0) {
            return null
        }

        val ranked = rankKeys(chroma)
        val best = ranked.firstOrNull() ?: return null
        val second = ranked.getOrNull(1)
        val margin = if (second == null) best.score else best.score - second.score
        val confidence = (margin / KEY_CONFIDENCE_MARGIN_FOR_FULL_SCALE)
            .coerceIn(0.0, 1.0)
            .toFloat()

        if (best.score < KEY_MIN_CORRELATION || confidence < KEY_MIN_CONFIDENCE) {
            return null
        }

        return AudioKeyEstimate(
            key = MusicalKey(
                noteIndex = best.rootIndex,
                isMinor = best.isMinor
            ),
            confidence = confidence
        )
    }

    private fun addFrameChroma(
        magnitude: FloatArray,
        sampleRateHz: Double,
        chroma: DoubleArray
    ) {
        for (bin in 1 until magnitude.size) {
            val frequencyHz = bin.toDouble() * sampleRateHz / KEY_BUFFER_SIZE.toDouble()
            if (frequencyHz !in KEY_MIN_FREQUENCY_HZ..KEY_MAX_FREQUENCY_HZ) {
                continue
            }

            val midiNote = (MIDI_A4 + KEY_CLASS_COUNT * log2(frequencyHz / FREQUENCY_A4_HZ))
                .roundToInt()
            val pitchClass = floorMod(midiNote, KEY_CLASS_COUNT)
            val weight = magnitude[bin].toDouble()
            if (weight.isFinite() && weight > 0.0) {
                chroma[pitchClass] += weight
            }
        }
    }

    private fun rankKeys(chroma: DoubleArray): List<KeyScore> {
        val scores = mutableListOf<KeyScore>()
        for (root in 0 until KEY_CLASS_COUNT) {
            scores += KeyScore(
                rootIndex = root,
                isMinor = false,
                score = correlation(chroma, MajorKeyProfile, root)
            )
            scores += KeyScore(
                rootIndex = root,
                isMinor = true,
                score = correlation(chroma, MinorKeyProfile, root)
            )
        }
        return scores.sortedByDescending { it.score }
    }

    private fun correlation(
        chroma: DoubleArray,
        profile: DoubleArray,
        rootIndex: Int
    ): Double {
        val chromaMean = chroma.average()
        val profileMean = profile.average()
        var numerator = 0.0
        var chromaSquares = 0.0
        var profileSquares = 0.0

        for (pitchClass in 0 until KEY_CLASS_COUNT) {
            val chromaValue = chroma[pitchClass] - chromaMean
            val profileValue = profile[floorMod(pitchClass - rootIndex, KEY_CLASS_COUNT)] -
                profileMean
            numerator += chromaValue * profileValue
            chromaSquares += chromaValue * chromaValue
            profileSquares += profileValue * profileValue
        }

        val denominator = sqrt(chromaSquares * profileSquares)
        if (denominator <= 0.0) {
            return 0.0
        }
        return numerator / denominator
    }

    private fun readPcm16Sample(bytes: ByteArray, sampleIndex: Int): Float {
        val byteIndex = sampleIndex * 2
        val low = bytes[byteIndex].toInt() and 0xFF
        val high = bytes[byteIndex + 1].toInt()
        val sample = ((high shl 8) or low).toShort()
        return sample.toFloat() / Short.MAX_VALUE.toFloat()
    }

    private fun log2(value: Double): Double {
        return ln(value) / ln(2.0)
    }

    private fun floorMod(value: Int, divisor: Int): Int {
        return ((value % divisor) + divisor) % divisor
    }
}

private data class KeyScore(
    val rootIndex: Int,
    val isMinor: Boolean,
    val score: Double
)

private const val KEY_ANALYSIS_MAX_DURATION_SEC = 90.0
private const val KEY_BUFFER_SIZE = 4096
private const val KEY_HOP_SIZE = 2048
private const val KEY_CLASS_COUNT = 12
private const val KEY_MIN_FREQUENCY_HZ = 55.0
private const val KEY_MAX_FREQUENCY_HZ = 5000.0
private const val KEY_MIN_RMS = 0.003
private const val KEY_MIN_VOICED_FRAMES = 4
private const val KEY_MIN_CORRELATION = 0.1
private const val KEY_MIN_CONFIDENCE = 0.05f
private const val KEY_CONFIDENCE_MARGIN_FOR_FULL_SCALE = 0.25
private const val MIDI_A4 = 69.0
private const val FREQUENCY_A4_HZ = 440.0

private val MajorKeyProfile = doubleArrayOf(
    6.35,
    2.23,
    3.48,
    2.33,
    4.38,
    4.09,
    2.52,
    5.19,
    2.39,
    3.66,
    2.29,
    2.88
)

private val MinorKeyProfile = doubleArrayOf(
    6.33,
    2.68,
    3.52,
    5.38,
    2.60,
    3.53,
    2.54,
    4.75,
    3.98,
    2.69,
    3.34,
    3.17
)
