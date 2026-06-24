package com.avozdedeus.avozdedeusjpc.audio.analysis;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001cR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e\u00a8\u0006 "}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/analysis/OnsetAnalysisTiming;", "", "()V", "lastCacheHit", "", "getLastCacheHit", "()Z", "setLastCacheHit", "(Z)V", "lastCopyMs", "", "getLastCopyMs", "()J", "setLastCopyMs", "(J)V", "lastDecodeMs", "getLastDecodeMs", "setLastDecodeMs", "lastDspMs", "getLastDspMs", "setLastDspMs", "lastFilterMs", "getLastFilterMs", "setLastFilterMs", "lastTotalMs", "getLastTotalMs", "setLastTotalMs", "logPhases", "", "tag", "", "reset", "audio_release"})
public final class OnsetAnalysisTiming {
    private static long lastCopyMs = 0L;
    private static long lastDecodeMs = 0L;
    private static long lastDspMs = 0L;
    private static long lastFilterMs = 0L;
    private static long lastTotalMs = 0L;
    private static boolean lastCacheHit = false;
    @org.jetbrains.annotations.NotNull()
    public static final com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetAnalysisTiming INSTANCE = null;
    
    private OnsetAnalysisTiming() {
        super();
    }
    
    public final long getLastCopyMs() {
        return 0L;
    }
    
    public final void setLastCopyMs(long p0) {
    }
    
    public final long getLastDecodeMs() {
        return 0L;
    }
    
    public final void setLastDecodeMs(long p0) {
    }
    
    public final long getLastDspMs() {
        return 0L;
    }
    
    public final void setLastDspMs(long p0) {
    }
    
    public final long getLastFilterMs() {
        return 0L;
    }
    
    public final void setLastFilterMs(long p0) {
    }
    
    public final long getLastTotalMs() {
        return 0L;
    }
    
    public final void setLastTotalMs(long p0) {
    }
    
    public final boolean getLastCacheHit() {
        return false;
    }
    
    public final void setLastCacheHit(boolean p0) {
    }
    
    public final void reset() {
    }
    
    public final void logPhases(@org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
    }
}