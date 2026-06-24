package com.avozdedeus.avozdedeusjpc.core.common.prefs

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

private const val PREFS_NAME = "user_ui_prefs"
private const val KEY_METRONOME_SECTION_ENABLED = "metronome_section_enabled"
private const val KEY_ONSET_DETECTION_THRESHOLD = "onset_detection_threshold"
private const val DEFAULT_ONSET_THRESHOLD = 0.4f
private const val KEY_NOTES_SECTION_ENABLED = "notes_section_enabled"

@Singleton
class SharedPreferencesUserUiPreferences @Inject constructor(
    @ApplicationContext context: Context
) : UserUiPreferences {

    private val prefs: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    private val _metronomeSectionEnabled = MutableStateFlow(
        prefs.getBoolean(KEY_METRONOME_SECTION_ENABLED, false)
    )

    private val _onsetDetectionThreshold = MutableStateFlow(
        prefs.getFloat(KEY_ONSET_DETECTION_THRESHOLD, DEFAULT_ONSET_THRESHOLD)
    )

    private val _notesSectionEnabled = MutableStateFlow(
        prefs.getBoolean(KEY_NOTES_SECTION_ENABLED, false)
    )

    private val listener = SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, key ->
        if (key == null || key == KEY_METRONOME_SECTION_ENABLED) {
            _metronomeSectionEnabled.value =
                sharedPreferences.getBoolean(KEY_METRONOME_SECTION_ENABLED, false)
        }
        if (key == null || key == KEY_ONSET_DETECTION_THRESHOLD) {
            _onsetDetectionThreshold.value =
                sharedPreferences.getFloat(KEY_ONSET_DETECTION_THRESHOLD, DEFAULT_ONSET_THRESHOLD)
        }
        if (key == null || key == KEY_NOTES_SECTION_ENABLED) {
            _notesSectionEnabled.value =
                sharedPreferences.getBoolean(KEY_NOTES_SECTION_ENABLED, false)
        }
    }

    init {
        prefs.registerOnSharedPreferenceChangeListener(listener)
    }

    override val metronomeSectionEnabled: StateFlow<Boolean> =
        _metronomeSectionEnabled.asStateFlow()

    override val onsetDetectionThreshold: StateFlow<Float> =
        _onsetDetectionThreshold.asStateFlow()

    override val notesSectionEnabled: StateFlow<Boolean> =
        _notesSectionEnabled.asStateFlow()

    override fun setMetronomeSectionEnabled(enabled: Boolean) {
        prefs.edit().putBoolean(KEY_METRONOME_SECTION_ENABLED, enabled).apply()
    }

    override fun setOnsetDetectionThreshold(threshold: Float) {
        val clamped = threshold.coerceIn(0.05f, 0.95f)
        prefs.edit().putFloat(KEY_ONSET_DETECTION_THRESHOLD, clamped).apply()
    }

    override fun setNotesSectionEnabled(enabled: Boolean) {
        prefs.edit().putBoolean(KEY_NOTES_SECTION_ENABLED, enabled).apply()
    }
}
