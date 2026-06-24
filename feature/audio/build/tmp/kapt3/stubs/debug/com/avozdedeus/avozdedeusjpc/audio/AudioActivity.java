package com.avozdedeus.avozdedeusjpc.audio;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/AudioActivity;", "Landroidx/activity/ComponentActivity;", "()V", "appNavigator", "Lcom/avozdedeus/avozdedeusjpc/core/navigation/AppNavigator;", "getAppNavigator", "()Lcom/avozdedeus/avozdedeusjpc/core/navigation/AppNavigator;", "setAppNavigator", "(Lcom/avozdedeus/avozdedeusjpc/core/navigation/AppNavigator;)V", "audioMediaControllerCoordinator", "Lcom/avozdedeus/avozdedeusjpc/audio/data/AudioMediaControllerCoordinator;", "getAudioMediaControllerCoordinator", "()Lcom/avozdedeus/avozdedeusjpc/audio/data/AudioMediaControllerCoordinator;", "setAudioMediaControllerCoordinator", "(Lcom/avozdedeus/avozdedeusjpc/audio/data/AudioMediaControllerCoordinator;)V", "viewModel", "Lcom/avozdedeus/avozdedeusjpc/audio/presentation/AudioViewModel;", "getViewModel", "()Lcom/avozdedeus/avozdedeusjpc/audio/presentation/AudioViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "audio_debug"})
public final class AudioActivity extends androidx.activity.ComponentActivity {
    @jakarta.inject.Inject()
    public com.avozdedeus.avozdedeusjpc.core.navigation.AppNavigator appNavigator;
    @jakarta.inject.Inject()
    public com.avozdedeus.avozdedeusjpc.audio.data.AudioMediaControllerCoordinator audioMediaControllerCoordinator;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    
    public AudioActivity() {
        super(0);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.avozdedeus.avozdedeusjpc.core.navigation.AppNavigator getAppNavigator() {
        return null;
    }
    
    public final void setAppNavigator(@org.jetbrains.annotations.NotNull()
    com.avozdedeus.avozdedeusjpc.core.navigation.AppNavigator p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.avozdedeus.avozdedeusjpc.audio.data.AudioMediaControllerCoordinator getAudioMediaControllerCoordinator() {
        return null;
    }
    
    public final void setAudioMediaControllerCoordinator(@org.jetbrains.annotations.NotNull()
    com.avozdedeus.avozdedeusjpc.audio.data.AudioMediaControllerCoordinator p0) {
    }
    
    private final com.avozdedeus.avozdedeusjpc.audio.presentation.AudioViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
}