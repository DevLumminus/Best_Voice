package com.avozdedeus.avozdedeusjpc.audio.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\u001a\u0010\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0002\u001a\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u00a2\u0006\u0002\u0010\u0012\u001a#\u0010\u0013\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u0015H\u0002\u00a2\u0006\u0002\u0010\u0016\u001a#\u0010\u0017\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000fH\u0002\u00a2\u0006\u0002\u0010\u0018\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"BPM_CACHE_ALGORITHM_VERSION", "", "BPM_CACHE_PREFS", "KEY_BEATS_PER_BAR", "KEY_CONFIDENCE", "KEY_DOMINANT_INTERVAL_MS", "KEY_ESTIMATED_BPM", "KEY_MOVING_AVERAGE_BPM", "KEY_PRESENT", "KEY_SUGGESTED_METER_LABEL", "KEY_VALIDATED_BPM", "KEY_VALID_INTERVAL_COUNT", "sha256", "value", "optionalInt", "", "Landroid/content/SharedPreferences;", "key", "(Landroid/content/SharedPreferences;Ljava/lang/String;)Ljava/lang/Integer;", "putOptionalDouble", "Landroid/content/SharedPreferences$Editor;", "", "(Landroid/content/SharedPreferences$Editor;Ljava/lang/String;Ljava/lang/Double;)Landroid/content/SharedPreferences$Editor;", "putOptionalInt", "(Landroid/content/SharedPreferences$Editor;Ljava/lang/String;Ljava/lang/Integer;)Landroid/content/SharedPreferences$Editor;", "audio_release"})
public final class BpmAnalysisCacheKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String BPM_CACHE_PREFS = "audio_bpm_analysis_cache";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String BPM_CACHE_ALGORITHM_VERSION = "periodic_validation_v1_buffer2048";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_PRESENT = "present";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_ESTIMATED_BPM = "estimated_bpm";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_MOVING_AVERAGE_BPM = "moving_average_bpm";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_VALIDATED_BPM = "validated_bpm";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_DOMINANT_INTERVAL_MS = "dominant_interval_ms";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_VALID_INTERVAL_COUNT = "valid_interval_count";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_CONFIDENCE = "confidence";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_SUGGESTED_METER_LABEL = "suggested_meter_label";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_BEATS_PER_BAR = "beats_per_bar";
    
    private static final java.lang.Integer optionalInt(android.content.SharedPreferences $this$optionalInt, java.lang.String key) {
        return null;
    }
    
    private static final android.content.SharedPreferences.Editor putOptionalInt(android.content.SharedPreferences.Editor $this$putOptionalInt, java.lang.String key, java.lang.Integer value) {
        return null;
    }
    
    private static final android.content.SharedPreferences.Editor putOptionalDouble(android.content.SharedPreferences.Editor $this$putOptionalDouble, java.lang.String key, java.lang.Double value) {
        return null;
    }
    
    private static final java.lang.String sha256(java.lang.String value) {
        return null;
    }
}