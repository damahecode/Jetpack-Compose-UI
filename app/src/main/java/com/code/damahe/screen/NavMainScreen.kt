package com.code.damahe.screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.code.damahe.material.theme.DCodeBackground
import com.code.damahe.material.theme.DCodeGradientBackground
import com.code.damahe.material.theme.GradientColors
import com.code.damahe.material.theme.LocalGradientColors
import com.code.damahe.navigation.NavAppState
import com.code.damahe.navigation.main.MainBottomNavDest
import com.code.damahe.navigation.main.NavMainHost
import com.code.damahe.navigation.rememberNavAppState
import com.code.damahe.res.icon.DrawIcon

@Composable
fun NavMainScreen(
    windowSizeClass: WindowSizeClass,
    navAppState: NavAppState = rememberNavAppState(
        windowSizeClass = windowSizeClass,
    )
) {

    val shouldShowGradientBackground =
        navAppState.currentMainBottomNavDestination == MainBottomNavDest.HOME

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
                contentWindowInsets = WindowInsets(0, 0, 0, 0),
                bottomBar = {
                    if (navAppState.shouldShowBottomBar && navAppState.mainBottomNavDest.contains(navAppState.currentMainBottomNavDestination)) {
                        DCodeBottomBar(
                            destinations = navAppState.mainBottomNavDest,
                            onNavigateToDestination = navAppState::navigateToBottomNavDestination,
                            currentDestination = navAppState.currentDestination,
                            modifier = Modifier.testTag("DCodeBottomBar"),
                        )
                    }
                },
            ) { padding ->
                Row(
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
                    if (navAppState.shouldShowNavRail && navAppState.mainBottomNavDest.contains(navAppState.currentMainBottomNavDestination)) {
                        DCodeNavRail(
                            destinations = navAppState.mainBottomNavDest,
                            onNavigateToDestination = navAppState::navigateToBottomNavDestination,
                            currentDestination = navAppState.currentDestination,
                            modifier = Modifier.testTag("NiaNavRail"),
                        )
                    }

                    NavMainHost(navAppState)
                }
            }
        }
    }
}

@Composable
fun DCodeNavRail(
    destinations: List<MainBottomNavDest>,
    onNavigateToDestination: (MainBottomNavDest) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
) {
    NavigationRail(
        modifier = modifier,
        contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
        header = null,
    ) {
        destinations.forEach { destination ->
            val hasUnread = false // TODO : Add Function
            val selected = currentDestination.isMainBottomNavDestInHierarchy(destination)
            NavigationRailItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    DrawIcon(icon = destination.selectedIcon, contentDescription = null)
                },
                label = { Text( text = stringResource(destination.iconTextId)) },
                modifier = if (hasUnread) notificationDot() else Modifier,
                colors = NavigationRailItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    selectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    indicatorColor = MaterialTheme.colorScheme.primaryContainer,
                ),
            )
        }

    }

}

@Composable
private fun DCodeBottomBar(
    destinations: List<MainBottomNavDest>,
    onNavigateToDestination: (MainBottomNavDest) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
) {
    NavigationBar(
        modifier = modifier,
        contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
        tonalElevation = 0.dp,
    ) {
        destinations.forEach { destination ->
            val hasUnread = false // TODO : Add Function
            val selected = currentDestination.isMainBottomNavDestInHierarchy(destination)
            NavigationBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    DrawIcon(icon = destination.selectedIcon, contentDescription = null)
                },
                label = { Text(text = stringResource(destination.iconTextId)) },
                modifier = if (hasUnread) notificationDot() else Modifier,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    selectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    indicatorColor = MaterialTheme.colorScheme.primaryContainer,
                ),
            )
        }

    }
}

@Composable
private fun notificationDot(): Modifier {
    val tertiaryColor = MaterialTheme.colorScheme.tertiary
    return Modifier.drawWithContent {
        drawContent()
        drawCircle(
            tertiaryColor,
            radius = 5.dp.toPx(),
            // This is based on the dimensions of the NavigationBar's "indicator pill";
            // however, its parameters are private, so we must depend on them implicitly
            // (NavigationBarTokens.ActiveIndicatorWidth = 64.dp)
            center = center + Offset(
                64.dp.toPx() * .45f,
                32.dp.toPx() * -.45f - 6.dp.toPx(),
            ),
        )
    }
}

private fun NavDestination?.isMainBottomNavDestInHierarchy(destination: MainBottomNavDest) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false


