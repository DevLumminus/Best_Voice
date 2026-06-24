package com.avozdedeus.avozdedeusjpc.audio.presentation

import android.content.ComponentName
import android.content.Context
import android.graphics.BitmapFactory
import android.media.AudioManager
import android.media.ToneGenerator
import android.net.Uri
import android.os.SystemClock
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Forward30
import androidx.compose.material.icons.rounded.Pause
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.RepeatOne
import androidx.compose.material.icons.rounded.Replay10
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.core.content.ContextCompat
import androidx.media3.common.C
import androidx.media3.common.PlaybackParameters
import androidx.media3.common.Player
import androidx.media3.session.MediaController
import androidx.media3.session.SessionToken
import com.avozdedeus.avozdedeusjpc.audio.AudioPlaybackService
import com.avozdedeus.avozdedeusjpc.audio.data.AudioMediaControllerCoordinator
import com.avozdedeus.avozdedeusjpc.audio.data.AudioSelectionRequest
import com.avozdedeus.avozdedeusjpc.audio.data.loadAudioSourceInfo
import com.avozdedeus.avozdedeusjpc.audio.domain.BpmAnalysisResult
import com.avozdedeus.avozdedeusjpc.audio.domain.formatPlaybackTime
import com.avozdedeus.avozdedeusjpc.audio.domain.formatToneSliderValue
import com.avozdedeus.avozdedeusjpc.audio.domain.normalizeManualToneValue
import com.avozdedeus.avozdedeusjpc.audio.domain.normalizeRepeatMarkers
import com.avozdedeus.avozdedeusjpc.audio.domain.resolvePlayerRepeatMode
import com.avozdedeus.avozdedeusjpc.audio.domain.semitonesToPitchMultiplier
import com.avozdedeus.avozdedeusjpc.core.designsystem.component.AppBottomBar
import com.avozdedeus.avozdedeusjpc.core.designsystem.theme.AVozDeDeusJPCTheme
import com.avozdedeus.avozdedeusjpc.core.navigation.AppNavigator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.avozdedeus.avozdedeusjpc.audio.R
import kotlin.math.roundToInt
import kotlin.math.roundToLong

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AudioRoute(
    viewModel: AudioViewModel,
    appNavigator: AppNavigator,
    audioMediaControllerCoordinator: AudioMediaControllerCoordinator
) {
    val context = LocalContext.current
    val uiState by viewModel.uiState.collectAsState()
    val controller = rememberAudioController()
    val playerSnapshot = rememberPlayerSnapshot(controller)
    val scope = rememberCoroutineScope()

    val repeatModePreference = if (uiState.isRepeatEnabled) {
        Player.REPEAT_MODE_ONE
    } else {
        Player.REPEAT_MODE_OFF
    }
    val effectivePlaybackSpeed = if (playerSnapshot.hasMediaItem) {
        playerSnapshot.playbackSpeed
    } else {
        uiState.playbackSpeed
    }
    val selectedSpeed = playbackSpeedOptionFor(effectivePlaybackSpeed)
    val effectiveAudioUri = playerSnapshot.audioUri
        ?: uiState.pendingIntentAudio?.uri
    val effectiveAudioFileName = playerSnapshot.fileName
        ?: uiState.pendingIntentAudio?.fileName
    val audioFileState = rememberAudioFileState(
        audioUri = effectiveAudioUri,
        fileName = effectiveAudioFileName
    )
    val effectiveDurationMs = playerSnapshot.durationMs.takeIf { it > 0L } ?: audioFileState.durationMs
    val effectivePositionMs = playerSnapshot.positionMs.coerceIn(
        0L,
        effectiveDurationMs.coerceAtLeast(0L)
    )
    val hasLoadedAudio = effectiveAudioUri != null

    val audioPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument()
    ) { selectedUri ->
        if (selectedUri != null) {
            scope.launch {
                controller?.let { mediaController ->
                    audioMediaControllerCoordinator.selectAudio(
                        context = context,
                        controller = mediaController,
                        request = AudioSelectionRequest(
                            audioUri = selectedUri,
                            providedFileName = null,
                            playbackSpeed = uiState.playbackSpeed,
                            toneSemitones = uiState.toneSemitones,
                            repeatMode = repeatModePreference,
                            autoPlay = true,
                            resetRepeatMarkers = true
                        )
                    )
                    viewModel.refreshFromStoredSelection()
                }
            }
        }
    }

    LaunchedEffect(controller, uiState.pendingIntentAudio) {
        val pendingAudio = uiState.pendingIntentAudio ?: return@LaunchedEffect
        val mediaController = controller ?: return@LaunchedEffect

        audioMediaControllerCoordinator.selectAudio(
            context = context,
            controller = mediaController,
            request = AudioSelectionRequest(
                audioUri = pendingAudio.uri,
                providedFileName = pendingAudio.fileName,
                playbackSpeed = uiState.playbackSpeed,
                toneSemitones = uiState.toneSemitones,
                repeatMode = repeatModePreference,
                autoPlay = true,
                resetRepeatMarkers = true
            )
        )
        viewModel.refreshFromStoredSelection()
        viewModel.consumePendingIntentAudio()
    }

    val onArtworkClick = {
        audioPickerLauncher.launch(arrayOf("audio/*"))
    }
    var isTopBarMenuExpanded by remember { mutableStateOf(false) }

    LaunchedEffect(effectiveAudioUri) {
        effectiveAudioUri?.let { uri ->
            viewModel.onAction(AudioUiAction.ReadBpm(uri, forceRefresh = false))
        }
    }

    LaunchedEffect(effectiveAudioUri, uiState.isNotesSectionVisible) {
        val uri = effectiveAudioUri
        if (uiState.isNotesSectionVisible && uri != null) {
            viewModel.onAction(AudioUiAction.ReadAudioKey(uri))
        } else {
            viewModel.onAction(AudioUiAction.ClearAudioKey)
        }
    }

    LaunchedEffect(controller, uiState.playbackSpeed, uiState.toneSemitones) {
        val mediaController = controller ?: return@LaunchedEffect
        val desiredPitch = semitonesToPitchMultiplier(uiState.toneSemitones)
        val currentParameters = mediaController.playbackParameters
        val pitchTolerance = 0.0001f

        if (
            kotlin.math.abs(currentParameters.speed - uiState.playbackSpeed) < pitchTolerance &&
            kotlin.math.abs(currentParameters.pitch - desiredPitch) < pitchTolerance
        ) {
            return@LaunchedEffect
        }

        mediaController.setPlaybackParameters(
            PlaybackParameters(
                uiState.playbackSpeed,
                desiredPitch
            )
        )
    }

    LaunchedEffect(
        controller,
        uiState.isRepeatEnabled,
        uiState.repeatPointA,
        uiState.repeatPointB
    ) {
        val mediaController = controller ?: return@LaunchedEffect
        val effectiveRepeatMode = resolvePlayerRepeatMode(
            repeatModePreference = repeatModePreference,
            repeatPointA = uiState.repeatPointA,
            repeatPointB = uiState.repeatPointB
        )

        if (mediaController.repeatMode != effectiveRepeatMode) {
            mediaController.repeatMode = effectiveRepeatMode
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(
                        onClick = onArtworkClick,
                        modifier = Modifier.size(52.dp)
                    ) {
                        Image(
                            painter = painterResource(
                                id = com.avozdedeus.avozdedeusjpc.audio.R.drawable.ic_audio_search
                            ),
                            contentDescription = "Selecionar audio",
                            modifier = Modifier.size(36.dp),
                            contentScale = ContentScale.Fit
                        )
                    }
                },
                actions = {
                    Box {
                        IconButton(onClick = { isTopBarMenuExpanded = true }) {
                            Icon(
                                imageVector = Icons.Filled.MoreVert,
                                contentDescription = "Mais opções"
                            )
                        }
                        DropdownMenu(
                            expanded = isTopBarMenuExpanded,
                            onDismissRequest = { isTopBarMenuExpanded = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text("Configurações") },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Filled.Settings,
                                        contentDescription = null
                                    )
                                },
                                onClick = {
                                    isTopBarMenuExpanded = false
                                    appNavigator.openSettings(context)
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Sobre") },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Filled.Info,
                                        contentDescription = null
                                    )
                                },
                                onClick = {
                                    isTopBarMenuExpanded = false
                                    appNavigator.openAbout(context)
                                }
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    navigationIconContentColor = MaterialTheme.colorScheme.primary,
                    actionIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            )
        },
        bottomBar = {
            AppBottomBar(
                currentDestination = uiState.currentDestination,
                onHomeClick = { appNavigator.openHome(context) },
                onAudioClick = { appNavigator.openAudio(context) },
                onTunerClick = { appNavigator.openTuner(context) }
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        AudioScreenContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            uiState = uiState,
            playerSnapshot = playerSnapshot,
            audioFileState = audioFileState,
            durationMs = effectiveDurationMs,
            positionMs = effectivePositionMs,
            hasLoadedAudio = hasLoadedAudio,
            selectedSpeed = selectedSpeed,
            onAction = viewModel::onAction,
            onReadBpm = { forceRefresh ->
                effectiveAudioUri?.let { uri ->
                    viewModel.onAction(AudioUiAction.ReadBpm(uri, forceRefresh))
                }
            },
            onToggleRepeatA = {
                if (effectiveDurationMs > 0L) {
                    if (uiState.repeatPointA != null) {
                        viewModel.updateRepeatMarkers(null, uiState.repeatPointB)
                    } else {
                        viewModel.updateRepeatMarkers(effectivePositionMs, uiState.repeatPointB)
                    }
                }
            },
            onToggleRepeatB = {
                if (effectiveDurationMs > 0L) {
                    if (uiState.repeatPointB != null) {
                        viewModel.updateRepeatMarkers(uiState.repeatPointA, null)
                    } else {
                        val normalizedMarkers = viewModel.updateRepeatMarkers(
                            uiState.repeatPointA,
                            effectivePositionMs
                        )
                        normalizedMarkers.repeatPointA?.let { pointA ->
                            controller?.seekTo(pointA)
                        }
                    }
                }
            },
            onClearRepeat = {
                viewModel.updateRepeatMarkers(null, null)
            },
            onPlayPauseToggle = {
                val mediaController = controller
                if (mediaController != null) {
                    if (
                        !mediaController.isPlaying &&
                        effectiveDurationMs > 0L &&
                        effectivePositionMs >= effectiveDurationMs
                    ) {
                        mediaController.seekTo(0L)
                    }

                    if (mediaController.isPlaying) {
                        mediaController.pause()
                    } else {
                        mediaController.play()
                    }
                }
            },
            onPositionChange = { newPosition ->
                val minPosition = uiState.repeatPointA ?: 0L
                controller?.seekTo(newPosition.coerceIn(minPosition, effectiveDurationMs))
            }
        )
    }
}

