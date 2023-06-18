package com.code.damahe.navigation.main

import android.content.Context
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.code.damahe.feature.screen.AnimationScreen
import com.code.damahe.feature.screen.DemoUIScreen
import com.code.damahe.feature.screen.HomeScreen
import com.code.damahe.feature.screen.TemplateScreen
import com.code.damahe.feature.screen.WidgetsScreen
import com.code.damahe.preferences.screen.PreferenceScreen
import com.code.damahe.res.config.AnimationScreenNavigation.animationScreenNavRoute
import com.code.damahe.res.config.DemoUIScreenNavigation.demoUIScreenNavRoute
import com.code.damahe.res.config.HomeScreenNavigation.homeScreenNavRoute
import com.code.damahe.res.config.PreferenceScreenNavigation.preferenceScreenNavRoute
import com.code.damahe.res.config.TemplateScreenNavigation.templateScreenNavRoute
import com.code.damahe.res.config.WidgetsScreenNavigation.widgetsScreenNavRoute

fun NavGraphBuilder.homeScreen(context: Context, onNavigateToDestination: (String) -> Unit, startAppActivity: (Context, String) -> Unit) {
    composable(
        route = homeScreenNavRoute,
    ) {
        HomeScreen(context, onNavigateToDestination, startAppActivity)
    }
}

fun NavGraphBuilder.widgetsScreen() {
    composable(
        route = widgetsScreenNavRoute,
    ) {
        WidgetsScreen()
    }
}

fun NavGraphBuilder.animationScreen() {
    composable(
        route = animationScreenNavRoute,
    ) {
        AnimationScreen()
    }
}

fun NavGraphBuilder.demoUIScreen() {
    composable(
        route = demoUIScreenNavRoute,
    ) {
        DemoUIScreen()
    }
}

fun NavGraphBuilder.templateScreen() {
    composable(
        route = templateScreenNavRoute,
    ) {
        TemplateScreen()
    }
}

fun NavGraphBuilder.preferenceScreen(onGoBack: () -> Unit) {
    composable(
        route = preferenceScreenNavRoute,
    ) {
        PreferenceScreen(onGoBack)
    }
}