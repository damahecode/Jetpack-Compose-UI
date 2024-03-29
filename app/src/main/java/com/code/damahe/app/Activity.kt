package com.code.damahe.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.code.damahe.material.theme.DCodeAppTheme
import com.code.damahe.material.utils.ThemeUtil
import com.code.damahe.material.viewmodel.ThemeUiState
import com.code.damahe.material.viewmodel.ThemeViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
abstract class Activity : ComponentActivity() {

    private val viewModel: ThemeViewModel by viewModels()
    protected var themeUiState: ThemeUiState by mutableStateOf(ThemeUiState.Loading)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Update the uiState
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.themeUiState.onEach {
                    themeUiState = it
                }
                    .collect()
            }
        }
    }
}

/**
 * Your Main Composable Function here
 */
@Composable
fun MainContent(themeUiState: ThemeUiState, content: @Composable () -> Unit) {
    val systemUiController = rememberSystemUiController()
    val darkTheme = ThemeUtil.shouldUseDarkTheme(themeUiState)

    // Update the dark content of the system bars to match the theme
    DisposableEffect(systemUiController, darkTheme) {
        systemUiController.systemBarsDarkContentEnabled = !darkTheme
        onDispose {}
    }

    DCodeAppTheme(
        darkTheme = darkTheme,
        themeBrand = ThemeUtil.shouldUseOtherThemeBrand(themeUiState),
        disableGradientColors = ThemeUtil.shouldDisableGradientColors(themeUiState),
    ) {
        content()
    }
}