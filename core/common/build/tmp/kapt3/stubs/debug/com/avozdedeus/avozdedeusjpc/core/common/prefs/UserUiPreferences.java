package com.avozdedeus.avozdedeusjpc.core.common.prefs;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H&J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H&J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\nH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u0006\u00a8\u0006\u0012"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/core/common/prefs/UserUiPreferences;", "", "metronomeSectionEnabled", "Lkotlinx/coroutines/flow/StateFlow;", "", "getMetronomeSectionEnabled", "()Lkotlinx/coroutines/flow/StateFlow;", "notesSectionEnabled", "getNotesSectionEnabled", "onsetDetectionThreshold", "", "getOnsetDetectionThreshold", "setMetronomeSectionEnabled", "", "enabled", "setNotesSectionEnabled", "setOnsetDetectionThreshold", "threshold", "common_debug"})
public abstract interface UserUiPreferences {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getMetronomeSectionEnabled();
    
    public abstract void setMetronomeSectionEnabled(boolean enabled);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.StateFlow<java.lang.Float> getOnsetDetectionThreshold();
    
    public abstract void setOnsetDetectionThreshold(float threshold);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getNotesSectionEnabled();
    
    public abstract void setNotesSectionEnabled(boolean enabled);
}