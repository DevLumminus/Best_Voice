package com.avozdedeus.avozdedeusjpc.audio.presentation

import android.net.Uri
import com.avozdedeus.avozdedeusjpc.audio.data.StoredAudioSelection
import com.avozdedeus.avozdedeusjpc.audio.domain.BpmAnalysisResult
import com.avozdedeus.avozdedeusjpc.audio.domain.MusicalKey
import com.avozdedeus.avozdedeusjpc.audio.domain.audioKeyDisplay
import com.avozdedeus.avozdedeusjpc.audio.domain.formatToneInputValue
import com.avozdedeus.avozdedeusjpc.core.navigation.AppDestination
import kotlin.math.abs

data class PlaybackSpeedOption(
    val multiplier: Float,
    val label: String,
    val usesDefaultIcon: Boolean = false
)

val PlaybackSpeedOptions = listOf(
    PlaybackSpeedOption(multiplier = 2f, label = "2x"),
    PlaybackSpeedOption(multiplier = 1.75f, label = "1.75x"),
    PlaybackSpeedOption(multiplier = 1.5f, label = "1.5x"),
    PlaybackSpeedOption(multiplier = 1.25f, label = "1.25x"),
    PlaybackSpeedOption(multiplier = 1f, label = "1x", usesDefaultIcon = true),
    PlaybackSpeedOption(multiplier = 0.5f, label = "0.5x"),
    PlaybackSpeedOption(multiplier = 0.25f, label = "0.25x")
)

fun defaultPlaybackSpeedOption(): PlaybackSpeedOption {
    return PlaybackSpeedOptions.first { it.usesDefaultIcon }
}

fun playbackSpeedOptionFor(multiplier: Float): PlaybackSpeedOption {
    return PlaybackSpeedOptions.minByOrNull { option ->
        abs(option.multiplier - multiplier)
    } ?: defaultPlaybackSpeedOption()
}

data class PendingAudioSelection(
    val uri: Uri,
    val fileName: String?
)

data class PlayerSnapshot(
    val hasMediaItem: Boolean = false,
    val audioUri: Uri? = null,
    val fileName: String? = null,
    val durationMs: Long = 0L,
    val positionMs: Long = 0L,
    val isPlaying: Boolean = false,
    val playbackSpeed: Float = 1f
)

enum class MetronomeMode {
    MANUAL,
    AUTOMATIC
}

data class MeterOption(
    val label: String,
    val beatsPerBar: Int
)

val MetronomeMeterOptions = listOf(
    MeterOption(label = "4/4", beatsPerBar = 4),
    MeterOption(label = "3/4", beatsPerBar = 3),
    MeterOption(label = "2/4", beatsPerBar = 2)
)

val DefaultMetronomeMeterOption: MeterOption = MetronomeMeterOptions.first()

data class AudioUiState(
    val currentDestination: AppDestination = AppDestination.AUDIO,
    val storedSelection: StoredAudioSelection? = null,
    val toneSemitones: Float = 0f,
    val toneInputText: String = formatToneInputValue(0f),
    val playbackSpeed: Float = defaultPlaybackSpeedOption().multiplier,
    val isRepeatEnabled: Boolean = false,
    val isToneInputDialogOpen: Boolean = false,
    val isSpeedMenuExpanded: Boolean = false,
    val repeatPointA: Long? = null,
    val repeatPointB: Long? = null,
    val pendingIntentAudio: PendingAudioSelection? = null,
    val isOnsetScanRunning: Boolean = false,
    val isMetronomeSectionVisible: Boolean = false,
    val isNotesSectionVisible: Boolean = false,
    val isAudioKeyScanRunning: Boolean = false,
    val detectedAudioKey: MusicalKey? = null,
    val onsetDetectionThreshold: Float = 0.4f,
    val bpmAnalysis: BpmAnalysisResult? = null,
    val suggestedMeterLabel: String = "4/4",
    val beatsPerBar: Int = 4,
    val metronomeMode: MetronomeMode = MetronomeMode.MANUAL,
    val manualBpm: Int? = null,
    val metronomeMeterLabel: String = DefaultMetronomeMeterOption.label,
    val metronomeBeatsPerBar: Int = DefaultMetronomeMeterOption.beatsPerBar,
    val isMetronomeMeterMenuExpanded: Boolean = false
) {
    val audioKeySourceLabel: String
        get() = audioKeyDisplay(detectedAudioKey, toneSemitones).sourceLabel

    val audioKeyTargetLabel: String
        get() = audioKeyDisplay(detectedAudioKey, toneSemitones).targetLabel
}

sealed interface AudioUiAction {
    data class SetToneSemitones(val value: Float) : AudioUiAction
    object ResetTone : AudioUiAction
    object OpenToneDialog : AudioUiAction
    data class UpdateToneInputText(val value: String) : AudioUiAction
    object DismissToneDialog : AudioUiAction
    object ConfirmToneDialog : AudioUiAction
    object ToggleRepeatMode : AudioUiAction
    object ToggleSpeedMenu : AudioUiAction
    object DismissSpeedMenu : AudioUiAction
    data class SelectSpeed(val option: PlaybackSpeedOption) : AudioUiAction
    data class ReadBpm(val uri: Uri, val forceRefresh: Boolean) : AudioUiAction
    data class ReadAudioKey(val uri: Uri) : AudioUiAction
    object ClearAudioKey : AudioUiAction
    data class SetOnsetDetectionThreshold(val value: Float) : AudioUiAction
    data class SelectMetronomeMode(val mode: MetronomeMode) : AudioUiAction
    data class RegisterTapTempo(val elapsedRealtimeMs: Long) : AudioUiAction
    object ResetTapTempo : AudioUiAction
    object ToggleMetronomeMeterMenu : AudioUiAction
    object DismissMetronomeMeterMenu : AudioUiAction
    data class SelectMetronomeMeter(val option: MeterOption) : AudioUiAction
    data class SetManualBpm(val bpm: Int) : AudioUiAction
}
