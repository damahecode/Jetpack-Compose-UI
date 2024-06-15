package com.code.damahe.responsive.screen.navigation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.window.layout.DisplayFeature
import com.code.damahe.responsive.screen.model.TopLevelDestination
import com.code.damahe.responsive.screen.utils.DCodeContentType
import com.code.damahe.responsive.screen.utils.DCodeNavigationContentPosition
import com.code.damahe.responsive.screen.utils.DCodeNavigationType

@Composable
fun rememberMainNavAppState(
    navController: NavHostController = rememberNavController(),
    displayFeatures: List<DisplayFeature>,
    navigationType: DCodeNavigationType,
    contentType: DCodeContentType,
    navigationContentPosition: DCodeNavigationContentPosition
): MainNavAppState {
    return remember(
        navController,
        displayFeatures,
        navigationType,
        contentType,
        navigationContentPosition
    ) {
        MainNavAppState(
            navController = navController,
            displayFeatures = displayFeatures,
            navigationType = navigationType,
            contentType = contentType,
            navigationContentPosition = navigationContentPosition
        )
    }
}

@Stable
class MainNavAppState(
    val navController: NavHostController,
    val displayFeatures: List<DisplayFeature>,
    val navigationType: DCodeNavigationType,
    val contentType: DCodeContentType,
    val navigationContentPosition: DCodeNavigationContentPosition,
    ) {

    fun selectedDestination(navBackStackEntry: NavBackStackEntry?) =
        navBackStackEntry?.destination?.route ?: MainRoute.HOME

    fun navigateTo(destination: TopLevelDestination) {
        navController.navigate(destination.route) {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }
    }
}

