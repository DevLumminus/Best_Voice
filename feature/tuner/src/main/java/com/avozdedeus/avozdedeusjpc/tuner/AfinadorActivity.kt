package com.avozdedeus.avozdedeusjpc.tuner

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.matchParentSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.PI
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import com.avozdedeus.avozdedeusjpc.core.designsystem.component.AppBottomBar
import com.avozdedeus.avozdedeusjpc.core.designsystem.component.AppTopBar
import com.avozdedeus.avozdedeusjpc.core.designsystem.theme.AVozDeDeusJPCTheme
import com.avozdedeus.avozdedeusjpc.core.navigation.AppNavigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AfinadorActivity : ComponentActivity() {
    @Inject
    lateinit var appNavigator: AppNavigator

    private val viewModel: AfinadorViewModel by viewModels()

    private val pitchAnalyzer by lazy {
        AudioRecordTunerPitchAnalyzer(
            onPitchDetected = viewModel::onPitchDetected,
            onPitchLost = viewModel::onPitchLost
        )
    }

    private val requestMicrophonePermission = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted && lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            pitchAnalyzer.start()
        } else {
            viewModel.onPitchLost()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val uiState by viewModel.uiState.collectAsState()
            AVozDeDeusJPCTheme {
                AfinadorScreen(
                    uiState = uiState,
                    onHomeClick = { appNavigator.openHome(this) },
                    onAudioClick = { appNavigator.openAudio(this) },
                    onTunerClick = { appNavigator.openTuner(this) },
                    onSettingsClick = { appNavigator.openSettings(this) },
                    onAboutClick = { appNavigator.openAbout(this) },
                    onAllTunedDialogDismissed = viewModel::onAllTunedDialogDismissed
                )
            }
        }
    }

    override fun onStart() {
        super.onStart()
        startListeningIfAllowed()
    }

    override fun onStop() {
        pitchAnalyzer.stop()
        viewModel.resetTuner()
        super.onStop()
    }

    private fun startListeningIfAllowed() {
        if (
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.RECORD_AUDIO
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            pitchAnalyzer.start()
        } else {
            requestMicrophonePermission.launch(Manifest.permission.RECORD_AUDIO)
        }
    }
}

