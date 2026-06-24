package com.avozdedeus.avozdedeusjpc.tuner;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001bJ\u0006\u0010 \u001a\u00020\u001bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0011R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\""}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/tuner/AfinadorViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/avozdedeus/avozdedeusjpc/tuner/AfinadorUiState;", "currentTimeMillis", "Lkotlin/Function0;", "", "getCurrentTimeMillis$tuner_release", "()Lkotlin/jvm/functions/Function0;", "setCurrentTimeMillis$tuner_release", "(Lkotlin/jvm/functions/Function0;)V", "hasShownAllTunedDialog", "", "smoothedMeterCents", "", "Ljava/lang/Double;", "stableStartMillis", "Ljava/lang/Long;", "stableStringId", "Lcom/avozdedeus/avozdedeusjpc/tuner/GuitarStringId;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "onAllTunedDialogDismissed", "", "onPitchDetected", "frequencyHz", "", "onPitchLost", "resetTuner", "Companion", "tuner_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AfinadorViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.avozdedeus.avozdedeusjpc.tuner.AfinadorUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.avozdedeus.avozdedeusjpc.tuner.AfinadorUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function0<java.lang.Long> currentTimeMillis;
    @org.jetbrains.annotations.Nullable()
    private com.avozdedeus.avozdedeusjpc.tuner.GuitarStringId stableStringId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Long stableStartMillis;
    private boolean hasShownAllTunedDialog = false;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Double smoothedMeterCents;
    @java.lang.Deprecated()
    public static final double TUNING_TOLERANCE_CENTS = 1.0;
    @java.lang.Deprecated()
    public static final long REQUIRED_STABLE_DURATION_MS = 500L;
    @java.lang.Deprecated()
    public static final double METER_SMOOTHING_PREVIOUS = 0.75;
    @java.lang.Deprecated()
    public static final double METER_SMOOTHING_NEW = 0.25;
    @org.jetbrains.annotations.NotNull()
    private static final com.avozdedeus.avozdedeusjpc.tuner.AfinadorViewModel.Companion Companion = null;
    
    @javax.inject.Inject()
    public AfinadorViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.avozdedeus.avozdedeusjpc.tuner.AfinadorUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<java.lang.Long> getCurrentTimeMillis$tuner_release() {
        return null;
    }
    
    public final void setCurrentTimeMillis$tuner_release(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<java.lang.Long> p0) {
    }
    
    public final void onPitchDetected(float frequencyHz) {
    }
    
    public final void onPitchLost() {
    }
    
    public final void onAllTunedDialogDismissed() {
    }
    
    public final void resetTuner() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/tuner/AfinadorViewModel$Companion;", "", "()V", "METER_SMOOTHING_NEW", "", "METER_SMOOTHING_PREVIOUS", "REQUIRED_STABLE_DURATION_MS", "", "TUNING_TOLERANCE_CENTS", "tuner_release"})
    static final class Companion {
        
        private Companion() {
            super();
        }
    }
}