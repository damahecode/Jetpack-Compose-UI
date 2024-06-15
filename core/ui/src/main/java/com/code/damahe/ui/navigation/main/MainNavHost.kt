package com.code.damahe.ui.navigation.main

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.code.damahe.demo.ui.screen.LoginSignupScreen
import com.code.damahe.demo.ui.screen.ProfileScreen
import com.code.damahe.featured.compose.AnimatedExtendedFloatingActionButtonSample
import com.code.damahe.featured.compose.BadgeScreen
import com.code.damahe.featured.compose.BottomAppBarWithFAB
import com.code.damahe.featured.compose.BottomSheetScaffoldNestedScrollSample
import com.code.damahe.featured.compose.ButtonSamples
import com.code.damahe.featured.compose.CardSamples
import com.code.damahe.featured.compose.CheckboxSamples
import com.code.damahe.featured.compose.ChipSamples
import com.code.damahe.featured.compose.DatePickerSamples
import com.code.damahe.featured.compose.ExitAlwaysBottomAppBar
import com.code.damahe.featured.compose.FloatingActionButtonSamples
import com.code.damahe.featured.compose.IconButtonSamples
import com.code.damahe.featured.compose.ListSamples
import com.code.damahe.featured.compose.MenuSamples
import com.code.damahe.featured.compose.ModalBottomSheetSample
import com.code.damahe.featured.compose.NavigationBarSamples
import com.code.damahe.featured.compose.NavigationRailSamples
import com.code.damahe.featured.compose.RadioButtonSamples
import com.code.damahe.featured.compose.SegmentedButtonSamples
import com.code.damahe.featured.compose.SimpleBottomAppBar
import com.code.damahe.featured.compose.SimpleBottomSheetScaffoldSample
import com.code.damahe.featured.compose.SwitchSamples
import com.code.damahe.featured.compose.TabSamples
import com.code.damahe.featured.compose.TextFieldSamples
import com.code.damahe.featured.compose.newcode.DockedSearchBarSample
import com.code.damahe.featured.compose.newcode.SearchBarSample
import com.code.damahe.res.R
import com.code.damahe.res.icon.DCodeIcon
import com.code.damahe.res.icon.MyIcons
import com.code.damahe.ui.model.TopLevelDestination
import com.code.damahe.ui.screen.main.FeaturedScreen
import com.code.damahe.ui.screen.main.HomeScreen
import com.code.damahe.res.navigation.MainActivityNavigation.animatedExtendedFloatingActionButtonSample
import com.code.damahe.res.navigation.MainActivityNavigation.badgeScreenNavRoute
import com.code.damahe.res.navigation.MainActivityNavigation.bottomAppBarWithFabNavRoute
import com.code.damahe.res.navigation.MainActivityNavigation.bottomSheetScaffoldNestedScrollNavRoute
import com.code.damahe.res.navigation.MainActivityNavigation.buttonSamples
import com.code.damahe.res.navigation.MainActivityNavigation.cardSamples
import com.code.damahe.res.navigation.MainActivityNavigation.checkBoxes
import com.code.damahe.res.navigation.MainActivityNavigation.chipSamples
import com.code.damahe.res.navigation.MainActivityNavigation.datePickerSamples
import com.code.damahe.res.navigation.MainActivityNavigation.dockedSearchBarSample
import com.code.damahe.res.navigation.MainActivityNavigation.exitAlwaysBottomAppBarNavRoute
import com.code.damahe.res.navigation.MainActivityNavigation.floatingActionButtonSamples
import com.code.damahe.res.navigation.MainActivityNavigation.iconButtonSamples
import com.code.damahe.res.navigation.MainActivityNavigation.listSamples
import com.code.damahe.res.navigation.MainActivityNavigation.loginSignupScreenNavRoute
import com.code.damahe.res.navigation.MainActivityNavigation.menuSamples
import com.code.damahe.res.navigation.MainActivityNavigation.modalBottomSheetNavRoute
import com.code.damahe.res.navigation.MainActivityNavigation.navigationBarSamples
import com.code.damahe.res.navigation.MainActivityNavigation.navigationRailSamples
import com.code.damahe.res.navigation.MainActivityNavigation.profileScreenNavRoute
import com.code.damahe.res.navigation.MainActivityNavigation.radioButtonSamples
import com.code.damahe.res.navigation.MainActivityNavigation.searchBarSample
import com.code.damahe.res.navigation.MainActivityNavigation.segmentedButtonSamples
import com.code.damahe.res.navigation.MainActivityNavigation.simpleBottomAppBarNavRoute
import com.code.damahe.res.navigation.MainActivityNavigation.simpleBottomSheetScaffoldNavRoute
import com.code.damahe.res.navigation.MainActivityNavigation.switchSamples
import com.code.damahe.res.navigation.MainActivityNavigation.tabSamples
import com.code.damahe.res.navigation.MainActivityNavigation.textFieldSamples
import com.code.damahe.ui.screen.main.DemoUIScreen
import com.code.damahe.ui.screen.main.TemplateScreen

object MainRoute {
    const val HOME = "Home"
    const val FEATURED = "Featured"
    const val DEMO_UI = "DemoUI"
    const val TEMPLATE = "Template"
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
        route = MainRoute.DEMO_UI,
        selectedIcon = DCodeIcon.ImageVectorIcon(MyIcons.Face),
        unselectedIcon = DCodeIcon.ImageVectorIcon(MyIcons.Face),
        iconTextId = R.string.demo_ui
    ),
    TopLevelDestination(
        route = MainRoute.TEMPLATE,
        selectedIcon = DCodeIcon.ImageVectorIcon(MyIcons.List),
        unselectedIcon = DCodeIcon.ImageVectorIcon(MyIcons.List),
        iconTextId = R.string.template
    )
)

