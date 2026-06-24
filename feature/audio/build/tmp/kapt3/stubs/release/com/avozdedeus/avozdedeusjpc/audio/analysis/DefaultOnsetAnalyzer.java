package com.avozdedeus.avozdedeusjpc.audio.analysis;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/analysis/DefaultOnsetAnalyzer;", "Lcom/avozdedeus/avozdedeusjpc/audio/analysis/OnsetAnalyzer;", "application", "Landroid/content/Context;", "sessionCache", "Lcom/avozdedeus/avozdedeusjpc/audio/analysis/OnsetAnalysisSessionCache;", "(Landroid/content/Context;Lcom/avozdedeus/avozdedeusjpc/audio/analysis/OnsetAnalysisSessionCache;)V", "extractor", "Lcom/avozdedeus/avozdedeusjpc/audio/analysis/AudioOnsetTimestampExtractor;", "analyze", "Lcom/avozdedeus/avozdedeusjpc/audio/analysis/OnsetExtractionResult;", "uri", "Landroid/net/Uri;", "audio_release"})
public final class DefaultOnsetAnalyzer implements com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetAnalyzer {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context application = null;
    @org.jetbrains.annotations.NotNull()
    private final com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetAnalysisSessionCache sessionCache = null;
    @org.jetbrains.annotations.NotNull()
    private final com.avozdedeus.avozdedeusjpc.audio.analysis.AudioOnsetTimestampExtractor extractor = null;
    
    @javax.inject.Inject()
    public DefaultOnsetAnalyzer(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context application, @org.jetbrains.annotations.NotNull()
    com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetAnalysisSessionCache sessionCache) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetExtractionResult analyze(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return null;
    }
}