@Composable
private fun AudioScreenContent(
    modifier: Modifier,
    uiState: AudioUiState,
    playerSnapshot: PlayerSnapshot,
    audioFileState: AudioFileState,
    durationMs: Long,
    positionMs: Long,
    hasLoadedAudio: Boolean,
    selectedSpeed: PlaybackSpeedOption,
    onAction: (AudioUiAction) -> Unit,
    onReadBpm: (Boolean) -> Unit,
    onToggleRepeatA: () -> Unit,
    onToggleRepeatB: () -> Unit,
    onClearRepeat: () -> Unit,
    onPlayPauseToggle: () -> Unit,
    onPositionChange: (Long) -> Unit
) {
    Box(modifier = modifier) {
        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp, vertical = 20.dp),
                verticalArrangement = Arrangement.spacedBy(22.dp)
            ) {
                ArtworkPlaceholderCard(
                    audioFileState = audioFileState
                )
                ToneSection(
                    sliderValue = uiState.toneSemitones,
                    onSliderValueChange = {
                        onAction(AudioUiAction.SetToneSemitones(it))
                    },
                    onReset = {
                        onAction(AudioUiAction.ResetTone)
                    },
                    isDialogOpen = uiState.isToneInputDialogOpen,
                    toneInputText = uiState.toneInputText,
                    onToneInputTextChange = {
                        onAction(AudioUiAction.UpdateToneInputText(it))
                    },
                    onChipClick = {
                        onAction(AudioUiAction.OpenToneDialog)
                    },
                    onDialogDismiss = {
                        onAction(AudioUiAction.DismissToneDialog)
                    },
                    onDialogConfirm = {
                        onAction(AudioUiAction.ConfirmToneDialog)
                    }
                )
                if (uiState.isNotesSectionVisible) {
                    NotasSection(
                        sourceKeyLabel = uiState.audioKeySourceLabel,
                        targetKeyLabel = uiState.audioKeyTargetLabel
                    )
                }
                RepeatSection(
                    durationMs = durationMs,
                    repeatPointA = uiState.repeatPointA,
                    repeatPointB = uiState.repeatPointB,
                    onToggleA = onToggleRepeatA,
                    onToggleB = onToggleRepeatB,
                    onClearRepeat = onClearRepeat
                )
            }

            PlaybackControlsSection(
                modifier = Modifier.fillMaxWidth(),
                durationMs = durationMs,
                positionMs = positionMs,
                hasLoadedAudio = hasLoadedAudio,
                isPlaying = playerSnapshot.isPlaying,
                isRepeatEnabled = uiState.isRepeatEnabled,
                selectedSpeed = selectedSpeed,
                isSpeedMenuExpanded = uiState.isSpeedMenuExpanded,
                repeatPointA = uiState.repeatPointA,
                repeatPointB = uiState.repeatPointB,
                onPlayPauseToggle = onPlayPauseToggle,
                onPositionChange = onPositionChange,
                onRepeatToggle = {
                    onAction(AudioUiAction.ToggleRepeatMode)
                },
                onSpeedMenuToggle = {
                    onAction(AudioUiAction.ToggleSpeedMenu)
                },
                onSpeedMenuDismiss = {
                    onAction(AudioUiAction.DismissSpeedMenu)
                },
                onSpeedSelected = { option ->
                    onAction(AudioUiAction.SelectSpeed(option))
                }
            )
        }

        if (uiState.isMetronomeSectionVisible) {
            BatidasEdgePanel(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.TopEnd)
                    .zIndex(4f),
                uiState = uiState,
                hasLoadedAudio = hasLoadedAudio,
                onAction = onAction,
                onReadBpm = onReadBpm
            )
        }
    }
}

