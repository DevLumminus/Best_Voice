package com.avozdedeus.avozdedeusjpc.audio.analysis;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J \u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nH\u0002J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nH\u0002J \u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\u0018\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/analysis/AudioOnsetTimestampExtractor;", "", "sessionCache", "Lcom/avozdedeus/avozdedeusjpc/audio/analysis/OnsetAnalysisSessionCache;", "(Lcom/avozdedeus/avozdedeusjpc/audio/analysis/OnsetAnalysisSessionCache;)V", "buildUriKey", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "copyUriToCacheFile", "", "outFile", "Ljava/io/File;", "extensionForUri", "resolver", "Landroid/content/ContentResolver;", "extract", "Lcom/avozdedeus/avozdedeusjpc/audio/analysis/OnsetExtractionResult;", "failureMessage", "t", "", "queryDisplayName", "querySize", "", "resolveCachedAudioFile", "uriKey", "runDispatcher", "audioFile", "sessionKey", "audio_release"})
public final class AudioOnsetTimestampExtractor {
    @org.jetbrains.annotations.NotNull()
    private final com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetAnalysisSessionCache sessionCache = null;
    
    public AudioOnsetTimestampExtractor(@org.jetbrains.annotations.NotNull()
    com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetAnalysisSessionCache sessionCache) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetExtractionResult extract(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return null;
    }
    
    private final java.lang.String buildUriKey(android.content.Context context, android.net.Uri uri) {
        return null;
    }
    
    private final long querySize(android.content.ContentResolver resolver, android.net.Uri uri) {
        return 0L;
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
    
    private final java.lang.String failureMessage(java.lang.Throwable t) {
        return null;
    }
    
    private final void runDispatcher(java.io.File audioFile, java.lang.String sessionKey) {
    }
}