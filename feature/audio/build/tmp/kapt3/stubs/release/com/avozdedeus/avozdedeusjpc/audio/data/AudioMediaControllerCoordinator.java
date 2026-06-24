package com.avozdedeus.avozdedeusjpc.audio.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/data/AudioMediaControllerCoordinator;", "", "sessionRepository", "Lcom/avozdedeus/avozdedeusjpc/audio/data/AudioSessionRepository;", "(Lcom/avozdedeus/avozdedeusjpc/audio/data/AudioSessionRepository;)V", "selectAudio", "", "context", "Landroid/content/Context;", "controller", "Landroidx/media3/session/MediaController;", "request", "Lcom/avozdedeus/avozdedeusjpc/audio/data/AudioSelectionRequest;", "(Landroid/content/Context;Landroidx/media3/session/MediaController;Lcom/avozdedeus/avozdedeusjpc/audio/data/AudioSelectionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "audio_release"})
public final class AudioMediaControllerCoordinator {
    @org.jetbrains.annotations.NotNull()
    private final com.avozdedeus.avozdedeusjpc.audio.data.AudioSessionRepository sessionRepository = null;
    
    @javax.inject.Inject()
    public AudioMediaControllerCoordinator(@org.jetbrains.annotations.NotNull()
    com.avozdedeus.avozdedeusjpc.audio.data.AudioSessionRepository sessionRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object selectAudio(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    androidx.media3.session.MediaController controller, @org.jetbrains.annotations.NotNull()
    com.avozdedeus.avozdedeusjpc.audio.data.AudioSelectionRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}