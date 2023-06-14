package com.code.damahe.navigation.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.code.damahe.navigation.NavAppState
import com.code.damahe.res.navigation.HomeScreenNavigation.homeScreenNavRoute

@Composable
fun NavMainHost(
    navAppState: NavAppState,
    modifier: Modifier = Modifier,
) {

    val navController = navAppState.navController

    NavHost(
        navController = navController,
        startDestination = homeScreenNavRoute,
        modifier = modifier
    ) {

        homeScreen(onNavigateToDestination = {
            navAppState.navigateToDestination(it)
        })

        widgetsScreen()

        animationScreen()

        demoUIScreen()

        templateScreen()

        preferenceScreen(onGoBack = {
            navController.popBackStack()
        })
    }
}