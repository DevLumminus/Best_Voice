package com.avozdedeus.avozdedeusjpc.audio.domain;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJ\u0010\u0010#\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\tH\u00c6\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u00c6\u0003J\u000f\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u00c6\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bH\u00c6\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJ\u0082\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010/\u001a\u00020\u0003H\u00d6\u0001J\t\u00100\u001a\u000201H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b \u0010\u001b\u00a8\u00062"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/domain/BpmAnalysisResult;", "", "estimatedBpm", "", "movingAverageBpm", "", "dominantIntervalMs", "validIntervalCount", "confidence", "", "instantaneousBpms", "", "movingAverageBpms", "histogram", "Lcom/avozdedeus/avozdedeusjpc/audio/domain/BpmHistogramBucket;", "validatedBpm", "(Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;IFLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Double;)V", "getConfidence", "()F", "getDominantIntervalMs", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEstimatedBpm", "getHistogram", "()Ljava/util/List;", "getInstantaneousBpms", "getMovingAverageBpm", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getMovingAverageBpms", "getValidIntervalCount", "()I", "getValidatedBpm", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;IFLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Double;)Lcom/avozdedeus/avozdedeusjpc/audio/domain/BpmAnalysisResult;", "equals", "", "other", "hashCode", "toString", "", "audio_release"})
public final class BpmAnalysisResult {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer estimatedBpm = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double movingAverageBpm = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer dominantIntervalMs = null;
    private final int validIntervalCount = 0;
    private final float confidence = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.Double> instantaneousBpms = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.Double> movingAverageBpms = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.avozdedeus.avozdedeusjpc.audio.domain.BpmHistogramBucket> histogram = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double validatedBpm = null;
    
    public BpmAnalysisResult(@org.jetbrains.annotations.Nullable()
    java.lang.Integer estimatedBpm, @org.jetbrains.annotations.Nullable()
    java.lang.Double movingAverageBpm, @org.jetbrains.annotations.Nullable()
    java.lang.Integer dominantIntervalMs, int validIntervalCount, float confidence, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Double> instantaneousBpms, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Double> movingAverageBpms, @org.jetbrains.annotations.NotNull()
    java.util.List<com.avozdedeus.avozdedeusjpc.audio.domain.BpmHistogramBucket> histogram, @org.jetbrains.annotations.Nullable()
    java.lang.Double validatedBpm) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getEstimatedBpm() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getMovingAverageBpm() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getDominantIntervalMs() {
        return null;
    }
    
    public final int getValidIntervalCount() {
        return 0;
    }
    
    public final float getConfidence() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Double> getInstantaneousBpms() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Double> getMovingAverageBpms() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.avozdedeus.avozdedeusjpc.audio.domain.BpmHistogramBucket> getHistogram() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getValidatedBpm() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component3() {
        return null;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final float component5() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Double> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Double> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.avozdedeus.avozdedeusjpc.audio.domain.BpmHistogramBucket> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.avozdedeus.avozdedeusjpc.audio.domain.BpmAnalysisResult copy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer estimatedBpm, @org.jetbrains.annotations.Nullable()
    java.lang.Double movingAverageBpm, @org.jetbrains.annotations.Nullable()
    java.lang.Integer dominantIntervalMs, int validIntervalCount, float confidence, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Double> instantaneousBpms, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Double> movingAverageBpms, @org.jetbrains.annotations.NotNull()
    java.util.List<com.avozdedeus.avozdedeusjpc.audio.domain.BpmHistogramBucket> histogram, @org.jetbrains.annotations.Nullable()
    java.lang.Double validatedBpm) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}