@Composable
private fun rememberAudioController(): MediaController? {
    val context = LocalContext.current
    val isInPreview = LocalInspectionMode.current
    var controller by remember { mutableStateOf<MediaController?>(null) }

    DisposableEffect(context, isInPreview) {
        if (isInPreview) {
            onDispose {}
        } else {
            val sessionToken = SessionToken(
                context,
                ComponentName(context, AudioPlaybackService::class.java)
            )
            val controllerFuture = MediaController.Builder(context, sessionToken).buildAsync()
            val mainExecutor = ContextCompat.getMainExecutor(context)
            var disposed = false

            controllerFuture.addListener(
                {
                    if (!disposed) {
                        controller = runCatching { controllerFuture.get() }.getOrNull()
                    }
                },
                mainExecutor
            )

            onDispose {
                disposed = true
                controller?.release()
                controller = null

                if (!controllerFuture.isDone) {
                    controllerFuture.cancel(false)
                }
            }
        }
    }

    return controller
}

@Composable
private fun rememberPlayerSnapshot(controller: MediaController?): PlayerSnapshot {
    var snapshot by remember(controller) { mutableStateOf(PlayerSnapshot()) }

    DisposableEffect(controller) {
        if (controller == null) {
            snapshot = PlayerSnapshot()
            onDispose {}
        } else {
            val listener = object : Player.Listener {
                override fun onEvents(player: Player, events: Player.Events) {
                    snapshot = controller.toPlayerSnapshot()
                }
            }

            controller.addListener(listener)
            snapshot = controller.toPlayerSnapshot()

            onDispose {
                controller.removeListener(listener)
            }
        }
    }

    LaunchedEffect(controller) {
        val mediaController = controller ?: return@LaunchedEffect

        while (isActive) {
            snapshot = mediaController.toPlayerSnapshot()
            delay(200L)
        }
    }

    return snapshot
}