@Composable
private fun AfinadorScreen(
    uiState: AfinadorUiState,
    onHomeClick: () -> Unit,
    onAudioClick: () -> Unit,
    onTunerClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onAboutClick: () -> Unit,
    onAllTunedDialogDismissed: () -> Unit
) {
    if (uiState.showAllTunedDialog) {
        AlertDialog(
            onDismissRequest = onAllTunedDialogDismissed,
            text = {
                Text(
                    text = "Todas suas cordas estão afinadas",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            confirmButton = {
                TextButton(onClick = onAllTunedDialogDismissed) {
                    Text(text = "OK")
                }
            }
        )
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            AppTopBar(
                onHomeClick = onHomeClick,
                onSettingsClick = onSettingsClick,
                onAboutClick = onAboutClick
            )
        },
        bottomBar = {
            AppBottomBar(
                currentDestination = uiState.currentDestination,
                onHomeClick = onHomeClick,
                onAudioClick = onAudioClick,
                onTunerClick = onTunerClick
            )
        },
        containerColor = MaterialTheme.colorScheme.surface
    ) { innerPadding ->
        TunerStage(
            uiState = uiState,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}

@Composable
private fun TunerStage(
    uiState: AfinadorUiState,
    modifier: Modifier = Modifier
) {
    val arcColor = MaterialTheme.colorScheme.surface
    
    BoxWithConstraints(
        modifier = modifier.background(MaterialTheme.colorScheme.background)
    ) {
        val stageWidth = maxWidth
        val meterHeight = (maxHeight * 0.35f).coerceIn(140.dp, 280.dp)
        val meterWidth = (maxWidth * 0.95f).coerceIn(240.dp, 440.dp)
        val noteSize = (maxWidth * 0.11f).coerceIn(36.dp, 48.dp)
        val guitarWidth = (maxWidth * 0.62f).coerceIn(180.dp, 280.dp)
        val symbolSize = (meterHeight.value * 0.18f).coerceIn(16f, 32f).sp

        val arcWidthDp = meterWidth * 0.78f
        val arcTopDp = meterHeight * 0.20f
        val textYOffset = arcTopDp + (arcWidthDp / 2f) - 14.dp

        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(meterHeight),
                contentAlignment = Alignment.TopCenter
            ) {
                TunerMeter(
                    arcColor = arcColor,
                    hasPitch = uiState.hasPitch,
                    centsForMeter = uiState.centsForMeter,
                    detectedNoteLabel = uiState.detectedNoteLabel,
                    modifier = Modifier
                        .size(width = meterWidth, height = meterHeight)
                        .align(Alignment.TopCenter)
                )

                Text(
                    text = "b",
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = symbolSize,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(start = stageWidth * 0.06f)
                        .offset(y = textYOffset)
                )

                Text(
                    text = "#",
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = symbolSize,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(end = stageWidth * 0.06f)
                        .offset(y = textYOffset)
                )
            }

            GuitarWithNotes(
                uiState = uiState,
                noteSize = noteSize,
                guitarWidth = guitarWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
        }
    }
}

@Composable
private fun GuitarWithNotes(
    uiState: AfinadorUiState,
    noteSize: Dp,
    guitarWidth: Dp,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(
        modifier = modifier.fillMaxHeight(0.6f),
        contentAlignment = Alignment.TopCenter
    ) {
        val edgeInset = 2.dp
        val rowTops = listOf(0.20f, 0.36f, 0.51f)
        val noteFontSize = (noteSize.value * 0.38f).sp

        Image(
            painter = painterResource(id = R.drawable.tuner_guitar_head),
            contentDescription = "Cabeca do violao",
            modifier = Modifier
                .width(guitarWidth)
                .fillMaxHeight()
                .align(Alignment.TopCenter),
            contentScale = ContentScale.Fit,
            alignment = Alignment.BottomCenter
        )

        StringBubble(
            stringId = GuitarStringId.D,
            isAccent = uiState.isStringAccent(GuitarStringId.D),
            noteSize = noteSize,
            fontSize = noteFontSize,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = edgeInset)
                .offset(y = maxHeight * rowTops[0])
        )
        StringBubble(
            stringId = GuitarStringId.A,
            isAccent = uiState.isStringAccent(GuitarStringId.A),
            noteSize = noteSize,
            fontSize = noteFontSize,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = edgeInset)
                .offset(y = maxHeight * rowTops[1])
        )
        StringBubble(
            stringId = GuitarStringId.LOW_E,
            isAccent = uiState.isStringAccent(GuitarStringId.LOW_E),
            noteSize = noteSize,
            fontSize = noteFontSize,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = edgeInset)
                .offset(y = maxHeight * rowTops[2])
        )
        StringBubble(
            stringId = GuitarStringId.G,
            isAccent = uiState.isStringAccent(GuitarStringId.G),
            noteSize = noteSize,
            fontSize = noteFontSize,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = edgeInset)
                .offset(y = maxHeight * rowTops[0])
        )
        StringBubble(
            stringId = GuitarStringId.B,
            isAccent = uiState.isStringAccent(GuitarStringId.B),
            noteSize = noteSize,
            fontSize = noteFontSize,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = edgeInset)
                .offset(y = maxHeight * rowTops[1])
        )
        StringBubble(
            stringId = GuitarStringId.HIGH_E,
            isAccent = uiState.isStringAccent(GuitarStringId.HIGH_E),
            noteSize = noteSize,
            fontSize = noteFontSize,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = edgeInset)
                .offset(y = maxHeight * rowTops[2])
        )
    }
}

