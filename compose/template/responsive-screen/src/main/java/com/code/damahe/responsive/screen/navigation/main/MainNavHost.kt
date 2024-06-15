package com.code.damahe.responsive.screen.navigation.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.code.damahe.res.R
import com.code.damahe.res.icon.DCodeIcon
import com.code.damahe.res.icon.MyIcons
import com.code.damahe.responsive.screen.model.TopLevelDestination
import com.code.damahe.responsive.screen.screen.EmptyScreen
import com.code.damahe.responsive.screen.screen.main.HomeScreen

object MainRoute {
    const val HOME = "Home"
    const val FEATURED = "Featured"
    const val SUBSCRIPTIONS = "Subscriptions"
    const val YOU = "You"
}

val MAIN_TOP_LEVEL_DESTINATIONS = listOf(
    TopLevelDestination(
        route = MainRoute.HOME,
        selectedIcon = DCodeIcon.ImageVectorIcon(MyIcons.Home),
        unselectedIcon = DCodeIcon.ImageVectorIcon(MyIcons.Home),
        iconTextId = R.string.home
    ),
    TopLevelDestination(
        route = MainRoute.FEATURED,
        selectedIcon = DCodeIcon.ImageVectorIcon(MyIcons.Star),
        unselectedIcon = DCodeIcon.ImageVectorIcon(MyIcons.Star),
        iconTextId = R.string.featured
    ),
    TopLevelDestination(
        route = MainRoute.SUBSCRIPTIONS,
        selectedIcon = DCodeIcon.ImageVectorIcon(MyIcons.List),
        unselectedIcon = DCodeIcon.ImageVectorIcon(MyIcons.List),
        iconTextId = R.string.subscriptions
    ),
    TopLevelDestination(
        route = MainRoute.YOU,
        selectedIcon = DCodeIcon.ImageVectorIcon(MyIcons.Account),
        unselectedIcon = DCodeIcon.ImageVectorIcon(MyIcons.Account),
        iconTextId = R.string.you
    )
)

@Composable
fun MainNavHost(
    navAppState: MainNavAppState,
    modifier: Modifier = Modifier,
    onDrawerClicked: () -> Unit = {}
) {
    NavHost(
        modifier = modifier,
        navController = navAppState.navController,
        startDestination = MainRoute.HOME,
    ) {
        composable(MainRoute.HOME) {
            HomeScreen(
                contentType = navAppState.contentType,
                navigationType = navAppState.navigationType,
                displayFeatures = navAppState.displayFeatures
            )
        }
        composable(MainRoute.SUBSCRIPTIONS) {
            EmptyScreen()
        }
        composable(MainRoute.FEATURED) {
            EmptyScreen()
        }
        composable(MainRoute.YOU) {
            EmptyScreen()
        }
    }
}