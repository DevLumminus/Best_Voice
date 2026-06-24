package com.avozdedeus.avozdedeusjpc.audio.domain;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00004\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0013\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0014\u001a\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0002\u001a<\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00012\b\b\u0002\u0010\u0019\u001a\u00020\u0001\u001a\u001e\u0010\u001a\u001a\u00020\u00032\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00152\u0006\u0010\u0010\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0002\u001a\u0018\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0001H\u0002\u001a@\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u00152\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00152\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010$2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0002\u001a$\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0\u00152\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030\u00152\u0006\u0010\u001f\u001a\u00020\u0001H\u0002\u001a:\u0010\'\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010$2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0001H\u0002\u001a\u001e\u0010(\u001a\u00020\u00032\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00152\u0006\u0010\u0010\u001a\u00020\u0003H\u0002\u001a6\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010$2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00152\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010$H\u0002\u001a\u0018\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0003H\u0002\u001a\u0018\u0010-\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0003H\u0002\u001a$\u0010.\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00032\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010$H\u0002\u001a&\u00100\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00032\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00152\u0006\u00101\u001a\u00020\u0001H\u0002\u001a\u0010\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u0003H\u0002\u001a\u0010\u00104\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u0003H\u0002\u001a\u0018\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2 = {"AUTOCORRELATION_MAX_MULTIPLE", "", "AUTOCORRELATION_SCORE_WEIGHT", "", "AUTOCORRELATION_TOLERANCE_FRACTION", "COMB_SCORE_WEIGHT", "COMB_TOLERANCE_FRACTION", "DIRECT_BPM_TOLERANCE", "HARMONIC_RATIOS", "", "HARMONIC_RELATIVE_TOLERANCE", "HARMONIC_SCORE_BONUS", "HISTOGRAM_SCORE_WEIGHT", "MAX_ALIGNMENT_TOLERANCE_SEC", "MIN_ALIGNMENT_TOLERANCE_SEC", "alignmentTolerance", "periodSec", "fraction", "analyzeBpmFromTimestamps", "Lcom/avozdedeus/avozdedeusjpc/audio/domain/BpmAnalysisResult;", "timestampsSeconds", "", "minBpm", "maxBpm", "movingAverageWindow", "histogramBucketMs", "autocorrelationScore", "orderedTimestamps", "bpmFromIntervalMs", "intervalMs", "bucketIntervalMs", "bucketSizeMs", "buildCandidateBpms", "histogram", "Lcom/avozdedeus/avozdedeusjpc/audio/domain/BpmHistogramBucket;", "pairIntervalBuckets", "", "buildHistogram", "validIntervalsMs", "collectPairIntervalBuckets", "combScore", "combineIntervalSupport", "directBpmCloseness", "candidateBpm", "observedBpm", "harmonicCloseness", "harmonicScore", "supportBuckets", "histogramScore", "validIntervalCount", "intervalMsFromBpm", "bpm", "periodSecFromBpm", "positiveModulo", "value", "modulus", "audio_debug"})
public final class BpmAnalysisKt {
    private static final double COMB_SCORE_WEIGHT = 0.4;
    private static final double AUTOCORRELATION_SCORE_WEIGHT = 0.4;
    private static final double HISTOGRAM_SCORE_WEIGHT = 0.2;
    private static final double HARMONIC_SCORE_BONUS = 0.1;
    private static final double DIRECT_BPM_TOLERANCE = 0.04;
    private static final double HARMONIC_RELATIVE_TOLERANCE = 0.06;
    private static final double COMB_TOLERANCE_FRACTION = 0.1;
    private static final double AUTOCORRELATION_TOLERANCE_FRACTION = 0.08;
    private static final double MIN_ALIGNMENT_TOLERANCE_SEC = 0.025;
    private static final double MAX_ALIGNMENT_TOLERANCE_SEC = 0.08;
    private static final int AUTOCORRELATION_MAX_MULTIPLE = 4;
    @org.jetbrains.annotations.NotNull()
    private static final double[] HARMONIC_RATIOS = {0.5, 2.0, 1.5, 0.6666666666666666, 3.0, 0.3333333333333333};
    
    @kotlin.Suppress(names = {"UNUSED_PARAMETER"})
    @org.jetbrains.annotations.NotNull()
    public static final com.avozdedeus.avozdedeusjpc.audio.domain.BpmAnalysisResult analyzeBpmFromTimestamps(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Double> timestampsSeconds, double minBpm, double maxBpm, int movingAverageWindow, int histogramBucketMs) {
        return null;
    }
    
    private static final double bpmFromIntervalMs(double intervalMs) {
        return 0.0;
    }
    
    private static final double periodSecFromBpm(double bpm) {
        return 0.0;
    }
    
    private static final double intervalMsFromBpm(double bpm) {
        return 0.0;
    }
    
    private static final java.util.List<com.avozdedeus.avozdedeusjpc.audio.domain.BpmHistogramBucket> buildHistogram(java.util.List<java.lang.Double> validIntervalsMs, int bucketSizeMs) {
        return null;
    }
    
    private static final java.util.Map<java.lang.Integer, java.lang.Integer> collectPairIntervalBuckets(java.util.List<java.lang.Double> orderedTimestamps, double minBpm, double maxBpm, int bucketSizeMs) {
        return null;
    }
    
    private static final java.util.Map<java.lang.Integer, java.lang.Integer> combineIntervalSupport(java.util.List<com.avozdedeus.avozdedeusjpc.audio.domain.BpmHistogramBucket> histogram, java.util.Map<java.lang.Integer, java.lang.Integer> pairIntervalBuckets) {
        return null;
    }
    
    private static final java.util.List<java.lang.Double> buildCandidateBpms(java.util.List<com.avozdedeus.avozdedeusjpc.audio.domain.BpmHistogramBucket> histogram, java.util.Map<java.lang.Integer, java.lang.Integer> pairIntervalBuckets, double minBpm, double maxBpm) {
        return null;
    }
    
    private static final double combScore(java.util.List<java.lang.Double> orderedTimestamps, double periodSec) {
        return 0.0;
    }
    
    private static final double autocorrelationScore(java.util.List<java.lang.Double> orderedTimestamps, double periodSec) {
        return 0.0;
    }
    
    private static final double histogramScore(double candidateBpm, java.util.List<com.avozdedeus.avozdedeusjpc.audio.domain.BpmHistogramBucket> histogram, int validIntervalCount) {
        return 0.0;
    }
    
    private static final double harmonicScore(double candidateBpm, java.util.Map<java.lang.Integer, java.lang.Integer> supportBuckets) {
        return 0.0;
    }
    
    private static final double directBpmCloseness(double candidateBpm, double observedBpm) {
        return 0.0;
    }
    
    private static final double harmonicCloseness(double candidateBpm, double observedBpm) {
        return 0.0;
    }
    
    private static final double alignmentTolerance(double periodSec, double fraction) {
        return 0.0;
    }
    
    private static final double positiveModulo(double value, double modulus) {
        return 0.0;
    }
    
    private static final int bucketIntervalMs(double intervalMs, int bucketSizeMs) {
        return 0;
    }
}