package com.avozdedeus.avozdedeusjpc.audio.analysis;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0002\u00a2\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/analysis/OnsetAnalysisSessionCache;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "databaseFile", "Ljava/io/File;", "helper", "Lcom/avozdedeus/avozdedeusjpc/audio/analysis/OnsetCandidateDatabase;", "appendCandidates", "", "sessionKey", "", "candidates", "", "Lcom/avozdedeus/avozdedeusjpc/audio/analysis/OnsetCandidate;", "averageSalience", "", "(Ljava/lang/String;)Ljava/lang/Double;", "clear", "loadFilteredByAverageSalience", "audio_release"})
public final class OnsetAnalysisSessionCache {
    @org.jetbrains.annotations.NotNull()
    private final java.io.File databaseFile = null;
    @org.jetbrains.annotations.NotNull()
    private final com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetCandidateDatabase helper = null;
    
    @javax.inject.Inject()
    public OnsetAnalysisSessionCache(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final void clear(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionKey) {
    }
    
    public final void appendCandidates(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionKey, @org.jetbrains.annotations.NotNull()
    java.util.List<com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetCandidate> candidates) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetCandidate> loadFilteredByAverageSalience(@org.jetbrains.annotations.NotNull()
    java.lang.String sessionKey) {
        return null;
    }
    
    private final java.lang.Double averageSalience(java.lang.String sessionKey) {
        return null;
    }
}