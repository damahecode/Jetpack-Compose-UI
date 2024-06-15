package com.code.damahe.ui.screen.main

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.window.layout.DisplayFeature
import com.code.damahe.material.dialogs.ThemeDialog
import com.code.damahe.material.theme.DCodeBackground
import com.code.damahe.material.theme.DCodeGradientBackground
import com.code.damahe.material.theme.GradientColors
import com.code.damahe.material.theme.LocalGradientColors
import com.code.damahe.res.R
import com.code.damahe.res.icon.DCodeIcon
import com.code.damahe.res.icon.DrawIcon
import com.code.damahe.res.icon.LottieLoadingView
import com.code.damahe.res.icon.MyIcons
import com.code.damahe.ui.screen.EmptyScreen
import com.code.damahe.ui.utils.DCodeContentType
import com.code.damahe.ui.utils.DCodeNavigationType
import com.google.accompanist.adaptive.HorizontalTwoPaneStrategy
import com.google.accompanist.adaptive.TwoPane

@Composable
fun HomeScreen(
    contentType: DCodeContentType,
    navigationType: DCodeNavigationType,
    displayFeatures: List<DisplayFeature>,
    modifier: Modifier = Modifier
) {

    if (contentType == DCodeContentType.DUAL_PANE) {
        TwoPane(
            first = {
                HomeScreenContent(navigationType)
            },
            second = {
                EmptyScreen()
            },
            strategy = HorizontalTwoPaneStrategy(splitFraction = 0.5f, gapWidth = 16.dp),
            displayFeatures = displayFeatures
        )
    } else {
        HomeScreenContent(navigationType)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent(navigationType: DCodeNavigationType,) {
    val context = LocalContext.current

    val showThemeSettingsDialog = remember { mutableStateOf(false) }
    val shouldShowGradientBackground = true //TODO : add method

    if (showThemeSettingsDialog.value) {
        ThemeDialog(
            onDismiss = {showThemeSettingsDialog.value = false},
        )
    }

    val navType = navigationType == DCodeNavigationType.PERMANENT_NAVIGATION_DRAWER || navigationType == DCodeNavigationType.NAVIGATION_RAIL

    DCodeBackground {
        DCodeGradientBackground(
            gradientColors = if (shouldShowGradientBackground) {
                LocalGradientColors.current
            } else {
                GradientColors()
            }
        ) {
            Scaffold(
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.onBackground,
                contentWindowInsets = WindowInsets(0),
                topBar = {
                    TopAppBar(
                        title = { Text(text = stringResource(id = R.string.app_name)) },
                        navigationIcon = {
                            IconButton(onClick = { showThemeSettingsDialog.value = true }
                            ) {
                                DrawIcon(icon = DCodeIcon.ImageVectorIcon(MyIcons.Settings), contentDescription = stringResource(id = R.string.txt_preferences))
                            }
                        },
                        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                            containerColor = Color.Transparent,
                        ),
                        windowInsets = if (navType) WindowInsets(0) else TopAppBarDefaults.windowInsets
                    )
                },
            ) { padding ->
                Box(
                    Modifier
                        .fillMaxSize()
                        .padding(padding)
                        .consumeWindowInsets(padding)
                        .windowInsetsPadding(
                            WindowInsets.safeDrawing.only(
                                WindowInsetsSides.Horizontal,
                            ),
                        ),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .systemBarsPadding()
                            .padding(5.dp)
                            .verticalScroll(rememberScrollState()),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        LottieLoadingView(
                            file = "working.json",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp)
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(text = "Home page is under development")
                        // on below line adding a spacer.
                        Spacer(modifier = Modifier.height(20.dp))
                        Button(onClick = {
                            val urlIntent = Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://github.com/damahecode/Jetpack-Compose-UI")
                            )
                            context.startActivity(urlIntent)
                        }) {
                            Text(
                                text = stringResource(id = R.string.txt_github),
                                modifier = Modifier.padding(10.dp),
                                fontSize = 15.sp
                            )
                        }
                    }
                }
            }
        }
    }
}