private fun MediaController.toPlayerSnapshot(): PlayerSnapshot {
    return PlayerSnapshot(
        hasMediaItem = currentMediaItem != null,
        audioUri = currentMediaItem?.localConfiguration?.uri,
        fileName = currentMediaItem?.mediaMetadata?.title?.toString(),
        durationMs = duration.takeIf { it != C.TIME_UNSET && it > 0L } ?: 0L,
        positionMs = currentPosition.coerceAtLeast(0L),
        isPlaying = isPlaying,
        playbackSpeed = playbackParameters.speed
    )
}

private data class AudioFileState(
    val artwork: ImageBitmap? = null,
    val fileName: String? = null,
    val durationMs: Long = 0L
)

@Composable
private fun rememberAudioFileState(
    audioUri: Uri?,
    fileName: String?
): AudioFileState {
    val context = LocalContext.current
    val state by produceState(
        initialValue = AudioFileState(fileName = fileName),
        key1 = audioUri,
        key2 = fileName
    ) {
        value = withContext(Dispatchers.IO) {
            loadAudioFileState(
                context = context,
                audioUri = audioUri,
                providedFileName = fileName
            )
        }
    }
    return state
}

private fun loadAudioFileState(
    context: Context,
    audioUri: Uri?,
    providedFileName: String?
): AudioFileState {
    if (audioUri == null) {
        return AudioFileState(fileName = providedFileName)
    }

    val sourceInfo = loadAudioSourceInfo(
        context = context,
        audioUri = audioUri,
        providedFileName = providedFileName
    )

    return AudioFileState(
        artwork = sourceInfo.artworkData?.let { bytes ->
            BitmapFactory.decodeByteArray(bytes, 0, bytes.size)?.asImageBitmap()
        },
        fileName = sourceInfo.fileName,
        durationMs = sourceInfo.durationMs
    )
}

@Composable
private fun ArtworkPlaceholderCard(
    audioFileState: AudioFileState
) {
    val cardText = audioFileState.fileName?.takeIf { it.isNotBlank() } ?: "Sem arquivo de audio"

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        ElevatedCard(
            modifier = Modifier.fillMaxWidth(0.95f),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = cardText,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp, vertical = 12.dp),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
private fun ToneSection(
    sliderValue: Float,
    onSliderValueChange: (Float) -> Unit,
    onReset: () -> Unit,
    isDialogOpen: Boolean,
    toneInputText: String,
    onToneInputTextChange: (String) -> Unit,
    onChipClick: () -> Unit,
    onDialogDismiss: () -> Unit,
    onDialogConfirm: () -> Unit
) {
    val chipText = formatToneSliderValue(sliderValue)
    val normalizedDialogValue = normalizeManualToneValue(toneInputText)

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Tom",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.weight(1f))

            IconButton(onClick = onReset) {
                Icon(
                    imageVector = Icons.Rounded.Refresh,
                    contentDescription = "Atualizar tom"
                )
            }
        }

        Box(modifier = Modifier.fillMaxWidth()) {
            AssistChip(
                onClick = onChipClick,
                modifier = Modifier.align(Alignment.Center),
                label = {
                    Text(
                        text = chipText,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            )
        }

        Slider(
            value = sliderValue,
            onValueChange = onSliderValueChange,
            modifier = Modifier.fillMaxWidth(),
            valueRange = -6f..6f,
            steps = 23,
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.primary,
                activeTrackColor = MaterialTheme.colorScheme.primaryContainer,
                inactiveTrackColor = MaterialTheme.colorScheme.surfaceVariant
            )
        )
    }

    if (isDialogOpen) {
        AlertDialog(
            onDismissRequest = onDialogDismiss,
            title = {
                Text(text = "Definir tom")
            },
            text = {
                OutlinedTextField(
                    value = toneInputText,
                    onValueChange = onToneInputTextChange,
                    singleLine = true,
                    label = {
                        Text("Valor do tom")
                    },
                    supportingText = {
                        Text("Aceita valores de -6,0 ate +6,0 em passos de 0,5.")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    )
                )
            },
            confirmButton = {
                TextButton(
                    onClick = onDialogConfirm,
                    enabled = normalizedDialogValue != null
                ) {
                    Text("Confirmar")
                }
            },
            dismissButton = {
                TextButton(onClick = onDialogDismiss) {
                    Text("Cancelar")
                }
            }
        )
    }
}

@Composable
private fun RepeatSection(
    durationMs: Long,
    repeatPointA: Long?,
    repeatPointB: Long?,
    onToggleA: () -> Unit,
    onToggleB: () -> Unit,
    onClearRepeat: () -> Unit
) {
    val areMarkersEnabled = durationMs > 0L

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Repeticao",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.weight(1f))

            IconButton(onClick = onClearRepeat) {
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = "Fechar repeticao"
                )
            }
        }

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                RepeatMarkerButton(
                    label = "A",
                    enabled = areMarkersEnabled,
                    isSelected = repeatPointA != null,
                    onClick = onToggleA
                )
                RepeatMarkerButton(
                    label = "B",
                    enabled = areMarkersEnabled,
                    isSelected = repeatPointB != null,
                    onClick = onToggleB
                )
            }
        }
    }
}

