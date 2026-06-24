package com.avozdedeus.avozdedeusjpc.settings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.avozdedeus.avozdedeusjpc.core.designsystem.component.AppBottomBar
import com.avozdedeus.avozdedeusjpc.core.designsystem.component.AppTopBar
import com.avozdedeus.avozdedeusjpc.core.designsystem.theme.AVozDeDeusJPCTheme
import com.avozdedeus.avozdedeusjpc.core.navigation.AppDestination
import com.avozdedeus.avozdedeusjpc.core.navigation.AppNavigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ConfigActivity : ComponentActivity() {
    @Inject
    lateinit var appNavigator: AppNavigator

    private val viewModel: ConfigViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val uiState by viewModel.uiState.collectAsState()
            AVozDeDeusJPCTheme {
                ConfigScreen(
                    uiState = uiState,
                    onHomeClick = { appNavigator.openHome(this) },
                    onAudioClick = { appNavigator.openAudio(this) },
                    onTunerClick = { appNavigator.openTuner(this) },
                    onSettingsClick = { appNavigator.openSettings(this) },
                    onAboutClick = { appNavigator.openAbout(this) },
                    onMetronomeSectionChecked = viewModel::onMetronomeSectionChecked,
                    onNotesSectionChecked = viewModel::onNotesSectionChecked
                )
            }
        }
    }
}

@Composable
private fun ConfigScreen(
    uiState: ConfigUiState,
    onHomeClick: () -> Unit,
    onAudioClick: () -> Unit,
    onTunerClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onAboutClick: () -> Unit,
    onMetronomeSectionChecked: (Boolean) -> Unit,
    onNotesSectionChecked: (Boolean) -> Unit
) {
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Adicionar o metronomo",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(1f)
                )
                Checkbox(
                    checked = uiState.metronomeSectionEnabled,
                    onCheckedChange = onMetronomeSectionChecked
                )
            }
            HorizontalDivider()
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Adicionar notas",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(1f)
                )
                Checkbox(
                    checked = uiState.notesSectionEnabled,
                    onCheckedChange = onNotesSectionChecked
                )
            }
            HorizontalDivider()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ConfigScreenPreview() {
    AVozDeDeusJPCTheme {
        ConfigScreen(
            uiState = ConfigUiState(),
            onHomeClick = {},
            onAudioClick = {},
            onTunerClick = {},
            onSettingsClick = {},
            onAboutClick = {},
            onMetronomeSectionChecked = {},
            onNotesSectionChecked = {}
        )
    }
}
