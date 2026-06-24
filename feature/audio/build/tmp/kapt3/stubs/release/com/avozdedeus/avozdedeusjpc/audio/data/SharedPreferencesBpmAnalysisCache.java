package com.avozdedeus.avozdedeusjpc.audio.data;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/data/SharedPreferencesBpmAnalysisCache;", "Lcom/avozdedeus/avozdedeusjpc/audio/data/BpmAnalysisCacheStore;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "keyPrefix", "", "uri", "Landroid/net/Uri;", "load", "Lcom/avozdedeus/avozdedeusjpc/audio/data/CachedBpmAnalysis;", "queryDisplayName", "querySize", "", "save", "", "cached", "audio_release"})
public final class SharedPreferencesBpmAnalysisCache implements com.avozdedeus.avozdedeusjpc.audio.data.BpmAnalysisCacheStore {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences prefs = null;
    
    @javax.inject.Inject()
    public SharedPreferencesBpmAnalysisCache(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public com.avozdedeus.avozdedeusjpc.audio.data.CachedBpmAnalysis load(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return null;
    }
    
    @java.lang.Override()
    public void save(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri, @org.jetbrains.annotations.NotNull()
    com.avozdedeus.avozdedeusjpc.audio.data.CachedBpmAnalysis cached) {
    }
    
    private final java.lang.String keyPrefix(android.net.Uri uri) {
        return null;
    }
    
    private final java.lang.String queryDisplayName(android.net.Uri uri) {
        return null;
    }
    
    private final long querySize(android.net.Uri uri) {
        return 0L;
    }
}