@Composable
private fun NotasSection(
    sourceKeyLabel: String,
    targetKeyLabel: String
) {
    val primaryColor = MaterialTheme.colorScheme.primary

    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(1.dp, primaryColor.copy(alpha = 0.45f)),
        shadowElevation = 8.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 22.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxSize(), // 1. Ocupa todo o espaço de 60x70
                verticalAlignment = Alignment.CenterVertically, // 2. Centraliza na ALTURA
                horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterHorizontally) // 3. Centraliza na LARGURA (mantendo 6dp de espaço entre os ícones)
            ) {
                KeyLabelText(
                    text = sourceKeyLabel,
                    color = primaryColor
                )

                Text(
                    text = "->",
                    modifier = Modifier.padding(horizontal = 18.dp),
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )

                KeyLabelText(
                    text = targetKeyLabel,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

@Composable
private fun KeyLabelText(
    text: String,
    color: Color
) {
    Text(
        text = text,
        modifier = Modifier.width(76.dp),
        style = MaterialTheme.typography.headlineSmall,
        fontWeight = FontWeight.Bold,
        color = color,
        textAlign = TextAlign.Center,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
private fun BatidasEdgePanel(
    modifier: Modifier = Modifier,
    uiState: AudioUiState,
    hasLoadedAudio: Boolean,
    onAction: (AudioUiAction) -> Unit,
    onReadBpm: (Boolean) -> Unit
) {
    var isPanelOpen by remember { mutableStateOf(false) }

    BoxWithConstraints(modifier = modifier) {
        if (isPanelOpen) {
            val maxPanelWidth = (maxWidth -60.dp).coerceAtLeast(220.dp)
            val panelWidth = (maxWidth * 0.85f)
                .coerceAtLeast(340.dp)
                .coerceAtMost(maxPanelWidth)

            Row(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .fillMaxHeight(),
                verticalAlignment = Alignment.Top
            ) {
                BatidasPanelHandle(
                    isOpen = true,
                    onClick = { isPanelOpen = false }
                )
                Surface(
                    modifier = Modifier
                        .width(panelWidth)
                        .fillMaxHeight(),
                    shape = RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp),
                    color = MaterialTheme.colorScheme.surfaceContainerHigh,
                    tonalElevation = 8.dp,
                    shadowElevation = 10.dp
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp, vertical = 20.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        BatidasMetronomeBox(
                            uiState = uiState,
                            hasLoadedAudio = hasLoadedAudio,
                            onAction = onAction,
                            onReadBpm = onReadBpm
                        )
                    }
                }
            }
        } else {
            BatidasPanelHandle(
                modifier = Modifier.align(Alignment.TopEnd),
                isOpen = false,
                onClick = { isPanelOpen = true }
            )
        }
    }
}

@Composable
private fun BatidasPanelHandle(
    modifier: Modifier = Modifier,
    isOpen: Boolean,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier
            .width(60.dp)
            .height(70.dp)
            .clip(RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp))
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp),
        color = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        shadowElevation = 6.dp
    ) {
        Row(
            modifier = Modifier.fillMaxSize(), // 1. Ocupa todo o espaço de 60x70
            verticalAlignment = Alignment.CenterVertically, // 2. Centraliza na ALTURA
            horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterHorizontally)
        ) {
            Text(
                text = if (isOpen) ">" else "<",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Icon(
                painter = painterResource(
                    id = R.drawable.icon_metrome
                ),
                contentDescription = "Metrônomo",
                modifier = Modifier.size(18.dp),
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

@Composable
private fun BatidasMetronomeBox(
    uiState: AudioUiState,
    hasLoadedAudio: Boolean,
    onAction: (AudioUiAction) -> Unit,
    onReadBpm: (Boolean) -> Unit
) {
    val primaryColor = MaterialTheme.colorScheme.primary
    val displayedBpm = when (uiState.metronomeMode) {
        MetronomeMode.MANUAL -> uiState.manualBpm
        MetronomeMode.AUTOMATIC -> uiState.bpmAnalysis?.estimatedBpm
    }
    val bpmText = displayedBpm?.toString() ?: "-"
    val bars = uiState.metronomeBeatsPerBar.coerceIn(2, 4)
    var currentBeat by remember(uiState.metronomeMeterLabel, bars) { mutableStateOf(0) }
    var isMetronomeRunning by remember { mutableStateOf(false) }
    val playClick = rememberMetronomeClick()
    
    var isBpmDialogOpen by remember { mutableStateOf(false) }
    var bpmInputValue by remember(bpmText) { mutableStateOf(bpmText) }
    val maxBpm = 220

    LaunchedEffect(displayedBpm) {
        if (displayedBpm == null) {
            isMetronomeRunning = false
        }
    }

    LaunchedEffect(isMetronomeRunning, displayedBpm, bars, playClick) {
        val bpm = displayedBpm ?: return@LaunchedEffect
        if (!isMetronomeRunning) {
            return@LaunchedEffect
        }

        val intervalMs = (60_000L / bpm.coerceAtLeast(1)).coerceAtLeast(1L)
        currentBeat = 0
        while (isActive) {
            playClick()
            delay(intervalMs)
            currentBeat = (currentBeat + 1) % bars
        }
    }

    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(1.dp, primaryColor.copy(alpha = 0.45f)),
        shadowElevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Metronomo",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.weight(1f)
                )
                IconButton(
                    enabled = uiState.metronomeMode == MetronomeMode.MANUAL ||
                        (hasLoadedAudio && !uiState.isOnsetScanRunning),
                    onClick = {
                        if (uiState.metronomeMode == MetronomeMode.MANUAL) {
                            isMetronomeRunning = false
                            currentBeat = 0
                            onAction(AudioUiAction.ResetTapTempo)
                        } else {
                            onReadBpm(true)
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Refresh,
                        contentDescription = "Repor batidas"
                    )
                }
            }

            SingleChoiceSegmentedButtonRow(
                modifier = Modifier.fillMaxWidth()
            ) {
                SegmentedButton(
                    selected = uiState.metronomeMode == MetronomeMode.MANUAL,
                    onClick = {
                        onAction(AudioUiAction.SelectMetronomeMode(MetronomeMode.MANUAL))
                    },
                    shape = SegmentedButtonDefaults.itemShape(index = 0, count = 2),
                    icon = {}
                ) {
                    Text("Manual", maxLines = 1, overflow = TextOverflow.Ellipsis)
                }
                SegmentedButton(
                    selected = uiState.metronomeMode == MetronomeMode.AUTOMATIC,
                    onClick = {
                        onAction(AudioUiAction.SelectMetronomeMode(MetronomeMode.AUTOMATIC))
                    },
                    shape = SegmentedButtonDefaults.itemShape(index = 1, count = 2),
                    icon = {}
                ) {
                    Text("Automatico", maxLines = 1, overflow = TextOverflow.Ellipsis)
                }
            }

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                if (uiState.metronomeMode == MetronomeMode.MANUAL) {
                    Surface(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .clickable {
                                bpmInputValue = bpmText.takeIf { it != "-" } ?: "0"
                                isBpmDialogOpen = true
                            },
                        shape = RoundedCornerShape(8.dp),
                        color = MaterialTheme.colorScheme.surfaceContainerHighest,
                        border = BorderStroke(1.dp, primaryColor.copy(alpha = 0.65f))
                    ) {
                        Text(
                            text = "BPM: $bpmText",
                            modifier = Modifier.padding(horizontal = 22.dp, vertical = 12.dp),
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                } else {
                    Text(
                        text = "BPM: $bpmText",
                        modifier = Modifier.padding(vertical = 12.dp),
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            MeterDropdownButton(
                selectedLabel = uiState.metronomeMeterLabel,
                isExpanded = uiState.isMetronomeMeterMenuExpanded,
                onToggle = { onAction(AudioUiAction.ToggleMetronomeMeterMenu) },
                onDismiss = { onAction(AudioUiAction.DismissMetronomeMeterMenu) },
                onSelect = { option ->
                    currentBeat = 0
                    onAction(AudioUiAction.SelectMetronomeMeter(option))
                }
            )

            BeatDots(
                bars = bars,
                currentBeat = currentBeat
            )

            MetronomePlayButton(
                isRunning = isMetronomeRunning,
                enabled = displayedBpm != null,
                onClick = {
                    if (!isMetronomeRunning) {
                        currentBeat = 0
                    }
                    isMetronomeRunning = !isMetronomeRunning
                }
            )

            if (uiState.metronomeMode == MetronomeMode.MANUAL) {
                TapTempoButton(
                    onTapTempo = { elapsedRealtimeMs ->
                        onAction(AudioUiAction.RegisterTapTempo(elapsedRealtimeMs))
                    }
                )
            }
        }
    }

    if (isBpmDialogOpen) {
        AlertDialog(
            onDismissRequest = { isBpmDialogOpen = false },
            title = { Text("Definir BPM Manual") },
            text = {
                Column {
                    Text(
                        text = "digite um numero de BPM de 0 ao $maxBpm",
                        modifier = Modifier.padding(bottom = 16.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    OutlinedTextField(
                        value = bpmInputValue,
                        onValueChange = { bpmInputValue = it },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        val bpm = bpmInputValue.toIntOrNull()
                        if (bpm != null && bpm in 0..maxBpm) {
                            onAction(AudioUiAction.SetManualBpm(bpm))
                            isBpmDialogOpen = false
                        }
                    }
                ) {
                    Text("Confirmar")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { isBpmDialogOpen = false }
                ) {
                    Text("Cancelar")
                }
            }
        )
    }
}

@Composable
private fun MeterDropdownButton(
    selectedLabel: String,
    isExpanded: Boolean,
    onToggle: () -> Unit,
    onDismiss: () -> Unit,
    onSelect: (MeterOption) -> Unit
) {
    val primaryColor = MaterialTheme.colorScheme.primary

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .clickable(onClick = onToggle),
            shape = RoundedCornerShape(8.dp),
            color = MaterialTheme.colorScheme.surfaceContainerHighest,
            border = BorderStroke(1.dp, primaryColor.copy(alpha = 0.65f))
        ) {
            Text(
                text = selectedLabel,
                modifier = Modifier.padding(horizontal = 22.dp, vertical = 12.dp),
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = onDismiss,
            containerColor = MaterialTheme.colorScheme.surface
        ) {
            MetronomeMeterOptions.forEach { option ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = option.label,
                            fontWeight = if (option.label == selectedLabel) {
                                FontWeight.SemiBold
                            } else {
                                FontWeight.Normal
                            }
                        )
                    },
                    onClick = { onSelect(option) }
                )
            }
        }
    }
}

@Composable
private fun BeatDots(
    bars: Int,
    currentBeat: Int
) {
    val primaryColor = MaterialTheme.colorScheme.primary

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(bars) { index ->
            Box(
                modifier = Modifier
                    .padding(horizontal = 6.dp)
                    .size(16.dp)
                    .clip(CircleShape)
                    .background(
                        if (index == currentBeat % bars) {
                            primaryColor
                        } else {
                            MaterialTheme.colorScheme.surfaceVariant
                        }
                    )
            )
        }
    }
}

@Composable
private fun MetronomePlayButton(
    isRunning: Boolean,
    enabled: Boolean,
    onClick: () -> Unit
) {
    val primaryColor = MaterialTheme.colorScheme.primary
    val containerColor = if (enabled) {
        MaterialTheme.colorScheme.surfaceContainerHighest
    } else {
        MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f)
    }
    val contentColor = if (enabled) {
        primaryColor
    } else {
        MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.45f)
    }

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier
                .size(88.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable(enabled = enabled, onClick = onClick),
            shape = RoundedCornerShape(8.dp),
            color = containerColor,
            border = BorderStroke(1.dp, primaryColor.copy(alpha = if (enabled) 0.65f else 0.25f))
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = if (isRunning) Icons.Rounded.Pause else Icons.Rounded.PlayArrow,
                    contentDescription = if (isRunning) "Pausar metronomo" else "Iniciar metronomo",
                    modifier = Modifier.size(42.dp),
                    tint = contentColor
                )
            }
        }
    }
}

