package com.avozdedeus.avozdedeusjpc.audio.analysis;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J \u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0002J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002\u00a8\u0006\u001f"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/analysis/AudioKeyEstimator;", "", "()V", "addFrameChroma", "", "magnitude", "", "sampleRateHz", "", "chroma", "", "correlation", "profile", "rootIndex", "", "estimate", "Lcom/avozdedeus/avozdedeusjpc/audio/analysis/AudioKeyEstimate;", "decoded", "Lcom/avozdedeus/avozdedeusjpc/audio/analysis/DecodedPcm;", "floorMod", "value", "divisor", "log2", "rankKeys", "", "Lcom/avozdedeus/avozdedeusjpc/audio/analysis/KeyScore;", "readPcm16Sample", "", "bytes", "", "sampleIndex", "audio_release"})
public final class AudioKeyEstimator {
    @org.jetbrains.annotations.NotNull()
    public static final com.avozdedeus.avozdedeusjpc.audio.analysis.AudioKeyEstimator INSTANCE = null;
    
    private AudioKeyEstimator() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.avozdedeus.avozdedeusjpc.audio.analysis.AudioKeyEstimate estimate(@org.jetbrains.annotations.NotNull()
    com.avozdedeus.avozdedeusjpc.audio.analysis.DecodedPcm decoded) {
        return null;
    }
    
    private final void addFrameChroma(float[] magnitude, double sampleRateHz, double[] chroma) {
    }
    
    private final java.util.List<com.avozdedeus.avozdedeusjpc.audio.analysis.KeyScore> rankKeys(double[] chroma) {
        return null;
    }
    
    private final double correlation(double[] chroma, double[] profile, int rootIndex) {
        return 0.0;
    }
    
    private final float readPcm16Sample(byte[] bytes, int sampleIndex) {
        return 0.0F;
    }
    
    private final double log2(double value) {
        return 0.0;
    }
    
    private final int floorMod(int value, int divisor) {
        return 0;
    }
}