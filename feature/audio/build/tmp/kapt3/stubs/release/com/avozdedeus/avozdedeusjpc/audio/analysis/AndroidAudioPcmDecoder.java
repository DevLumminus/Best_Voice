package com.avozdedeus.avozdedeusjpc.audio.analysis;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J7\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002\u00a2\u0006\u0002\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0002\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002\u00a2\u0006\u0002\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002\u00a2\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001d\u001a\u00020\u001eH\u0002\u00a2\u0006\u0002\u0010\u001fJ \u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0014\u0010&\u001a\u00020\u0006*\u00020\'2\u0006\u0010(\u001a\u00020\u0006H\u0002J\u0014\u0010)\u001a\u00020\u0006*\u00020\'2\u0006\u0010(\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/analysis/AndroidAudioPcmDecoder;", "", "()V", "TIMEOUT_US", "", "appendPcmAsMono", "", "outputBuffer", "Ljava/nio/ByteBuffer;", "channelCount", "destination", "Ljava/io/ByteArrayOutputStream;", "maxMonoSamples", "currentMonoSamples", "(Ljava/nio/ByteBuffer;ILjava/io/ByteArrayOutputStream;Ljava/lang/Long;J)I", "decode", "Lcom/avozdedeus/avozdedeusjpc/audio/analysis/DecodedPcm;", "file", "Ljava/io/File;", "maxDurationSec", "", "(Ljava/io/File;Ljava/lang/Double;)Lcom/avozdedeus/avozdedeusjpc/audio/analysis/DecodedPcm;", "decodeWithMediaCodec", "estimatedPcmCapacity", "sampleRate", "(ILjava/lang/Double;)I", "isWavFile", "", "selectAudioTrack", "extractor", "Landroid/media/MediaExtractor;", "(Landroid/media/MediaExtractor;)Ljava/lang/Integer;", "writeSampleBytes", "", "sample", "", "sampleBytes", "", "channelCountOrDefault", "Landroid/media/MediaFormat;", "default", "sampleRateOrDefault", "audio_release"})
public final class AndroidAudioPcmDecoder {
    private static final long TIMEOUT_US = 10000L;
    @org.jetbrains.annotations.NotNull()
    public static final com.avozdedeus.avozdedeusjpc.audio.analysis.AndroidAudioPcmDecoder INSTANCE = null;
    
    private AndroidAudioPcmDecoder() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.avozdedeus.avozdedeusjpc.audio.analysis.DecodedPcm decode(@org.jetbrains.annotations.NotNull()
    java.io.File file, @org.jetbrains.annotations.Nullable()
    java.lang.Double maxDurationSec) {
        return null;
    }
    
    private final boolean isWavFile(java.io.File file) {
        return false;
    }
    
    private final com.avozdedeus.avozdedeusjpc.audio.analysis.DecodedPcm decodeWithMediaCodec(java.io.File file, java.lang.Double maxDurationSec) {
        return null;
    }
    
    private final int estimatedPcmCapacity(int sampleRate, java.lang.Double maxDurationSec) {
        return 0;
    }
    
    private final java.lang.Integer selectAudioTrack(android.media.MediaExtractor extractor) {
        return null;
    }
    
    private final int appendPcmAsMono(java.nio.ByteBuffer outputBuffer, int channelCount, java.io.ByteArrayOutputStream destination, java.lang.Long maxMonoSamples, long currentMonoSamples) {
        return 0;
    }
    
    private final void writeSampleBytes(short sample, byte[] sampleBytes, java.io.ByteArrayOutputStream destination) {
    }
    
    private final int channelCountOrDefault(android.media.MediaFormat $this$channelCountOrDefault, int p1_772401952) {
        return 0;
    }
    
    private final int sampleRateOrDefault(android.media.MediaFormat $this$sampleRateOrDefault, int p1_772401952) {
        return 0;
    }
}