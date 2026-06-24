package com.avozdedeus.avozdedeusjpc.audio.domain;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u001a&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f\u001a9\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\u0013\u001a\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u0007\u001a\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0003\u001a\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0003\u001a\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0002\u0010\u001b\u001a\u001f\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\u001e\u001a\u000e\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003\u001a\'\u0010!\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\"\u001a\'\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010%\u001a\u000e\u0010&\u001a\u00020\u00032\u0006\u0010\'\u001a\u00020\u0003\u001a\u000e\u0010(\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003\u00a8\u0006)"}, d2 = {"areSemitonesTolerant", "", "semitone1", "", "semitone2", "tolerance", "calculateSeekTargetPosition", "", "currentPositionMs", "deltaMs", "durationMs", "loopRange", "Lcom/avozdedeus/avozdedeusjpc/audio/domain/PlaybackLoopRange;", "evaluateRepeatLoopAction", "Lcom/avozdedeus/avozdedeusjpc/audio/domain/RepeatLoopAction;", "playbackState", "", "repeatPointA", "repeatPointB", "(JIJLjava/lang/Long;Ljava/lang/Long;)Lcom/avozdedeus/avozdedeusjpc/audio/domain/RepeatLoopAction;", "formatPlaybackTime", "", "formatToneInputValue", "value", "formatToneSliderValue", "normalizeManualToneValue", "input", "(Ljava/lang/String;)Ljava/lang/Float;", "normalizeRepeatMarkers", "Lcom/avozdedeus/avozdedeusjpc/audio/domain/RepeatMarkerState;", "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/avozdedeus/avozdedeusjpc/audio/domain/RepeatMarkerState;", "pitchMultiplierToSemitones", "pitchMultiplier", "resolvePlaybackLoop", "(JLjava/lang/Long;Ljava/lang/Long;)Lcom/avozdedeus/avozdedeusjpc/audio/domain/PlaybackLoopRange;", "resolvePlayerRepeatMode", "repeatModePreference", "(ILjava/lang/Long;Ljava/lang/Long;)I", "semitonesToPitchMultiplier", "semitones", "snapToneValueToStep", "audio_release"})
public final class PlaybackRulesKt {
    
    @org.jetbrains.annotations.NotNull()
    public static final com.avozdedeus.avozdedeusjpc.audio.domain.RepeatMarkerState normalizeRepeatMarkers(@org.jetbrains.annotations.Nullable()
    java.lang.Long repeatPointA, @org.jetbrains.annotations.Nullable()
    java.lang.Long repeatPointB) {
        return null;
    }
    
    public static final int resolvePlayerRepeatMode(int repeatModePreference, @org.jetbrains.annotations.Nullable()
    java.lang.Long repeatPointA, @org.jetbrains.annotations.Nullable()
    java.lang.Long repeatPointB) {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final com.avozdedeus.avozdedeusjpc.audio.domain.RepeatLoopAction evaluateRepeatLoopAction(long currentPositionMs, int playbackState, long durationMs, @org.jetbrains.annotations.Nullable()
    java.lang.Long repeatPointA, @org.jetbrains.annotations.Nullable()
    java.lang.Long repeatPointB) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.avozdedeus.avozdedeusjpc.audio.domain.PlaybackLoopRange resolvePlaybackLoop(long durationMs, @org.jetbrains.annotations.Nullable()
    java.lang.Long repeatPointA, @org.jetbrains.annotations.Nullable()
    java.lang.Long repeatPointB) {
        return null;
    }
    
    public static final long calculateSeekTargetPosition(long currentPositionMs, long deltaMs, long durationMs, @org.jetbrains.annotations.NotNull()
    com.avozdedeus.avozdedeusjpc.audio.domain.PlaybackLoopRange loopRange) {
        return 0L;
    }
    
    public static final float semitonesToPitchMultiplier(float semitones) {
        return 0.0F;
    }
    
    public static final float pitchMultiplierToSemitones(float pitchMultiplier) {
        return 0.0F;
    }
    
    public static final boolean areSemitonesTolerant(float semitone1, float semitone2, float tolerance) {
        return false;
    }
    
    public static final float snapToneValueToStep(float value) {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.Float normalizeManualToneValue(@org.jetbrains.annotations.NotNull()
    java.lang.String input) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String formatToneSliderValue(float value) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String formatToneInputValue(float value) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String formatPlaybackTime(long durationMs) {
        return null;
    }
}