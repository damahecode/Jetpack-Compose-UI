package com.code.damahe.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import androidx.tracing.trace
import com.code.damahe.navigation.main.MainBottomNavDest
import com.code.damahe.navigation.main.MainBottomNavDest.HOME
import com.code.damahe.navigation.main.MainBottomNavDest.DEMO_UI
import com.code.damahe.navigation.main.MainBottomNavDest.TEMPLATE
import com.code.damahe.navigation.main.navigateToDemoUIScreen
import com.code.damahe.navigation.main.navigateToHomeScreen
import com.code.damahe.navigation.main.navigateToTemplateScreen
import com.code.damahe.res.config.DemoUIScreenNavigation.demoUIScreenNavRoute
import com.code.damahe.res.config.HomeScreenNavigation.homeScreenNavRoute
import com.code.damahe.res.config.TemplateScreenNavigation.templateScreenNavRoute

@Composable
fun rememberNavAppState(
    windowSizeClass: WindowSizeClass,
    navController: NavHostController = rememberNavController(),
): NavAppState {
    return remember(
        navController,
        windowSizeClass,
    ) {
        NavAppState(
            navController,
            windowSizeClass,
        )
    }
}

@Stable
class NavAppState(
    val navController: NavHostController,
    val windowSizeClass: WindowSizeClass,
) {

    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    fun navigateToDestination(route: String) {
        navController.navigate(route)
    }



    val currentMainBottomNavDestination: MainBottomNavDest?
        @Composable get() = when (currentDestination?.route) {
            homeScreenNavRoute -> HOME
            demoUIScreenNavRoute -> DEMO_UI
            templateScreenNavRoute -> TEMPLATE
            else -> null
        }

    val shouldShowBottomBar: Boolean
        get() = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact

    val shouldShowNavRail: Boolean
        get() = !shouldShowBottomBar

    /**
     * Map of top level destinations to be used in the TopBar, BottomBar and NavRail. The key is the
     * route.
     */
    val mainBottomNavDest: List<MainBottomNavDest> = MainBottomNavDest.values().asList()

    /**
     * UI logic for navigating to a top level destination in the app. Top level destinations have
     * only one copy of the destination of the back stack, and save and restore state whenever you
     * navigate to and from it.
     *
     * @param topLevelDestination: The destination the app needs to navigate to.
     */
    fun navigateToBottomNavDestination(topLevelDestination: MainBottomNavDest) {
        trace("Navigation: ${topLevelDestination.name}") {
            val topLevelNavOptions = navOptions {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when
                // reSelecting the same item
                launchSingleTop = true
                // Restore state when reSelecting a previously selected item
                restoreState = true
            }

            when (topLevelDestination) {
                HOME -> navController.navigateToHomeScreen(topLevelNavOptions)
                DEMO_UI -> navController.navigateToDemoUIScreen(topLevelNavOptions)
                TEMPLATE -> navController.navigateToTemplateScreen(topLevelNavOptions)
            }
        }
    }

}