package com.avozdedeus.avozdedeusjpc.audio.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H&\u00a8\u0006\t"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/data/BpmAnalysisCacheStore;", "", "load", "Lcom/avozdedeus/avozdedeusjpc/audio/data/CachedBpmAnalysis;", "uri", "Landroid/net/Uri;", "save", "", "cached", "audio_debug"})
public abstract interface BpmAnalysisCacheStore {
    
    @org.jetbrains.annotations.Nullable()
    public abstract com.avozdedeus.avozdedeusjpc.audio.data.CachedBpmAnalysis load(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri);
    
    public abstract void save(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri, @org.jetbrains.annotations.NotNull()
    com.avozdedeus.avozdedeusjpc.audio.data.CachedBpmAnalysis cached);
}