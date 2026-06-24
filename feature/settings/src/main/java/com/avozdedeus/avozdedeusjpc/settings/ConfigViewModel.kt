package com.avozdedeus.avozdedeusjpc.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.avozdedeus.avozdedeusjpc.core.common.prefs.UserUiPreferences
import com.avozdedeus.avozdedeusjpc.core.navigation.AppDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class ConfigUiState(
    val currentDestination: AppDestination = AppDestination.SETTINGS,
    val metronomeSectionEnabled: Boolean = false,
    val notesSectionEnabled: Boolean = false
)

@HiltViewModel
class ConfigViewModel @Inject constructor(
    private val userUiPreferences: UserUiPreferences
) : ViewModel() {

    private val _uiState = MutableStateFlow(ConfigUiState())
    val uiState: StateFlow<ConfigUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.Default) {
            userUiPreferences.metronomeSectionEnabled.collect { enabled ->
                _uiState.update { state ->
                    state.copy(metronomeSectionEnabled = enabled)
                }
            }
        }
        viewModelScope.launch(Dispatchers.Default) {
            userUiPreferences.notesSectionEnabled.collect { enabled ->
                _uiState.update { state ->
                    state.copy(notesSectionEnabled = enabled)
                }
            }
        }
    }

    fun onMetronomeSectionChecked(enabled: Boolean) {
        userUiPreferences.setMetronomeSectionEnabled(enabled)
    }

    fun onNotesSectionChecked(enabled: Boolean) {
        userUiPreferences.setNotesSectionEnabled(enabled)
    }
}
