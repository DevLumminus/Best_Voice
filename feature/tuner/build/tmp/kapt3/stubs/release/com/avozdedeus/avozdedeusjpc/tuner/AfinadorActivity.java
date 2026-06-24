package com.avozdedeus.avozdedeusjpc.tuner;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0018H\u0014J\b\u0010\u001c\u001a\u00020\u0018H\u0014J\b\u0010\u001d\u001a\u00020\u0018H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001e"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/tuner/AfinadorActivity;", "Landroidx/activity/ComponentActivity;", "()V", "appNavigator", "Lcom/avozdedeus/avozdedeusjpc/core/navigation/AppNavigator;", "getAppNavigator", "()Lcom/avozdedeus/avozdedeusjpc/core/navigation/AppNavigator;", "setAppNavigator", "(Lcom/avozdedeus/avozdedeusjpc/core/navigation/AppNavigator;)V", "pitchAnalyzer", "Lcom/avozdedeus/avozdedeusjpc/tuner/AudioRecordTunerPitchAnalyzer;", "getPitchAnalyzer", "()Lcom/avozdedeus/avozdedeusjpc/tuner/AudioRecordTunerPitchAnalyzer;", "pitchAnalyzer$delegate", "Lkotlin/Lazy;", "requestMicrophonePermission", "Landroidx/activity/result/ActivityResultLauncher;", "", "viewModel", "Lcom/avozdedeus/avozdedeusjpc/tuner/AfinadorViewModel;", "getViewModel", "()Lcom/avozdedeus/avozdedeusjpc/tuner/AfinadorViewModel;", "viewModel$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "startListeningIfAllowed", "tuner_release"})
public final class AfinadorActivity extends androidx.activity.ComponentActivity {
    @javax.inject.Inject()
    public com.avozdedeus.avozdedeusjpc.core.navigation.AppNavigator appNavigator;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy pitchAnalyzer$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> requestMicrophonePermission = null;
    
    public AfinadorActivity() {
        super(0);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.avozdedeus.avozdedeusjpc.core.navigation.AppNavigator getAppNavigator() {
        return null;
    }
    
    public final void setAppNavigator(@org.jetbrains.annotations.NotNull()
    com.avozdedeus.avozdedeusjpc.core.navigation.AppNavigator p0) {
    }
    
    private final com.avozdedeus.avozdedeusjpc.tuner.AfinadorViewModel getViewModel() {
        return null;
    }
    
    private final com.avozdedeus.avozdedeusjpc.tuner.AudioRecordTunerPitchAnalyzer getPitchAnalyzer() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    @java.lang.Override()
    protected void onStop() {
    }
    
    private final void startListeningIfAllowed() {
    }
}