@Composable
fun MainNavHost(
    navAppState: MainNavAppState,
    modifier: Modifier = Modifier,
    onDrawerClicked: () -> Unit = {}
) {
    val navController = navAppState.navController

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
        composable(MainRoute.FEATURED) {
            FeaturedScreen(
                navigateToDestination = {
                    navAppState.navigateToDestination(it)
                },
                onDrawerClicked = onDrawerClicked
            )
        }
        composable(MainRoute.DEMO_UI) {
            DemoUIScreen(
                onClick = { featureList, context ->
                    when (featureList.name) {
                        context.getString(R.string.profile) -> navAppState.navigateToDestination(profileScreenNavRoute)
                        context.getString(R.string.login_signup) -> navAppState.navigateToDestination(loginSignupScreenNavRoute)
                    }
                }
            )
        }
        composable(MainRoute.TEMPLATE) {
            TemplateScreen(
                onClick = { featureList, context ->
                    when (featureList.name) {
                        context.getString(R.string.responsive_screen) -> Toast.makeText(context, "Rotate your screen or test your App in different devices", Toast.LENGTH_LONG).show()
                    }
                }
            )
        }

        // Featured
        composable(
            route = badgeScreenNavRoute,
        ) {
            BadgeScreen(
                onGoBack = { navController.popBackStack() },
            )
        }
        composable(
            route = simpleBottomAppBarNavRoute,
        ) {
            SimpleBottomAppBar(
                onGoBack = { navController.popBackStack() },
            )
        }
        composable(
            route = bottomAppBarWithFabNavRoute,
        ) {
            BottomAppBarWithFAB(
                onGoBack = { navController.popBackStack() },
            )
        }
        composable(
            route = exitAlwaysBottomAppBarNavRoute,
        ) {
            ExitAlwaysBottomAppBar(
                onGoBack = { navController.popBackStack() },
            )
        }
        composable(
            route = modalBottomSheetNavRoute,
        ) {
            ModalBottomSheetSample(
                onGoBack = { navController.popBackStack() },
            )
        }
        composable(
            route = simpleBottomSheetScaffoldNavRoute,
        ) {
            SimpleBottomSheetScaffoldSample(
                onGoBack = { navController.popBackStack() },
            )
        }
        composable(
            route = bottomSheetScaffoldNestedScrollNavRoute,
        ) {
            BottomSheetScaffoldNestedScrollSample(
                onGoBack = { navController.popBackStack() },
            )
        }
        composable(
            route = buttonSamples,
        ) {
            ButtonSamples(
                onGoBack = { navController.popBackStack() },
            )
        }
        composable(
            route = cardSamples,
        ) {
            CardSamples(
                onGoBack = { navController.popBackStack() },
            )
        }
        composable(
            route = checkBoxes,
        ) {
            CheckboxSamples(
                onGoBack = { navController.popBackStack() },
            )
        }
        composable(
            route = chipSamples,
        ) {
            ChipSamples(
                onGoBack = { navController.popBackStack() },
            )
        }
        composable(
            route = datePickerSamples,
        ) {
            DatePickerSamples(
                onGoBack = { navController.popBackStack() },
            )
        }
        composable(
            route = floatingActionButtonSamples,
        ) {
            FloatingActionButtonSamples(
                onGoBack = { navController.popBackStack() },
            )
        }
        composable(
            route = animatedExtendedFloatingActionButtonSample,
        ) {
            AnimatedExtendedFloatingActionButtonSample(
                onGoBack = { navController.popBackStack() },
            )
        }
        composable(
            route = iconButtonSamples,
        ) {
            IconButtonSamples(
                onGoBack = { navController.popBackStack() },
            )
        }
        composable(
            route = listSamples,
        ) {
            ListSamples(
                onGoBack = { navController.popBackStack() },
            )
        }
        composable(
            route = menuSamples,
        ) {
            MenuSamples(
                onGoBack = { navController.popBackStack() },
            )
        }
        composable(
            route = navigationBarSamples,
        ) {
            NavigationBarSamples(
                onGoBack = { navController.popBackStack() },
            )
        }
        composable(
            route = navigationRailSamples,
        ) {
            NavigationRailSamples(
                onGoBack = { navController.popBackStack() },
            )
        }
        composable(
            route = radioButtonSamples,
        ) {
            RadioButtonSamples(
                onGoBack = { navController.popBackStack() },
            )
        }
        composable(
            route = segmentedButtonSamples,
        ) {
            SegmentedButtonSamples(
                onGoBack = { navController.popBackStack() },
            )
        }
        composable(
            route = switchSamples,
        ) {
            SwitchSamples(
                onGoBack = { navController.popBackStack() },
            )
        }
        composable(
            route = tabSamples,
        ) {
            TabSamples(
                onGoBack = { navController.popBackStack() },
            )
        }
        composable(
            route = textFieldSamples,
        ) {
            TextFieldSamples(
                onGoBack = { navController.popBackStack() },
            )
        }
        composable(
            route = searchBarSample,
        ) {
            SearchBarSample(
                onGoBack = { navController.popBackStack() },
            )
        }
        composable(
            route = dockedSearchBarSample,
        ) {
            DockedSearchBarSample(
                onGoBack = { navController.popBackStack() },
            )
        }

        composable(
            route = profileScreenNavRoute,
        ) {
            ProfileScreen(
                onGoBack = { navController.popBackStack() }
            )
        }

        composable(
            route = loginSignupScreenNavRoute,
        ) {
            LoginSignupScreen(
                onGoBack = { navController.popBackStack() }
            )
        }
    }
}