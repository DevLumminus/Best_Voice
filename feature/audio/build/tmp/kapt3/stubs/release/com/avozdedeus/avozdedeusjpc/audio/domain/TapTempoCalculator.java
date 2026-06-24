package com.avozdedeus.avozdedeusjpc.audio.domain;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/domain/TapTempoCalculator;", "", "maxIntervals", "", "timeoutMs", "", "minBpm", "maxBpm", "(IJII)V", "intervalsMs", "Lkotlin/collections/ArrayDeque;", "lastTapTimeMs", "Ljava/lang/Long;", "reset", "", "tap", "elapsedRealtimeMs", "audio_release"})
public final class TapTempoCalculator {
    private final int maxIntervals = 0;
    private final long timeoutMs = 0L;
    private final int minBpm = 0;
    private final int maxBpm = 0;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.collections.ArrayDeque<java.lang.Long> intervalsMs = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Long lastTapTimeMs;
    
    public TapTempoCalculator(int maxIntervals, long timeoutMs, int minBpm, int maxBpm) {
        super();
    }
    
    public final int tap(long elapsedRealtimeMs) {
        return 0;
    }
    
    public final void reset() {
    }
    
    public TapTempoCalculator() {
        super();
    }
}