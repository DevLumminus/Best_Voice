package com.avozdedeus.avozdedeusjpc.audio.presentation

import android.net.Uri
import android.net.TestUri
import androidx.media3.common.Player
import com.avozdedeus.avozdedeusjpc.audio.analysis.AudioKeyAnalysisResult
import com.avozdedeus.avozdedeusjpc.audio.analysis.AudioKeyAnalyzer
import com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetAnalyzer
import com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetExtractionResult
import com.avozdedeus.avozdedeusjpc.audio.data.AudioSessionStore
import com.avozdedeus.avozdedeusjpc.audio.data.BpmAnalysisCacheStore
import com.avozdedeus.avozdedeusjpc.audio.data.CachedBpmAnalysis
import com.avozdedeus.avozdedeusjpc.audio.domain.BpmAnalysisResult
import com.avozdedeus.avozdedeusjpc.audio.data.StoredAudioSelection
import com.avozdedeus.avozdedeusjpc.audio.domain.musicalKeyOf
import com.avozdedeus.avozdedeusjpc.core.common.prefs.UserUiPreferences
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain

@OptIn(ExperimentalCoroutinesApi::class)
class AudioViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val noopOnsetAnalyzer = OnsetAnalyzer {
        OnsetExtractionResult.Success(emptyList(), emptyList())
    }

    private val noopBpmAnalysisCache = object : BpmAnalysisCacheStore {
        override fun load(uri: Uri): CachedBpmAnalysis? = null
        override fun save(uri: Uri, cached: CachedBpmAnalysis) = Unit
    }

    private val noopAudioKeyAnalyzer = AudioKeyAnalyzer {
        AudioKeyAnalysisResult.Failure("noop")
    }

    private val noopUserUiPreferences = object : UserUiPreferences {
        private val metronomeFlow = MutableStateFlow(false)
        private val thresholdFlow = MutableStateFlow(0.4f)
        private val notesFlow = MutableStateFlow(false)
        override val metronomeSectionEnabled = metronomeFlow.asStateFlow()
        override fun setMetronomeSectionEnabled(enabled: Boolean) {
            metronomeFlow.value = enabled
        }
        override val onsetDetectionThreshold = thresholdFlow.asStateFlow()
        override fun setOnsetDetectionThreshold(threshold: Float) {
            thresholdFlow.value = threshold.coerceIn(0.05f, 0.95f)
        }
        override val notesSectionEnabled = notesFlow.asStateFlow()
        override fun setNotesSectionEnabled(enabled: Boolean) {
            notesFlow.value = enabled
        }
    }

    @Test
    fun `refreshFromStoredSelection hydrates the ui state from persisted session`() {
        val store = FakeAudioSessionStore(
            selection = storedSelection(
                playbackSpeed = 1.5f,
                toneSemitones = 2.5f,
                repeatMode = Player.REPEAT_MODE_ONE,
                repeatPointA = 1_000L,
                repeatPointB = 3_000L
            )
        )

        val viewModel = AudioViewModel(
            store,
            noopOnsetAnalyzer,
            noopBpmAnalysisCache,
            noopAudioKeyAnalyzer,
            noopUserUiPreferences
        )

        val state = viewModel.uiState.value
        assertNotNull(state.storedSelection)
        assertEquals(1.5f, state.playbackSpeed)
        assertEquals(2.5f, state.toneSemitones)
        assertTrue(state.isRepeatEnabled)
        assertEquals(1_000L, state.repeatPointA)
        assertEquals(3_000L, state.repeatPointB)
    }

    @Test
    fun `tone actions snap values and persist tone`() {
        val store = FakeAudioSessionStore()
        val viewModel = AudioViewModel(
            store,
            noopOnsetAnalyzer,
            noopBpmAnalysisCache,
            noopAudioKeyAnalyzer,
            noopUserUiPreferences
        )

        viewModel.onAction(AudioUiAction.SetToneSemitones(1.74f))

        assertEquals(1.5f, viewModel.uiState.value.toneSemitones)
        assertEquals(1.5f, store.lastToneSemitones)

        viewModel.onAction(AudioUiAction.OpenToneDialog)
        viewModel.onAction(AudioUiAction.UpdateToneInputText("2,3"))
        viewModel.onAction(AudioUiAction.ConfirmToneDialog)

        assertEquals(2.5f, viewModel.uiState.value.toneSemitones)
        assertFalse(viewModel.uiState.value.isToneInputDialogOpen)
    }

    @Test
    fun `repeat and speed actions update ui state and store`() {
        val store = FakeAudioSessionStore()
        val viewModel = AudioViewModel(
            store,
            noopOnsetAnalyzer,
            noopBpmAnalysisCache,
            noopAudioKeyAnalyzer,
            noopUserUiPreferences
        )

        viewModel.onAction(AudioUiAction.ToggleRepeatMode)
        val markers = viewModel.updateRepeatMarkers(5_000L, 2_000L)
        viewModel.onAction(
            AudioUiAction.SelectSpeed(
                PlaybackSpeedOption(multiplier = 1.25f, label = "1.25x")
            )
        )

        assertTrue(viewModel.uiState.value.isRepeatEnabled)
        assertEquals(Player.REPEAT_MODE_ONE, store.lastRepeatMode)
        assertEquals(2_000L, markers.repeatPointA)
        assertEquals(5_000L, markers.repeatPointB)
        assertEquals(2_000L, store.lastRepeatPointA)
        assertEquals(5_000L, store.lastRepeatPointB)
        assertEquals(1.25f, viewModel.uiState.value.playbackSpeed)
        assertEquals(1.25f, store.lastPlaybackSpeed)
    }

    @Test
    fun `initializeFromIntent only seeds pending audio once`() {
        val store = FakeAudioSessionStore()
        val viewModel = AudioViewModel(
            store,
            noopOnsetAnalyzer,
            noopBpmAnalysisCache,
            noopAudioKeyAnalyzer,
            noopUserUiPreferences
        )

        viewModel.initializeFromIntent(TestUri("content://audio/first"), "first.mp3")
        viewModel.initializeFromIntent(TestUri("content://audio/second"), "second.mp3")

        assertEquals("content://audio/first", viewModel.uiState.value.pendingIntentAudio?.uri.toString())
        assertEquals("first.mp3", viewModel.uiState.value.pendingIntentAudio?.fileName)
    }

    @Test
    fun `metronome starts in manual mode with empty bpm and default meter`() {
        val viewModel = AudioViewModel(
            FakeAudioSessionStore(),
            noopOnsetAnalyzer,
            noopBpmAnalysisCache,
            noopAudioKeyAnalyzer,
            noopUserUiPreferences
        )

        val state = viewModel.uiState.value
        assertEquals(MetronomeMode.MANUAL, state.metronomeMode)
        assertEquals(null, state.manualBpm)
        assertEquals("4/4", state.metronomeMeterLabel)
        assertEquals(4, state.metronomeBeatsPerBar)
    }

    @Test
    fun `tap tempo updates manual bpm after the second tap`() {
        val viewModel = AudioViewModel(
            FakeAudioSessionStore(),
            noopOnsetAnalyzer,
            noopBpmAnalysisCache,
            noopAudioKeyAnalyzer,
            noopUserUiPreferences
        )

        viewModel.onAction(AudioUiAction.RegisterTapTempo(1_000L))
        assertEquals(null, viewModel.uiState.value.manualBpm)

        viewModel.onAction(AudioUiAction.RegisterTapTempo(1_500L))

        assertEquals(MetronomeMode.MANUAL, viewModel.uiState.value.metronomeMode)
        assertEquals(120, viewModel.uiState.value.manualBpm)
    }

    @Test
    fun `tap tempo timeout clears manual bpm`() {
        val viewModel = AudioViewModel(
            FakeAudioSessionStore(),
            noopOnsetAnalyzer,
            noopBpmAnalysisCache,
            noopAudioKeyAnalyzer,
            noopUserUiPreferences
        )

        viewModel.onAction(AudioUiAction.RegisterTapTempo(1_000L))
        viewModel.onAction(AudioUiAction.RegisterTapTempo(1_500L))
        viewModel.onAction(AudioUiAction.RegisterTapTempo(4_000L))

        assertEquals(null, viewModel.uiState.value.manualBpm)
    }

    @Test
    fun `select metronome meter updates the visible meter and beat count`() {
        val viewModel = AudioViewModel(
            FakeAudioSessionStore(),
            noopOnsetAnalyzer,
            noopBpmAnalysisCache,
            noopAudioKeyAnalyzer,
            noopUserUiPreferences
        )

        viewModel.onAction(AudioUiAction.ToggleMetronomeMeterMenu)
        viewModel.onAction(AudioUiAction.SelectMetronomeMeter(MeterOption("3/4", 3)))

        assertEquals("3/4", viewModel.uiState.value.metronomeMeterLabel)
        assertEquals(3, viewModel.uiState.value.metronomeBeatsPerBar)
        assertFalse(viewModel.uiState.value.isMetronomeMeterMenuExpanded)

        viewModel.onAction(AudioUiAction.SelectMetronomeMeter(MeterOption("2/4", 2)))

        assertEquals("2/4", viewModel.uiState.value.metronomeMeterLabel)
        assertEquals(2, viewModel.uiState.value.metronomeBeatsPerBar)
    }

    @Test
    fun `audio key read updates source and transposed labels`() = runTest {
        val uri = TestUri("content://audio/key")
        val keyAnalyzer = FakeAudioKeyAnalyzer(
            result = AudioKeyAnalysisResult.Success(
                key = musicalKeyOf("G")!!,
                confidence = 1f
            )
        )
        val viewModel = AudioViewModel(
            FakeAudioSessionStore(),
            noopOnsetAnalyzer,
            noopBpmAnalysisCache,
            keyAnalyzer,
            noopUserUiPreferences
        )

        assertEquals("--", viewModel.uiState.value.audioKeySourceLabel)
        assertEquals("--", viewModel.uiState.value.audioKeyTargetLabel)

        viewModel.onAction(AudioUiAction.ReadAudioKey(uri))
        advanceUntilIdle()

        assertEquals(1, keyAnalyzer.callCount)
        assertEquals("G", viewModel.uiState.value.audioKeySourceLabel)
        assertEquals("G", viewModel.uiState.value.audioKeyTargetLabel)

        viewModel.onAction(AudioUiAction.SetToneSemitones(0.5f))

        assertEquals("G", viewModel.uiState.value.audioKeySourceLabel)
        assertEquals("G#", viewModel.uiState.value.audioKeyTargetLabel)
    }

    @Test
    fun `audio key failure and clear action show placeholders`() = runTest {
        val uri = TestUri("content://audio/key")
        val keyAnalyzer = FakeAudioKeyAnalyzer(
            result = AudioKeyAnalysisResult.Success(
                key = musicalKeyOf("C#-")!!,
                confidence = 1f
            )
        )
        val viewModel = AudioViewModel(
            FakeAudioSessionStore(),
            noopOnsetAnalyzer,
            noopBpmAnalysisCache,
            keyAnalyzer,
            noopUserUiPreferences
        )

        viewModel.onAction(AudioUiAction.ReadAudioKey(uri))
        advanceUntilIdle()

        assertEquals("C#-", viewModel.uiState.value.audioKeySourceLabel)

        keyAnalyzer.result = AudioKeyAnalysisResult.Failure("unavailable")
        viewModel.onAction(AudioUiAction.ReadAudioKey(uri))
        advanceUntilIdle()

        assertEquals("--", viewModel.uiState.value.audioKeySourceLabel)
        assertEquals("--", viewModel.uiState.value.audioKeyTargetLabel)

        keyAnalyzer.result = AudioKeyAnalysisResult.Success(
            key = musicalKeyOf("B")!!,
            confidence = 1f
        )
        viewModel.onAction(AudioUiAction.ReadAudioKey(uri))
        advanceUntilIdle()
        viewModel.onAction(AudioUiAction.ClearAudioKey)

        assertEquals("--", viewModel.uiState.value.audioKeySourceLabel)
        assertEquals("--", viewModel.uiState.value.audioKeyTargetLabel)
    }

    @Test
    fun `cached bpm read uses cache`() = runTest {
        val uri = TestUri("content://audio/cached")
        val analyzer = CountingOnsetAnalyzer()
        val cache = FakeBpmAnalysisCache(
            cached = CachedBpmAnalysis(
                bpmAnalysis = BpmAnalysisResult(
                    estimatedBpm = 128,
                    movingAverageBpm = 127.6,
                    dominantIntervalMs = 469,
                    validIntervalCount = 16,
                    confidence = 0.8f,
                    validatedBpm = 127.6
                ),
                suggestedMeterLabel = "6/8",
                beatsPerBar = 6
            )
        )
        val viewModel = AudioViewModel(
            FakeAudioSessionStore(),
            analyzer,
            cache,
            noopAudioKeyAnalyzer,
            noopUserUiPreferences
        )

        viewModel.onAction(AudioUiAction.ReadBpm(uri, forceRefresh = false))
        advanceUntilIdle()

        assertEquals(1, cache.loadCount)
        assertEquals(0, analyzer.callCount)
        assertEquals(128, viewModel.uiState.value.bpmAnalysis?.estimatedBpm)
        assertEquals("6/8", viewModel.uiState.value.suggestedMeterLabel)
        assertEquals(6, viewModel.uiState.value.beatsPerBar)
    }

    @Test
    fun `force refresh analyzes and saves bpm cache`() = runTest {
        val uri = TestUri("content://audio/refresh")
        val analyzer = CountingOnsetAnalyzer(
            result = OnsetExtractionResult.Success(
                timestampsSeconds = listOf(0.0, 0.5, 1.0),
                saliences = listOf(1.0, 1.0, 1.0)
            )
        )
        val cache = FakeBpmAnalysisCache(
            cached = CachedBpmAnalysis(
                bpmAnalysis = BpmAnalysisResult(
                    estimatedBpm = 80,
                    movingAverageBpm = 80.0,
                    dominantIntervalMs = 750,
                    validIntervalCount = 4,
                    confidence = 1f,
                    validatedBpm = 80.0
                ),
                suggestedMeterLabel = "3/4",
                beatsPerBar = 3
            )
        )
        val viewModel = AudioViewModel(
            FakeAudioSessionStore(),
            analyzer,
            cache,
            noopAudioKeyAnalyzer,
            noopUserUiPreferences
        )

        viewModel.onAction(AudioUiAction.ReadBpm(uri, forceRefresh = true))
        advanceUntilIdle()

        assertEquals(0, cache.loadCount)
        assertEquals(1, analyzer.callCount)
        assertEquals(1, cache.saveCount)
        assertEquals(120, cache.lastSaved?.bpmAnalysis?.estimatedBpm)
        assertEquals(120, viewModel.uiState.value.bpmAnalysis?.estimatedBpm)
    }

    private class FakeAudioSessionStore(
        private var selection: StoredAudioSelection? = null
    ) : AudioSessionStore {
        var lastPlaybackSpeed: Float? = null
        var lastToneSemitones: Float? = null
        var lastRepeatMode: Int? = null
        var lastRepeatPointA: Long? = null
        var lastRepeatPointB: Long? = null

        override fun loadSelection(): StoredAudioSelection? = selection

        override fun saveSelection(selection: StoredAudioSelection) {
            this.selection = selection
        }

        override fun updatePosition(positionMs: Long) = Unit

        override fun updatePlaybackSpeed(playbackSpeed: Float) {
            lastPlaybackSpeed = playbackSpeed
            selection = selection?.copy(playbackSpeed = playbackSpeed)
        }

        override fun updateToneSemitones(toneSemitones: Float) {
            lastToneSemitones = toneSemitones
            selection = selection?.copy(toneSemitones = toneSemitones)
        }

        override fun updateRepeatMode(repeatMode: Int) {
            lastRepeatMode = repeatMode
            selection = selection?.copy(repeatMode = repeatMode)
        }

        override fun updatePlayWhenReady(playWhenReady: Boolean) = Unit

        override fun updateRepeatMarkers(repeatPointA: Long?, repeatPointB: Long?) {
            lastRepeatPointA = repeatPointA
            lastRepeatPointB = repeatPointB
            selection = selection?.copy(
                repeatPointA = repeatPointA,
                repeatPointB = repeatPointB
            )
        }

        override fun clear() {
            selection = null
        }
    }

    private class FakeBpmAnalysisCache(
        private val cached: CachedBpmAnalysis? = null
    ) : BpmAnalysisCacheStore {
        var loadCount = 0
        var saveCount = 0
        var lastSaved: CachedBpmAnalysis? = null

        override fun load(uri: Uri): CachedBpmAnalysis? {
            loadCount += 1
            return cached
        }

        override fun save(uri: Uri, cached: CachedBpmAnalysis) {
            saveCount += 1
            lastSaved = cached
        }
    }

    private class FakeAudioKeyAnalyzer(
        var result: AudioKeyAnalysisResult
    ) : AudioKeyAnalyzer {
        var callCount = 0

        override fun analyze(uri: Uri): AudioKeyAnalysisResult {
            callCount += 1
            return result
        }
    }

    private class CountingOnsetAnalyzer(
        private val result: OnsetExtractionResult = OnsetExtractionResult.Success(emptyList(), emptyList())
    ) : OnsetAnalyzer {
        var callCount = 0

        override fun analyze(uri: Uri): OnsetExtractionResult {
            callCount += 1
            return result
        }
    }

    companion object {
        private fun storedSelection(
            playbackSpeed: Float = 1f,
            toneSemitones: Float = 0f,
            repeatMode: Int = Player.REPEAT_MODE_OFF,
            repeatPointA: Long? = null,
            repeatPointB: Long? = null
        ): StoredAudioSelection {
            return StoredAudioSelection(
                uri = TestUri("content://audio/test"),
                fileName = "test.mp3",
                positionMs = 0L,
                playbackSpeed = playbackSpeed,
                toneSemitones = toneSemitones,
                repeatMode = repeatMode,
                playWhenReady = false,
                repeatPointA = repeatPointA,
                repeatPointB = repeatPointB
            )
        }
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
class MainDispatcherRule(
    private val testDispatcher: TestDispatcher = UnconfinedTestDispatcher()
) : TestWatcher() {
    override fun starting(description: Description) {
        Dispatchers.setMain(testDispatcher)
    }

    override fun finished(description: Description) {
        Dispatchers.resetMain()
    }
}
