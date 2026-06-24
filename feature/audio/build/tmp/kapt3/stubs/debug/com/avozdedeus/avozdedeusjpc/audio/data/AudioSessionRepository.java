package com.avozdedeus.avozdedeusjpc.audio.data;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J!\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015H\u0016\u00a2\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/data/AudioSessionRepository;", "Lcom/avozdedeus/avozdedeusjpc/audio/data/AudioSessionStore;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "clear", "", "currentBootCount", "", "loadSelection", "Lcom/avozdedeus/avozdedeusjpc/audio/data/StoredAudioSelection;", "saveSelection", "selection", "updatePlayWhenReady", "playWhenReady", "", "updatePlaybackSpeed", "playbackSpeed", "", "updatePosition", "positionMs", "", "updateRepeatMarkers", "repeatPointA", "repeatPointB", "(Ljava/lang/Long;Ljava/lang/Long;)V", "updateRepeatMode", "repeatMode", "updateToneSemitones", "toneSemitones", "audio_debug"})
public final class AudioSessionRepository implements com.avozdedeus.avozdedeusjpc.audio.data.AudioSessionStore {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    @javax.inject.Inject()
    public AudioSessionRepository(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public com.avozdedeus.avozdedeusjpc.audio.data.StoredAudioSelection loadSelection() {
        return null;
    }
    
    @java.lang.Override()
    public void saveSelection(@org.jetbrains.annotations.NotNull()
    com.avozdedeus.avozdedeusjpc.audio.data.StoredAudioSelection selection) {
    }
    
    @java.lang.Override()
    public void updatePosition(long positionMs) {
    }
    
    @java.lang.Override()
    public void updatePlaybackSpeed(float playbackSpeed) {
    }
    
    @java.lang.Override()
    public void updateToneSemitones(float toneSemitones) {
    }
    
    @java.lang.Override()
    public void updateRepeatMode(int repeatMode) {
    }
    
    @java.lang.Override()
    public void updatePlayWhenReady(boolean playWhenReady) {
    }
    
    @java.lang.Override()
    public void updateRepeatMarkers(@org.jetbrains.annotations.Nullable()
    java.lang.Long repeatPointA, @org.jetbrains.annotations.Nullable()
    java.lang.Long repeatPointB) {
    }
    
    @java.lang.Override()
    public void clear() {
    }
    
    private final int currentBootCount() {
        return 0;
    }
}