package com.avozdedeus.avozdedeusjpc.settings;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/settings/ConfigViewModel;", "Landroidx/lifecycle/ViewModel;", "userUiPreferences", "Lcom/avozdedeus/avozdedeusjpc/core/common/prefs/UserUiPreferences;", "(Lcom/avozdedeus/avozdedeusjpc/core/common/prefs/UserUiPreferences;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/avozdedeus/avozdedeusjpc/settings/ConfigUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "onMetronomeSectionChecked", "", "enabled", "", "onNotesSectionChecked", "settings_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ConfigViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.avozdedeus.avozdedeusjpc.core.common.prefs.UserUiPreferences userUiPreferences = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.avozdedeus.avozdedeusjpc.settings.ConfigUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.avozdedeus.avozdedeusjpc.settings.ConfigUiState> uiState = null;
    
    @javax.inject.Inject()
    public ConfigViewModel(@org.jetbrains.annotations.NotNull()
    com.avozdedeus.avozdedeusjpc.core.common.prefs.UserUiPreferences userUiPreferences) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.avozdedeus.avozdedeusjpc.settings.ConfigUiState> getUiState() {
        return null;
    }
    
    public final void onMetronomeSectionChecked(boolean enabled) {
    }
    
    public final void onNotesSectionChecked(boolean enabled) {
    }
}