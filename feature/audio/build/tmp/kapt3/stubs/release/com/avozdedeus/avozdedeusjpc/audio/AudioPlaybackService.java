package com.avozdedeus.avozdedeusjpc.audio;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0003J\b\u0010 \u001a\u00020\u0015H\u0002J\b\u0010!\u001a\u00020\u0015H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/AudioPlaybackService;", "Landroidx/media3/session/MediaSessionService;", "()V", "audioSessionRepository", "Lcom/avozdedeus/avozdedeusjpc/audio/data/AudioSessionRepository;", "getAudioSessionRepository", "()Lcom/avozdedeus/avozdedeusjpc/audio/data/AudioSessionRepository;", "setAudioSessionRepository", "(Lcom/avozdedeus/avozdedeusjpc/audio/data/AudioSessionRepository;)V", "mediaSession", "Landroidx/media3/session/MediaSession;", "persistenceJob", "Lkotlinx/coroutines/Job;", "player", "Landroidx/media3/exoplayer/ExoPlayer;", "repeatLoopJob", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "createSessionActivity", "Landroid/app/PendingIntent;", "onCreate", "", "onDestroy", "onGetSession", "controllerInfo", "Landroidx/media3/session/MediaSession$ControllerInfo;", "onTaskRemoved", "rootIntent", "Landroid/content/Intent;", "persistPlayerState", "restoreStoredSelection", "setForegroundServiceTypeForMediaPlayback", "startPersistenceJob", "startRepeatLoopMonitor", "audio_release"})
public final class AudioPlaybackService extends androidx.media3.session.MediaSessionService {
    @javax.inject.Inject()
    public com.avozdedeus.avozdedeusjpc.audio.data.AudioSessionRepository audioSessionRepository;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope serviceScope = null;
    @org.jetbrains.annotations.Nullable()
    private androidx.media3.session.MediaSession mediaSession;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job persistenceJob;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job repeatLoopJob;
    private androidx.media3.exoplayer.ExoPlayer player;
    
    public AudioPlaybackService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.avozdedeus.avozdedeusjpc.audio.data.AudioSessionRepository getAudioSessionRepository() {
        return null;
    }
    
    public final void setAudioSessionRepository(@org.jetbrains.annotations.NotNull()
    com.avozdedeus.avozdedeusjpc.audio.data.AudioSessionRepository p0) {
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public androidx.media3.session.MediaSession onGetSession(@org.jetbrains.annotations.NotNull()
    androidx.media3.session.MediaSession.ControllerInfo controllerInfo) {
        return null;
    }
    
    @java.lang.Override()
    public void onTaskRemoved(@org.jetbrains.annotations.Nullable()
    android.content.Intent rootIntent) {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    private final void restoreStoredSelection() {
    }
    
    private final void startPersistenceJob() {
    }
    
    private final void startRepeatLoopMonitor() {
    }
    
    private final void persistPlayerState() {
    }
    
    private final android.app.PendingIntent createSessionActivity() {
        return null;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.S)
    private final void setForegroundServiceTypeForMediaPlayback() {
    }
}