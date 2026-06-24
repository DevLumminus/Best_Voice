package com.avozdedeus.avozdedeusjpc.audio.analysis;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002J \u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0002J \u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/analysis/DefaultAudioKeyAnalyzer;", "Lcom/avozdedeus/avozdedeusjpc/audio/analysis/AudioKeyAnalyzer;", "application", "Landroid/content/Context;", "(Landroid/content/Context;)V", "analyze", "Lcom/avozdedeus/avozdedeusjpc/audio/analysis/AudioKeyAnalysisResult;", "uri", "Landroid/net/Uri;", "buildUriKey", "", "context", "copyUriToCacheFile", "", "outFile", "Ljava/io/File;", "extensionForUri", "resolver", "Landroid/content/ContentResolver;", "queryDisplayName", "querySize", "", "resolveCachedAudioFile", "uriKey", "audio_debug"})
public final class DefaultAudioKeyAnalyzer implements com.avozdedeus.avozdedeusjpc.audio.analysis.AudioKeyAnalyzer {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context application = null;
    
    @javax.inject.Inject()
    public DefaultAudioKeyAnalyzer(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context application) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.avozdedeus.avozdedeusjpc.audio.analysis.AudioKeyAnalysisResult analyze(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return null;
    }
    
    private final java.lang.String buildUriKey(android.content.Context context, android.net.Uri uri) {
        return null;
    }
    
    private final java.io.File resolveCachedAudioFile(android.content.Context context, android.net.Uri uri, java.lang.String uriKey) {
        return null;
    }
    
    private final void copyUriToCacheFile(android.content.Context context, android.net.Uri uri, java.io.File outFile) {
    }
    
    private final java.lang.String extensionForUri(android.content.ContentResolver resolver, android.net.Uri uri) {
        return null;
    }
    
    private final java.lang.String queryDisplayName(android.content.ContentResolver resolver, android.net.Uri uri) {
        return null;
    }
    
    private final long querySize(android.content.ContentResolver resolver, android.net.Uri uri) {
        return 0L;
    }
}