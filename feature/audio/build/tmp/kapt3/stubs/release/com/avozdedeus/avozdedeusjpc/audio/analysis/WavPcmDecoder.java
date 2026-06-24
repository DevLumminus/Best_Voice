package com.avozdedeus.avozdedeusjpc.audio.analysis;

/**
 * Reads mono 16-bit PCM WAV files without [android.media.MediaCodec].
 * Returns null when the file is not a supported WAV.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/analysis/WavPcmDecoder;", "", "()V", "decode", "Lcom/avozdedeus/avozdedeusjpc/audio/analysis/DecodedPcm;", "file", "Ljava/io/File;", "maxDurationSec", "", "(Ljava/io/File;Ljava/lang/Double;)Lcom/avozdedeus/avozdedeusjpc/audio/analysis/DecodedPcm;", "downmixToMono", "", "interleavedPcm", "length", "", "channelCount", "audio_release"})
public final class WavPcmDecoder {
    @org.jetbrains.annotations.NotNull()
    public static final com.avozdedeus.avozdedeusjpc.audio.analysis.WavPcmDecoder INSTANCE = null;
    
    private WavPcmDecoder() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.avozdedeus.avozdedeusjpc.audio.analysis.DecodedPcm decode(@org.jetbrains.annotations.NotNull()
    java.io.File file, @org.jetbrains.annotations.Nullable()
    java.lang.Double maxDurationSec) {
        return null;
    }
    
    private final byte[] downmixToMono(byte[] interleavedPcm, int length, int channelCount) {
        return null;
    }
}