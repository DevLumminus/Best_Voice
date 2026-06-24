package com.avozdedeus.avozdedeusjpc.audio.presentation

import android.net.Uri
import androidx.lifecycle.viewModelScope
import androidx.media3.common.Player
import com.avozdedeus.avozdedeusjpc.audio.analysis.AudioKeyAnalysisResult
import com.avozdedeus.avozdedeusjpc.audio.analysis.AudioKeyAnalyzer
import com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetAnalyzer
import com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetExtractionResult
import com.avozdedeus.avozdedeusjpc.audio.data.AudioSessionStore
import com.avozdedeus.avozdedeusjpc.audio.data.BpmAnalysisCacheStore
import com.avozdedeus.avozdedeusjpc.audio.data.CachedBpmAnalysis
import com.avozdedeus.avozdedeusjpc.audio.domain.RepeatMarkerState
import com.avozdedeus.avozdedeusjpc.audio.domain.TapTempoCalculator
import com.avozdedeus.avozdedeusjpc.audio.domain.analyzeBpmFromTimestamps
import com.avozdedeus.avozdedeusjpc.audio.domain.formatToneInputValue
import com.avozdedeus.avozdedeusjpc.audio.domain.normalizeManualToneValue
import com.avozdedeus.avozdedeusjpc.audio.domain.normalizeRepeatMarkers
import com.avozdedeus.avozdedeusjpc.audio.domain.snapToneValueToStep
import com.avozdedeus.avozdedeusjpc.audio.domain.suggestMeterFromOnsets
import com.avozdedeus.avozdedeusjpc.core.common.prefs.UserUiPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class AudioViewModel @Inject constructor(
    private val audioSessionRepository: AudioSessionStore,
    private val onsetAnalyzer: OnsetAnalyzer,
    private val bpmAnalysisCache: BpmAnalysisCacheStore,
    private val audioKeyAnalyzer: AudioKeyAnalyzer,
    private val userUiPreferences: UserUiPreferences
) : androidx.lifecycle.ViewModel() {
    private val _uiState = MutableStateFlow(AudioUiState())
    val uiState: StateFlow<AudioUiState> = _uiState.asStateFlow()

    private var hasInitializedIntent = false
    private var audioKeyRequestId = 0L
    private val tapTempoCalculator = TapTempoCalculator()

    init {
        viewModelScope.launch(Dispatchers.Default) {
            userUiPreferences.metronomeSectionEnabled.collect { enabled ->
                _uiState.update { state ->
                    state.copy(isMetronomeSectionVisible = enabled)
                }
            }
        }
        viewModelScope.launch(Dispatchers.Default) {
            userUiPreferences.onsetDetectionThreshold.collect { threshold ->
                _uiState.update { state ->
                    state.copy(onsetDetectionThreshold = threshold)
                }
            }
        }
        viewModelScope.launch(Dispatchers.Default) {
            userUiPreferences.notesSectionEnabled.collect { enabled ->
                _uiState.update { state ->
                    state.copy(isNotesSectionVisible = enabled)
                }
            }
        }
    }

    fun initializeFromIntent(audioUri: Uri?, audioFileName: String?) {
        if (hasInitializedIntent) {
            return
        }
        hasInitializedIntent = true

        if (audioUri != null) {
            _uiState.update { state ->
                state.copy(
                    pendingIntentAudio = PendingAudioSelection(
                        uri = audioUri,
                        fileName = audioFileName
                    )
                )
            }
        }
    }

    fun consumePendingIntentAudio() {
        _uiState.update { state ->
            state.copy(pendingIntentAudio = null)
        }
    }

    fun refreshFromStoredSelection() {
        val storedSelection = audioSessionRepository.loadSelection()

        _uiState.update { state ->
            if (storedSelection == null) {
                state.copy(storedSelection = null)
            } else {
                state.copy(
                    storedSelection = storedSelection,
                    toneSemitones = storedSelection.toneSemitones,
                    toneInputText = formatToneInputValue(storedSelection.toneSemitones),
                    playbackSpeed = storedSelection.playbackSpeed,
                    isRepeatEnabled = storedSelection.repeatMode == Player.REPEAT_MODE_ONE,
                    repeatPointA = storedSelection.repeatPointA,
                    repeatPointB = storedSelection.repeatPointB
                )
            }
        }
    }

    fun onAction(action: AudioUiAction) {
        when (action) {
            is AudioUiAction.SetToneSemitones -> {
                val normalizedValue = snapToneValueToStep(action.value)
                _uiState.update { state ->
                    state.copy(
                        toneSemitones = normalizedValue,
                        toneInputText = formatToneInputValue(normalizedValue)
                    )
                }
                audioSessionRepository.updateToneSemitones(normalizedValue)
            }

            AudioUiAction.ResetTone -> {
                onAction(AudioUiAction.SetToneSemitones(0f))
            }

            AudioUiAction.OpenToneDialog -> {
                _uiState.update { state ->
                    state.copy(
                        isToneInputDialogOpen = true,
                        toneInputText = formatToneInputValue(state.toneSemitones)
                    )
                }
            }

            is AudioUiAction.UpdateToneInputText -> {
                _uiState.update { state ->
                    state.copy(toneInputText = action.value)
                }
            }

            AudioUiAction.DismissToneDialog -> {
                _uiState.update { state ->
                    state.copy(
                        isToneInputDialogOpen = false,
                        toneInputText = formatToneInputValue(state.toneSemitones)
                    )
                }
            }

            AudioUiAction.ConfirmToneDialog -> {
                val normalizedValue = normalizeManualToneValue(_uiState.value.toneInputText) ?: return
                onAction(AudioUiAction.SetToneSemitones(normalizedValue))
                _uiState.update { state ->
                    state.copy(isToneInputDialogOpen = false)
                }
            }

            AudioUiAction.ToggleRepeatMode -> {
                _uiState.update { state ->
                    val newRepeatEnabled = !state.isRepeatEnabled
                    audioSessionRepository.updateRepeatMode(
                        if (newRepeatEnabled) Player.REPEAT_MODE_ONE else Player.REPEAT_MODE_OFF
                    )
                    state.copy(isRepeatEnabled = newRepeatEnabled)
                }
            }

            AudioUiAction.ToggleSpeedMenu -> {
                _uiState.update { state ->
                    state.copy(isSpeedMenuExpanded = !state.isSpeedMenuExpanded)
                }
            }

            AudioUiAction.DismissSpeedMenu -> {
                _uiState.update { state ->
                    state.copy(isSpeedMenuExpanded = false)
                }
            }

            is AudioUiAction.SelectSpeed -> {
                _uiState.update { state ->
                    state.copy(
                        playbackSpeed = action.option.multiplier,
                        isSpeedMenuExpanded = false
                    )
                }
                audioSessionRepository.updatePlaybackSpeed(action.option.multiplier)
            }

            is AudioUiAction.ReadBpm -> readBpm(action.uri, action.forceRefresh)

            is AudioUiAction.ReadAudioKey -> readAudioKey(action.uri)

            AudioUiAction.ClearAudioKey -> clearAudioKey()

            is AudioUiAction.SetOnsetDetectionThreshold -> {
                userUiPreferences.setOnsetDetectionThreshold(action.value)
            }

            is AudioUiAction.SelectMetronomeMode -> {
                _uiState.update { state ->
                    state.copy(
                        metronomeMode = action.mode,
                        isMetronomeMeterMenuExpanded = false
                    )
                }
            }

            is AudioUiAction.RegisterTapTempo -> {
                val bpm = tapTempoCalculator.tap(action.elapsedRealtimeMs)
                _uiState.update { state ->
                    state.copy(
                        metronomeMode = MetronomeMode.MANUAL,
                        manualBpm = bpm.takeIf { it > 0 }
                    )
                }
            }

            AudioUiAction.ResetTapTempo -> {
                tapTempoCalculator.reset()
                _uiState.update { state ->
                    state.copy(manualBpm = null)
                }
            }

            is AudioUiAction.SetManualBpm -> {
                tapTempoCalculator.reset()
                _uiState.update { state ->
                    state.copy(
                        metronomeMode = MetronomeMode.MANUAL,
                        manualBpm = action.bpm.takeIf { it > 0 }
                    )
                }
            }

            AudioUiAction.ToggleMetronomeMeterMenu -> {
                _uiState.update { state ->
                    state.copy(isMetronomeMeterMenuExpanded = !state.isMetronomeMeterMenuExpanded)
                }
            }

            AudioUiAction.DismissMetronomeMeterMenu -> {
                _uiState.update { state ->
                    state.copy(isMetronomeMeterMenuExpanded = false)
                }
            }

            is AudioUiAction.SelectMetronomeMeter -> {
                _uiState.update { state ->
                    state.copy(
                        metronomeMeterLabel = action.option.label,
                        metronomeBeatsPerBar = action.option.beatsPerBar,
                        isMetronomeMeterMenuExpanded = false
                    )
                }
            }
        }
    }

    fun updateRepeatMarkers(
        repeatPointA: Long?,
        repeatPointB: Long?
    ): RepeatMarkerState {
        val normalizedMarkers = normalizeRepeatMarkers(
            repeatPointA = repeatPointA,
            repeatPointB = repeatPointB
        )

        _uiState.update { state ->
            state.copy(
                repeatPointA = normalizedMarkers.repeatPointA,
                repeatPointB = normalizedMarkers.repeatPointB
            )
        }
        audioSessionRepository.updateRepeatMarkers(
            repeatPointA = normalizedMarkers.repeatPointA,
            repeatPointB = normalizedMarkers.repeatPointB
        )
        refreshFromStoredSelection()
        return normalizedMarkers
    }

    private fun readAudioKey(uri: Uri) {
        val requestId = ++audioKeyRequestId

        viewModelScope.launch {
            _uiState.update { state ->
                state.copy(
                    isAudioKeyScanRunning = true,
                    detectedAudioKey = null
                )
            }

            val result = withContext(Dispatchers.Default) {
                audioKeyAnalyzer.analyze(uri)
            }

            if (requestId != audioKeyRequestId) {
                return@launch
            }

            _uiState.update { state ->
                when (result) {
                    is AudioKeyAnalysisResult.Success -> {
                        state.copy(
                            isAudioKeyScanRunning = false,
                            detectedAudioKey = result.key
                        )
                    }

                    is AudioKeyAnalysisResult.Failure -> {
                        state.copy(
                            isAudioKeyScanRunning = false,
                            detectedAudioKey = null
                        )
                    }
                }
            }
        }
    }

    private fun clearAudioKey() {
        audioKeyRequestId += 1
        _uiState.update { state ->
            state.copy(
                isAudioKeyScanRunning = false,
                detectedAudioKey = null
            )
        }
    }

    private fun readBpm(uri: Uri, forceRefresh: Boolean) {
        viewModelScope.launch {
            _uiState.update { state ->
                state.copy(
                    isOnsetScanRunning = true,
                    bpmAnalysis = null,
                    suggestedMeterLabel = "4/4",
                    beatsPerBar = 4
                )
            }
            try {
                val cached = withContext(Dispatchers.Default) {
                    if (forceRefresh) null else bpmAnalysisCache.load(uri)
                }
                if (cached != null) {
                    _uiState.update { state ->
                        state.copy(
                            isOnsetScanRunning = false,
                            bpmAnalysis = cached.bpmAnalysis,
                            suggestedMeterLabel = cached.suggestedMeterLabel,
                            beatsPerBar = cached.beatsPerBar
                        )
                    }
                    return@launch
                }

                val result = withContext(Dispatchers.Default) {
                    onsetAnalyzer.analyze(uri)
                }
                when (result) {
                    is OnsetExtractionResult.Success -> {
                        val bpm = analyzeBpmFromTimestamps(result.timestampsSeconds)
                        val meter = suggestMeterFromOnsets(
                            result.timestampsSeconds,
                            result.saliences,
                            bpm.dominantIntervalMs
                        )
                        withContext(Dispatchers.Default) {
                            bpmAnalysisCache.save(
                                uri,
                                CachedBpmAnalysis(
                                    bpmAnalysis = bpm,
                                    suggestedMeterLabel = meter.label,
                                    beatsPerBar = meter.beatsPerBar
                                )
                            )
                        }
                        _uiState.update { state ->
                            state.copy(
                                isOnsetScanRunning = false,
                                bpmAnalysis = bpm,
                                suggestedMeterLabel = meter.label,
                                beatsPerBar = meter.beatsPerBar
                            )
                        }
                    }
                    is OnsetExtractionResult.Failure -> {
                        _uiState.update { state ->
                            state.copy(
                                isOnsetScanRunning = false,
                                bpmAnalysis = null,
                                suggestedMeterLabel = "4/4",
                                beatsPerBar = 4
                            )
                        }
                    }
                }
            } catch (t: Throwable) {
                _uiState.update { state ->
                    state.copy(
                        isOnsetScanRunning = false,
                        bpmAnalysis = null,
                        suggestedMeterLabel = "4/4",
                        beatsPerBar = 4
                    )
                }
            }
        }
    }
}