@Composable
private fun TapTempoButton(
    onTapTempo: (Long) -> Unit
) {
    val primaryColor = MaterialTheme.colorScheme.primary

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(62.dp)
            .clip(RoundedCornerShape(8.dp))
            .pointerInput(onTapTempo) {
                awaitPointerEventScope {
                    while (true) {
                        val event = awaitPointerEvent()
                        if (event.type == PointerEventType.Press) {
                            onTapTempo(SystemClock.elapsedRealtime())
                        }
                    }
                }
            },
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.surfaceContainerHighest,
        border = BorderStroke(1.dp, primaryColor.copy(alpha = 0.65f))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 22.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Rounded.PlayArrow,
                contentDescription = null,
                tint = primaryColor,
                modifier = Modifier.size(30.dp)
            )
            Text(
                text = "Tap BPM",
                modifier = Modifier.padding(start = 16.dp),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
private fun rememberMetronomeClick(): () -> Unit {
    val isInPreview = LocalInspectionMode.current
    val toneGenerator = remember(isInPreview) {
        if (isInPreview) {
            null
        } else {
            ToneGenerator(AudioManager.STREAM_MUSIC, 80)
        }
    }

    DisposableEffect(toneGenerator) {
        onDispose {
            toneGenerator?.release()
        }
    }

    return remember(toneGenerator) {
        {
            toneGenerator?.startTone(ToneGenerator.TONE_PROP_BEEP, 70)
        }
    }
}

@Composable
private fun RepeatMarkerButton(
    label: String,
    enabled: Boolean,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    FilledIconButton(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier.size(40.dp),
        shape = RoundedCornerShape(12.dp),
        colors = IconButtonDefaults.filledIconButtonColors(
            containerColor = if (isSelected) {
                MaterialTheme.colorScheme.primaryContainer
            } else {
                MaterialTheme.colorScheme.secondaryContainer
            },
            contentColor = if (isSelected) {
                MaterialTheme.colorScheme.onPrimaryContainer
            } else {
                MaterialTheme.colorScheme.onSecondaryContainer
            },
            disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f),
            disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.45f)
        )
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun PlaybackControlsSection(
    modifier: Modifier = Modifier,
    durationMs: Long,
    positionMs: Long,
    hasLoadedAudio: Boolean,
    isPlaying: Boolean,
    isRepeatEnabled: Boolean,
    selectedSpeed: PlaybackSpeedOption,
    isSpeedMenuExpanded: Boolean,
    repeatPointA: Long?,
    repeatPointB: Long?,
    onPlayPauseToggle: () -> Unit,
    onPositionChange: (Long) -> Unit,
    onRepeatToggle: () -> Unit,
    onSpeedMenuToggle: () -> Unit,
    onSpeedMenuDismiss: () -> Unit,
    onSpeedSelected: (PlaybackSpeedOption) -> Unit
) {
    val safeDurationMs = durationMs.coerceAtLeast(0L)
    val safePositionMs = positionMs.coerceIn(0L, safeDurationMs)
    val sliderValue = if (safeDurationMs > 0L) {
        safePositionMs.toFloat() / safeDurationMs.toFloat()
    } else {
        0f
    }

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),
        tonalElevation = 8.dp,
        shadowElevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 14.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = formatPlaybackTime(safePositionMs),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium
                )

                BoxWithConstraints(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 20.dp)
                ) {
                    val density = LocalDensity.current
                    val trackWidthPx = with(density) { maxWidth.toPx() }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .zIndex(1f)
                    ) {
                        Slider(
                            value = sliderValue,
                            onValueChange = { fraction ->
                                val newPosition = if (safeDurationMs > 0L) {
                                    (safeDurationMs * fraction).roundToLong()
                                } else {
                                    0L
                                }
                                onPositionChange(newPosition)
                            },
                            modifier = Modifier.fillMaxWidth(),
                            valueRange = 0f..1f,
                            colors = SliderDefaults.colors(
                                thumbColor = MaterialTheme.colorScheme.primary,
                                activeTrackColor = MaterialTheme.colorScheme.primaryContainer,
                                inactiveTrackColor = MaterialTheme.colorScheme.surfaceVariant
                            )
                        )

                        RepeatSliderMarker(
                            pointMs = repeatPointA,
                            durationMs = safeDurationMs,
                            trackWidthPx = trackWidthPx,
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        )

                        RepeatSliderMarker(
                            pointMs = repeatPointB,
                            durationMs = safeDurationMs,
                            trackWidthPx = trackWidthPx,
                            containerColor = MaterialTheme.colorScheme.tertiary,
                            contentColor = MaterialTheme.colorScheme.onTertiary
                        )
                    }
                }

                Text(
                    text = formatPlaybackTime((safeDurationMs - safePositionMs).coerceAtLeast(0L)),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                RepeatTrackButton(
                    isSelected = isRepeatEnabled,
                    onClick = onRepeatToggle
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    IconButton(
                        onClick = {
                            val tenSecondsMs = 10_000L
                            val basePosition = (safePositionMs - tenSecondsMs).coerceAtLeast(0L)
                            val finalPosition = if (isRepeatEnabled && repeatPointA != null) {
                                basePosition.coerceAtLeast(repeatPointA)
                            } else {
                                basePosition
                            }
                            onPositionChange(finalPosition)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Replay10,
                            contentDescription = "Voltar 10 segundos"
                        )
                    }

                    FilledIconButton(
                        onClick = onPlayPauseToggle,
                        modifier = Modifier.size(72.dp),
                        shape = RoundedCornerShape(22.dp),
                        colors = IconButtonDefaults.filledIconButtonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        )
                    ) {
                        Icon(
                            imageVector = if (isPlaying) Icons.Rounded.Pause else Icons.Rounded.PlayArrow,
                            contentDescription = when {
                                !hasLoadedAudio -> "Escolher audio"
                                isPlaying -> "Pausar"
                                else -> "Reproduzir"
                            },
                            modifier = Modifier.size(34.dp)
                        )
                    }

                    IconButton(
                        onClick = {
                            val thirtySecondsMs = 30_000L
                            val basePosition = (safePositionMs + thirtySecondsMs).coerceAtMost(safeDurationMs)
                            val finalPosition = if (isRepeatEnabled && repeatPointB != null) {
                                basePosition.coerceAtMost(repeatPointB)
                            } else {
                                basePosition
                            }
                            onPositionChange(finalPosition)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Forward30,
                            contentDescription = "Avancar 30 segundos"
                        )
                    }
                }

                SpeedMenuButton(
                    selectedSpeed = selectedSpeed,
                    isExpanded = isSpeedMenuExpanded,
                    onExpandedChange = onSpeedMenuToggle,
                    onDismissRequest = onSpeedMenuDismiss,
                    onSpeedSelected = onSpeedSelected
                )
            }
        }
    }
}

