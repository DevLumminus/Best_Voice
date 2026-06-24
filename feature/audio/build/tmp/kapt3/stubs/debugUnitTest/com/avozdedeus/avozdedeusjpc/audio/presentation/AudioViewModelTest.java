package com.avozdedeus.avozdedeusjpc.audio.presentation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0004\u0019\u001a\u001b\u001cB\u0005\u00a2\u0006\u0002\u0010\u0002J\f\u0010\r\u001a\u00060\u000ej\u0002`\u000fH\u0007J\f\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0007J\b\u0010\u0011\u001a\u00020\u000eH\u0007J\b\u0010\u0012\u001a\u00020\u000eH\u0007J\b\u0010\u0013\u001a\u00020\u000eH\u0007J\b\u0010\u0014\u001a\u00020\u000eH\u0007J\b\u0010\u0015\u001a\u00020\u000eH\u0007J\b\u0010\u0016\u001a\u00020\u000eH\u0007J\b\u0010\u0017\u001a\u00020\u000eH\u0007J\b\u0010\u0018\u001a\u00020\u000eH\u0007R\u0013\u0010\u0003\u001a\u00020\u00048G\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/presentation/AudioViewModelTest;", "", "()V", "mainDispatcherRule", "Lcom/avozdedeus/avozdedeusjpc/audio/presentation/MainDispatcherRule;", "getMainDispatcherRule", "()Lcom/avozdedeus/avozdedeusjpc/audio/presentation/MainDispatcherRule;", "noopBpmAnalysisCache", "Lcom/avozdedeus/avozdedeusjpc/audio/data/BpmAnalysisCacheStore;", "noopOnsetAnalyzer", "Lcom/avozdedeus/avozdedeusjpc/audio/analysis/OnsetAnalyzer;", "noopUserUiPreferences", "Lcom/avozdedeus/avozdedeusjpc/core/common/prefs/UserUiPreferences;", "cached bpm read uses cache", "", "Lkotlinx/coroutines/test/TestResult;", "force refresh analyzes and saves bpm cache", "initializeFromIntent only seeds pending audio once", "metronome starts in manual mode with empty bpm and default meter", "refreshFromStoredSelection hydrates the ui state from persisted session", "repeat and speed actions update ui state and store", "select metronome meter updates the visible meter and beat count", "tap tempo timeout clears manual bpm", "tap tempo updates manual bpm after the second tap", "tone actions snap values and persist tone", "Companion", "CountingOnsetAnalyzer", "FakeAudioSessionStore", "FakeBpmAnalysisCache", "audio_debugUnitTest"})
@kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
public final class AudioViewModelTest {
    @org.jetbrains.annotations.NotNull()
    private final com.avozdedeus.avozdedeusjpc.audio.presentation.MainDispatcherRule mainDispatcherRule = null;
    @org.jetbrains.annotations.NotNull()
    private final com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetAnalyzer noopOnsetAnalyzer = null;
    @org.jetbrains.annotations.NotNull()
    private final com.avozdedeus.avozdedeusjpc.audio.data.BpmAnalysisCacheStore noopBpmAnalysisCache = null;
    @org.jetbrains.annotations.NotNull()
    private final com.avozdedeus.avozdedeusjpc.core.common.prefs.UserUiPreferences noopUserUiPreferences = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.avozdedeus.avozdedeusjpc.audio.presentation.AudioViewModelTest.Companion Companion = null;
    
    public AudioViewModelTest() {
        super();
    }
    
    @org.junit.Rule()
    @org.jetbrains.annotations.NotNull()
    public final com.avozdedeus.avozdedeusjpc.audio.presentation.MainDispatcherRule getMainDispatcherRule() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JC\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/presentation/AudioViewModelTest$Companion;", "", "()V", "storedSelection", "Lcom/avozdedeus/avozdedeusjpc/audio/data/StoredAudioSelection;", "playbackSpeed", "", "toneSemitones", "repeatMode", "", "repeatPointA", "", "repeatPointB", "(FFILjava/lang/Long;Ljava/lang/Long;)Lcom/avozdedeus/avozdedeusjpc/audio/data/StoredAudioSelection;", "audio_debugUnitTest"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        private final com.avozdedeus.avozdedeusjpc.audio.data.StoredAudioSelection storedSelection(float playbackSpeed, float toneSemitones, int repeatMode, java.lang.Long repeatPointA, java.lang.Long repeatPointB) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/presentation/AudioViewModelTest$CountingOnsetAnalyzer;", "Lcom/avozdedeus/avozdedeusjpc/audio/analysis/OnsetAnalyzer;", "result", "Lcom/avozdedeus/avozdedeusjpc/audio/analysis/OnsetExtractionResult;", "(Lcom/avozdedeus/avozdedeusjpc/audio/analysis/OnsetExtractionResult;)V", "callCount", "", "getCallCount", "()I", "setCallCount", "(I)V", "analyze", "uri", "Landroid/net/Uri;", "audio_debugUnitTest"})
    static final class CountingOnsetAnalyzer implements com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetAnalyzer {
        @org.jetbrains.annotations.NotNull()
        private final com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetExtractionResult result = null;
        private int callCount = 0;
        
        public CountingOnsetAnalyzer(@org.jetbrains.annotations.NotNull()
        com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetExtractionResult result) {
            super();
        }
        
        public final int getCallCount() {
            return 0;
        }
        
        public final void setCallCount(int p0) {
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetExtractionResult analyze(@org.jetbrains.annotations.NotNull()
        android.net.Uri uri) {
            return null;
        }
        
        public CountingOnsetAnalyzer() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010 \u001a\u00020!H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010\'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u0006H\u0016J\u0010\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020\u0014H\u0016J!\u0010+\u001a\u00020!2\b\u0010,\u001a\u0004\u0018\u00010\u00142\b\u0010-\u001a\u0004\u0018\u00010\u0014H\u0016\u00a2\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\rH\u0016J\u0010\u00101\u001a\u00020!2\u0006\u00102\u001a\u00020\u0006H\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u001e\u0010\b\"\u0004\b\u001f\u0010\nR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/presentation/AudioViewModelTest$FakeAudioSessionStore;", "Lcom/avozdedeus/avozdedeusjpc/audio/data/AudioSessionStore;", "selection", "Lcom/avozdedeus/avozdedeusjpc/audio/data/StoredAudioSelection;", "(Lcom/avozdedeus/avozdedeusjpc/audio/data/StoredAudioSelection;)V", "lastPlaybackSpeed", "", "getLastPlaybackSpeed", "()Ljava/lang/Float;", "setLastPlaybackSpeed", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "lastRepeatMode", "", "getLastRepeatMode", "()Ljava/lang/Integer;", "setLastRepeatMode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "lastRepeatPointA", "", "getLastRepeatPointA", "()Ljava/lang/Long;", "setLastRepeatPointA", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "lastRepeatPointB", "getLastRepeatPointB", "setLastRepeatPointB", "lastToneSemitones", "getLastToneSemitones", "setLastToneSemitones", "clear", "", "loadSelection", "saveSelection", "updatePlayWhenReady", "playWhenReady", "", "updatePlaybackSpeed", "playbackSpeed", "updatePosition", "positionMs", "updateRepeatMarkers", "repeatPointA", "repeatPointB", "(Ljava/lang/Long;Ljava/lang/Long;)V", "updateRepeatMode", "repeatMode", "updateToneSemitones", "toneSemitones", "audio_debugUnitTest"})
    static final class FakeAudioSessionStore implements com.avozdedeus.avozdedeusjpc.audio.data.AudioSessionStore {
        @org.jetbrains.annotations.Nullable()
        private com.avozdedeus.avozdedeusjpc.audio.data.StoredAudioSelection selection;
        @org.jetbrains.annotations.Nullable()
        private java.lang.Float lastPlaybackSpeed;
        @org.jetbrains.annotations.Nullable()
        private java.lang.Float lastToneSemitones;
        @org.jetbrains.annotations.Nullable()
        private java.lang.Integer lastRepeatMode;
        @org.jetbrains.annotations.Nullable()
        private java.lang.Long lastRepeatPointA;
        @org.jetbrains.annotations.Nullable()
        private java.lang.Long lastRepeatPointB;
        
        public FakeAudioSessionStore(@org.jetbrains.annotations.Nullable()
        com.avozdedeus.avozdedeusjpc.audio.data.StoredAudioSelection selection) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Float getLastPlaybackSpeed() {
            return null;
        }
        
        public final void setLastPlaybackSpeed(@org.jetbrains.annotations.Nullable()
        java.lang.Float p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Float getLastToneSemitones() {
            return null;
        }
        
        public final void setLastToneSemitones(@org.jetbrains.annotations.Nullable()
        java.lang.Float p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getLastRepeatMode() {
            return null;
        }
        
        public final void setLastRepeatMode(@org.jetbrains.annotations.Nullable()
        java.lang.Integer p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Long getLastRepeatPointA() {
            return null;
        }
        
        public final void setLastRepeatPointA(@org.jetbrains.annotations.Nullable()
        java.lang.Long p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Long getLastRepeatPointB() {
            return null;
        }
        
        public final void setLastRepeatPointB(@org.jetbrains.annotations.Nullable()
        java.lang.Long p0) {
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
        
        public FakeAudioSessionStore() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/presentation/AudioViewModelTest$FakeBpmAnalysisCache;", "Lcom/avozdedeus/avozdedeusjpc/audio/data/BpmAnalysisCacheStore;", "cached", "Lcom/avozdedeus/avozdedeusjpc/audio/data/CachedBpmAnalysis;", "(Lcom/avozdedeus/avozdedeusjpc/audio/data/CachedBpmAnalysis;)V", "lastSaved", "getLastSaved", "()Lcom/avozdedeus/avozdedeusjpc/audio/data/CachedBpmAnalysis;", "setLastSaved", "loadCount", "", "getLoadCount", "()I", "setLoadCount", "(I)V", "saveCount", "getSaveCount", "setSaveCount", "load", "uri", "Landroid/net/Uri;", "save", "", "audio_debugUnitTest"})
    static final class FakeBpmAnalysisCache implements com.avozdedeus.avozdedeusjpc.audio.data.BpmAnalysisCacheStore {
        @org.jetbrains.annotations.Nullable()
        private final com.avozdedeus.avozdedeusjpc.audio.data.CachedBpmAnalysis cached = null;
        private int loadCount = 0;
        private int saveCount = 0;
        @org.jetbrains.annotations.Nullable()
        private com.avozdedeus.avozdedeusjpc.audio.data.CachedBpmAnalysis lastSaved;
        
        public FakeBpmAnalysisCache(@org.jetbrains.annotations.Nullable()
        com.avozdedeus.avozdedeusjpc.audio.data.CachedBpmAnalysis cached) {
            super();
        }
        
        public final int getLoadCount() {
            return 0;
        }
        
        public final void setLoadCount(int p0) {
        }
        
        public final int getSaveCount() {
            return 0;
        }
        
        public final void setSaveCount(int p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.avozdedeus.avozdedeusjpc.audio.data.CachedBpmAnalysis getLastSaved() {
            return null;
        }
        
        public final void setLastSaved(@org.jetbrains.annotations.Nullable()
        com.avozdedeus.avozdedeusjpc.audio.data.CachedBpmAnalysis p0) {
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
        
        public FakeBpmAnalysisCache() {
            super();
        }
    }
}