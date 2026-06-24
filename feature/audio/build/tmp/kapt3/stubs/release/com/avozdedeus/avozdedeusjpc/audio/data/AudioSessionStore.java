package com.avozdedeus.avozdedeusjpc.audio.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J!\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H&\u00a2\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\rH&\u00a8\u0006\u001a"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/data/AudioSessionStore;", "", "clear", "", "loadSelection", "Lcom/avozdedeus/avozdedeusjpc/audio/data/StoredAudioSelection;", "saveSelection", "selection", "updatePlayWhenReady", "playWhenReady", "", "updatePlaybackSpeed", "playbackSpeed", "", "updatePosition", "positionMs", "", "updateRepeatMarkers", "repeatPointA", "repeatPointB", "(Ljava/lang/Long;Ljava/lang/Long;)V", "updateRepeatMode", "repeatMode", "", "updateToneSemitones", "toneSemitones", "audio_release"})
public abstract interface AudioSessionStore {
    
    @org.jetbrains.annotations.Nullable()
    public abstract com.avozdedeus.avozdedeusjpc.audio.data.StoredAudioSelection loadSelection();
    
    public abstract void saveSelection(@org.jetbrains.annotations.NotNull()
    com.avozdedeus.avozdedeusjpc.audio.data.StoredAudioSelection selection);
    
    public abstract void updatePosition(long positionMs);
    
    public abstract void updatePlaybackSpeed(float playbackSpeed);
    
    public abstract void updateToneSemitones(float toneSemitones);
    
    public abstract void updateRepeatMode(int repeatMode);
    
    public abstract void updatePlayWhenReady(boolean playWhenReady);
    
    public abstract void updateRepeatMarkers(@org.jetbrains.annotations.Nullable()
    java.lang.Long repeatPointA, @org.jetbrains.annotations.Nullable()
    java.lang.Long repeatPointB);
    
    public abstract void clear();
}