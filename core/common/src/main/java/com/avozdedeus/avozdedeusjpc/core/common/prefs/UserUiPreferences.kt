package com.avozdedeus.avozdedeusjpc.core.common.prefs

import kotlinx.coroutines.flow.StateFlow

interface UserUiPreferences {
    val metronomeSectionEnabled: StateFlow<Boolean>
    fun setMetronomeSectionEnabled(enabled: Boolean)
    val onsetDetectionThreshold: StateFlow<Float>
    fun setOnsetDetectionThreshold(threshold: Float)
    val notesSectionEnabled: StateFlow<Boolean>
    fun setNotesSectionEnabled(enabled: Boolean)
}
