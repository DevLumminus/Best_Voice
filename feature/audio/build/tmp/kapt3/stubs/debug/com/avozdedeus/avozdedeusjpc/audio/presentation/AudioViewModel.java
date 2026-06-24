package com.avozdedeus.avozdedeusjpc.audio.presentation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0006\u0010\u001c\u001a\u00020\u001bJ\u001a\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!J\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u001fH\u0002J\u0018\u0010\'\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u0013H\u0002J\u0006\u0010)\u001a\u00020\u001bJ\u001f\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u00112\b\u0010-\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0002\u0010.R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/presentation/AudioViewModel;", "Landroidx/lifecycle/ViewModel;", "audioSessionRepository", "Lcom/avozdedeus/avozdedeusjpc/audio/data/AudioSessionStore;", "onsetAnalyzer", "Lcom/avozdedeus/avozdedeusjpc/audio/analysis/OnsetAnalyzer;", "bpmAnalysisCache", "Lcom/avozdedeus/avozdedeusjpc/audio/data/BpmAnalysisCacheStore;", "audioKeyAnalyzer", "Lcom/avozdedeus/avozdedeusjpc/audio/analysis/AudioKeyAnalyzer;", "userUiPreferences", "Lcom/avozdedeus/avozdedeusjpc/core/common/prefs/UserUiPreferences;", "(Lcom/avozdedeus/avozdedeusjpc/audio/data/AudioSessionStore;Lcom/avozdedeus/avozdedeusjpc/audio/analysis/OnsetAnalyzer;Lcom/avozdedeus/avozdedeusjpc/audio/data/BpmAnalysisCacheStore;Lcom/avozdedeus/avozdedeusjpc/audio/analysis/AudioKeyAnalyzer;Lcom/avozdedeus/avozdedeusjpc/core/common/prefs/UserUiPreferences;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/avozdedeus/avozdedeusjpc/audio/presentation/AudioUiState;", "audioKeyRequestId", "", "hasInitializedIntent", "", "tapTempoCalculator", "Lcom/avozdedeus/avozdedeusjpc/audio/domain/TapTempoCalculator;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "clearAudioKey", "", "consumePendingIntentAudio", "initializeFromIntent", "audioUri", "Landroid/net/Uri;", "audioFileName", "", "onAction", "action", "Lcom/avozdedeus/avozdedeusjpc/audio/presentation/AudioUiAction;", "readAudioKey", "uri", "readBpm", "forceRefresh", "refreshFromStoredSelection", "updateRepeatMarkers", "Lcom/avozdedeus/avozdedeusjpc/audio/domain/RepeatMarkerState;", "repeatPointA", "repeatPointB", "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/avozdedeus/avozdedeusjpc/audio/domain/RepeatMarkerState;", "audio_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AudioViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.avozdedeus.avozdedeusjpc.audio.data.AudioSessionStore audioSessionRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetAnalyzer onsetAnalyzer = null;
    @org.jetbrains.annotations.NotNull()
    private final com.avozdedeus.avozdedeusjpc.audio.data.BpmAnalysisCacheStore bpmAnalysisCache = null;
    @org.jetbrains.annotations.NotNull()
    private final com.avozdedeus.avozdedeusjpc.audio.analysis.AudioKeyAnalyzer audioKeyAnalyzer = null;
    @org.jetbrains.annotations.NotNull()
    private final com.avozdedeus.avozdedeusjpc.core.common.prefs.UserUiPreferences userUiPreferences = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.avozdedeus.avozdedeusjpc.audio.presentation.AudioUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.avozdedeus.avozdedeusjpc.audio.presentation.AudioUiState> uiState = null;
    private boolean hasInitializedIntent = false;
    private long audioKeyRequestId = 0L;
    @org.jetbrains.annotations.NotNull()
    private final com.avozdedeus.avozdedeusjpc.audio.domain.TapTempoCalculator tapTempoCalculator = null;
    
    @javax.inject.Inject()
    public AudioViewModel(@org.jetbrains.annotations.NotNull()
    com.avozdedeus.avozdedeusjpc.audio.data.AudioSessionStore audioSessionRepository, @org.jetbrains.annotations.NotNull()
    com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetAnalyzer onsetAnalyzer, @org.jetbrains.annotations.NotNull()
    com.avozdedeus.avozdedeusjpc.audio.data.BpmAnalysisCacheStore bpmAnalysisCache, @org.jetbrains.annotations.NotNull()
    com.avozdedeus.avozdedeusjpc.audio.analysis.AudioKeyAnalyzer audioKeyAnalyzer, @org.jetbrains.annotations.NotNull()
    com.avozdedeus.avozdedeusjpc.core.common.prefs.UserUiPreferences userUiPreferences) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.avozdedeus.avozdedeusjpc.audio.presentation.AudioUiState> getUiState() {
        return null;
    }
    
    public final void initializeFromIntent(@org.jetbrains.annotations.Nullable()
    android.net.Uri audioUri, @org.jetbrains.annotations.Nullable()
    java.lang.String audioFileName) {
    }
    
    public final void consumePendingIntentAudio() {
    }
    
    public final void refreshFromStoredSelection() {
    }
    
    public final void onAction(@org.jetbrains.annotations.NotNull()
    com.avozdedeus.avozdedeusjpc.audio.presentation.AudioUiAction action) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.avozdedeus.avozdedeusjpc.audio.domain.RepeatMarkerState updateRepeatMarkers(@org.jetbrains.annotations.Nullable()
    java.lang.Long repeatPointA, @org.jetbrains.annotations.Nullable()
    java.lang.Long repeatPointB) {
        return null;
    }
    
    private final void readAudioKey(android.net.Uri uri) {
    }
    
    private final void clearAudioKey() {
    }
    
    private final void readBpm(android.net.Uri uri, boolean forceRefresh) {
    }
}