@Composable
private fun BoxScope.RepeatSliderMarker(
    pointMs: Long?,
    durationMs: Long,
    trackWidthPx: Float,
    containerColor: Color,
    contentColor: Color
) {
    if (pointMs == null || durationMs <= 0L || trackWidthPx <= 0f) {
        return
    }

    val density = LocalDensity.current
    val markerSize = 14.dp
    val markerSizePx = with(density) { markerSize.toPx() }
    val fraction = (pointMs.coerceIn(0L, durationMs).toFloat() / durationMs.toFloat()).coerceIn(0f, 1f)
    val xOffset = ((trackWidthPx - markerSizePx).coerceAtLeast(0f) * fraction).roundToInt()

    Surface(
        modifier = Modifier
            .align(Alignment.CenterStart)
            .offset { IntOffset(xOffset, 0) }
            .size(markerSize)
            .zIndex(2f),
        shape = CircleShape,
        color = containerColor,
        contentColor = contentColor,
        shadowElevation = 2.dp
    ) {}
}

@Composable
private fun RepeatTrackButton(
    isSelected: Boolean,
    onClick: () -> Unit
) {
    if (isSelected) {
        FilledIconButton(
            onClick = onClick,
            colors = IconButtonDefaults.filledIconButtonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        ) {
            Icon(
                imageVector = Icons.Rounded.RepeatOne,
                contentDescription = "Repetir faixa"
            )
        }
    } else {
        IconButton(onClick = onClick) {
            Icon(
                imageVector = Icons.Rounded.RepeatOne,
                contentDescription = "Repetir faixa",
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun SpeedMenuButton(
    selectedSpeed: PlaybackSpeedOption,
    isExpanded: Boolean,
    onExpandedChange: () -> Unit,
    onDismissRequest: () -> Unit,
    onSpeedSelected: (PlaybackSpeedOption) -> Unit
) {
    Box {
        FilledTonalButton(
            onClick = onExpandedChange,
            contentPadding = PaddingValues(horizontal = 12.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            if (selectedSpeed.usesDefaultIcon) {
                Icon(
                    painter = painterResource(id = com.avozdedeus.avozdedeusjpc.audio.R.drawable._x_mobiledata_24px),
                    contentDescription = "Velocidade 1x"
                )
            } else {
                Text(
                    text = selectedSpeed.label,
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = onDismissRequest,
            containerColor = MaterialTheme.colorScheme.surface
        ) {
            PlaybackSpeedOptions.forEach { option ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = option.label,
                            fontWeight = if (option == selectedSpeed) {
                                FontWeight.SemiBold
                            } else {
                                FontWeight.Normal
                            }
                        )
                    },
                    onClick = { onSpeedSelected(option) }
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun AudioScreenPreview() {
    AVozDeDeusJPCTheme {
        AudioScreenContent(
            modifier = Modifier.fillMaxSize(),
            uiState = AudioUiState(
                isMetronomeSectionVisible = true,
                onsetDetectionThreshold = 0.4f,
                bpmAnalysis = BpmAnalysisResult(
                    estimatedBpm = 120,
                    movingAverageBpm = null,
                    dominantIntervalMs = 500,
                    validIntervalCount = 24,
                    confidence = 0.62f,
                    validatedBpm = 119.2
                ),
                suggestedMeterLabel = "4/4",
                beatsPerBar = 4
            ),
            playerSnapshot = PlayerSnapshot(),
            audioFileState = AudioFileState(fileName = "Exemplo.mp3"),
            durationMs = 0L,
            positionMs = 0L,
            hasLoadedAudio = true,
            selectedSpeed = defaultPlaybackSpeedOption(),
            onAction = {},
            onReadBpm = {},
            onToggleRepeatA = {},
            onToggleRepeatB = {},
            onClearRepeat = {},
            onPlayPauseToggle = {},
            onPositionChange = {}
        )
    }
}