private fun AfinadorUiState.isStringAccent(stringId: GuitarStringId): Boolean {
    return liveStringId == stringId || stringId in tunedStringIds
}

@Composable
private fun StringBubble(
    stringId: GuitarStringId,
    isAccent: Boolean,
    noteSize: Dp,
    fontSize: TextUnit,
    modifier: Modifier = Modifier
) {
    NoteBubble(
        note = stringId.displayNote,
        isHighlighted = isAccent,
        fontSize = fontSize,
        modifier = modifier.size(noteSize)
    )
}

@Composable
private fun TunerMeter(
    arcColor: Color,
    hasPitch: Boolean,
    centsForMeter: Double?,
    detectedNoteLabel: String?,
    modifier: Modifier = Modifier
) {
    val targetFraction = if (hasPitch && centsForMeter != null) {
        TunerPitch.meterIndicatorFraction(centsForMeter)
    } else {
        0f
    }
    val animatedFraction by animateFloatAsState(
        targetValue = targetFraction,
        animationSpec = spring(dampingRatio = 0.75f, stiffness = 400f),
        label = "meterFraction"
    )
    val activeSegmentIndex = if (hasPitch && centsForMeter != null) {
        TunerPitch.meterIndicatorSegmentIndex(centsForMeter)
    } else {
        null
    }
    val isInTune = hasPitch &&
        centsForMeter != null &&
        kotlin.math.abs(centsForMeter) <= TunerPitch.METER_IN_TUNE_CENTS

    BoxWithConstraints(modifier = modifier) {
        val arcWidthDp = maxWidth * 0.78f
        val arcTopDp = maxHeight * 0.20f
        val strokeWidthDp = arcWidthDp * 0.065f
        val noteTopOffset = arcTopDp + (arcWidthDp / 2f) - (strokeWidthDp * 1.35f)
        val noteFontSize = (arcWidthDp.value * 0.13f).coerceIn(24f, 38f).sp

        Canvas(modifier = Modifier.matchParentSize()) {
            val arcWidth = size.width * 0.78f
            val arcHeight = arcWidth
            val strokeWidth = arcWidth * 0.065f
            val arcLeft = (size.width - arcWidth) / 2f
            val arcTop = size.height * 0.20f
            val arcCenterX = arcLeft + arcWidth / 2f
            val arcCenterY = arcTop + arcHeight / 2f
            val arcRadius = arcWidth / 2f - strokeWidth / 2f

            val segmentCount = 11
            val segmentSweep = 8f
            val totalSweep = 180f - segmentSweep
            val step = totalSweep / (segmentCount - 1)
            val segmentColors = listOf(
                TunerRed,
                TunerOrange,
                TunerOrange,
                TunerYellow,
                TunerYellow,
                TunerGreen,
                TunerYellow,
                TunerYellow,
                TunerOrange,
                TunerOrange,
                TunerRed
            )
            val trackAlpha = 0.38f

            repeat(segmentCount) { index ->
                if (index != 5) {
                    val color = segmentColors[index]
                    drawArc(
                        color = color,
                        startAngle = 180f + (index * step),
                        sweepAngle = segmentSweep,
                        useCenter = false,
                        topLeft = Offset(arcLeft, arcTop),
                        size = Size(arcWidth, arcHeight),
                        style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                    )
                }
            }

            if (hasPitch && !isInTune) {
                val angleRadians = TunerPitch.meterIndicatorAngleDegrees(animatedFraction) * PI.toFloat() / 180f
                val indicatorX = arcCenterX + arcRadius * cos(angleRadians)
                val indicatorY = arcCenterY + arcRadius * sin(angleRadians)
                val indicatorRadius = strokeWidth * 0.55f

                drawCircle(
                    color = Color.White,
                    radius = indicatorRadius * 1.35f,
                    center = Offset(indicatorX, indicatorY)
                )
                drawCircle(
                    color = TunerGreen,
                    radius = indicatorRadius,
                    center = Offset(indicatorX, indicatorY)
                )
            }

            val triangleWidth = arcWidth * 0.08f
            val triangleHeight = arcWidth * 0.07f
            val centerX = size.width / 2f

            drawPath(
                path = Path().apply {
                    val topY = arcTop - (strokeWidth * 0.2f)
                    val bottomY = topY + triangleHeight
                    moveTo(centerX, bottomY)
                    lineTo(centerX - (triangleWidth / 2f), topY)
                    lineTo(centerX + (triangleWidth / 2f), topY)
                    close()
                },
                color = TunerGreen
            )

            if (!hasPitch) {
                val barWidth = arcWidth * 0.14f
                val barHeight = arcWidth * 0.05f
                val barTopY = arcTop + (arcWidth / 2f) - (barHeight / 2f) - (strokeWidth * 0.5f)

                drawRoundRect(
                    color = arcColor,
                    topLeft = Offset(
                        x = (size.width - barWidth) / 2f,
                        y = barTopY
                    ),
                    size = Size(barWidth, barHeight),
                    cornerRadius = CornerRadius(barHeight / 2f, barHeight / 2f)
                )
            }
        }

        if (hasPitch && detectedNoteLabel != null) {
            Text(
                text = detectedNoteLabel,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = noteFontSize,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(y = noteTopOffset)
            )
        }
    }
}

