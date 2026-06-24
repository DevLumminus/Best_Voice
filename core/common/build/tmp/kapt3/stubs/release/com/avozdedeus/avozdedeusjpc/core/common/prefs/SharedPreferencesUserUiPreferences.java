package com.avozdedeus.avozdedeusjpc.core.common.prefs;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007H\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007H\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u000eX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/core/common/prefs/SharedPreferencesUserUiPreferences;", "Lcom/avozdedeus/avozdedeusjpc/core/common/prefs/UserUiPreferences;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_metronomeSectionEnabled", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_notesSectionEnabled", "_onsetDetectionThreshold", "", "listener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "metronomeSectionEnabled", "Lkotlinx/coroutines/flow/StateFlow;", "getMetronomeSectionEnabled", "()Lkotlinx/coroutines/flow/StateFlow;", "notesSectionEnabled", "getNotesSectionEnabled", "onsetDetectionThreshold", "getOnsetDetectionThreshold", "prefs", "Landroid/content/SharedPreferences;", "setMetronomeSectionEnabled", "", "enabled", "setNotesSectionEnabled", "setOnsetDetectionThreshold", "threshold", "common_release"})
public final class SharedPreferencesUserUiPreferences implements com.avozdedeus.avozdedeusjpc.core.common.prefs.UserUiPreferences {
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _metronomeSectionEnabled = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Float> _onsetDetectionThreshold = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _notesSectionEnabled = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences.OnSharedPreferenceChangeListener listener = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> metronomeSectionEnabled = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Float> onsetDetectionThreshold = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> notesSectionEnabled = null;
    
    @javax.inject.Inject()
    public SharedPreferencesUserUiPreferences(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getMetronomeSectionEnabled() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.StateFlow<java.lang.Float> getOnsetDetectionThreshold() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getNotesSectionEnabled() {
        return null;
    }
    
    @java.lang.Override()
    public void setMetronomeSectionEnabled(boolean enabled) {
    }
    
    @java.lang.Override()
    public void setOnsetDetectionThreshold(float threshold) {
    }
    
    @java.lang.Override()
    public void setNotesSectionEnabled(boolean enabled) {
    }
}