@Composable
private fun NoteBubble(
    note: String,
    isHighlighted: Boolean,
    fontSize: TextUnit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = CircleShape,
        color = if (isHighlighted) TunerOrange else TunerGreen,
        contentColor = TunerText
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = note,
                fontSize = fontSize,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

private val TunerBackground = Color(0xFF102A2A)
private val TunerAqua = Color(0xFFE1EFEE)
private val TunerGreen = Color(0xFF58D38A)
private val TunerYellow = Color(0xFFF6E926)
private val TunerOrange = Color(0xFFF4A23A)
private val TunerRed = Color(0xFFF1232F)
private val TunerText = Color(0xFF102A2A)

@Preview(showBackground = true, showSystemUi = true, device = Devices.PHONE)
@Composable
private fun AfinadorScreenPreviewPhone() {
    AVozDeDeusJPCTheme(darkTheme = true) {
        AfinadorScreen(
            uiState = AfinadorUiState(),
            onHomeClick = {},
            onAudioClick = {},
            onTunerClick = {},
            onSettingsClick = {},
            onAboutClick = {},
            onAllTunedDialogDismissed = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_7_PRO)
@Composable
private fun AfinadorScreenPreviewLarge() {
    AVozDeDeusJPCTheme(darkTheme = true) {
        AfinadorScreen(
            uiState = AfinadorUiState(
                detectedNoteLabel = "E",
                hasPitch = true,
                liveStringId = GuitarStringId.HIGH_E,
                centsForMeter = -18.0,
                tunedStringIds = setOf(GuitarStringId.LOW_E, GuitarStringId.A)
            ),
            onHomeClick = {},
            onAudioClick = {},
            onTunerClick = {},
            onSettingsClick = {},
            onAboutClick = {},
            onAllTunedDialogDismissed = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_7_PRO)
@Composable
private fun AfinadorScreenPreviewSharp() {
    AVozDeDeusJPCTheme(darkTheme = true) {
        AfinadorScreen(
            uiState = AfinadorUiState(
                detectedNoteLabel = "E",
                hasPitch = true,
                liveStringId = GuitarStringId.HIGH_E,
                centsForMeter = 12.0,
                tunedStringIds = setOf(GuitarStringId.LOW_E, GuitarStringId.A)
            ),
            onHomeClick = {},
            onAudioClick = {},
            onTunerClick = {},
            onSettingsClick = {},
            onAboutClick = {},
            onAllTunedDialogDismissed = {}
        )
    }
}
