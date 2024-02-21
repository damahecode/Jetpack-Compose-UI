package com.code.damahe.navigation.main

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.code.damahe.res.R
import com.code.damahe.activity.PreferenceActivity
import com.code.damahe.feature.screen.DemoUIScreen
import com.code.damahe.feature.screen.HomeScreen
import com.code.damahe.feature.screen.TemplateScreen
import com.code.damahe.feature.screen.home.AnimatedExtendedFloatingActionButtonSample
import com.code.damahe.feature.screen.home.BadgeScreen
import com.code.damahe.feature.screen.home.BottomAppBarWithFAB
import com.code.damahe.feature.screen.home.BottomSheetScaffoldNestedScrollSample
import com.code.damahe.feature.screen.home.ButtonSamples
import com.code.damahe.feature.screen.home.CardSamples
import com.code.damahe.feature.screen.home.CheckboxSamples
import com.code.damahe.feature.screen.home.ChipSamples
import com.code.damahe.feature.screen.home.DatePickerSamples
import com.code.damahe.feature.screen.home.ExitAlwaysBottomAppBar
import com.code.damahe.feature.screen.home.FloatingActionButtonSamples
import com.code.damahe.feature.screen.home.IconButtonSamples
import com.code.damahe.feature.screen.home.ListSamples
import com.code.damahe.feature.screen.home.MenuSamples
import com.code.damahe.feature.screen.home.ModalBottomSheetSample
import com.code.damahe.feature.screen.home.NavigationBarSamples
import com.code.damahe.feature.screen.home.NavigationRailSamples
import com.code.damahe.feature.screen.home.RadioButtonSamples
import com.code.damahe.feature.screen.home.SegmentedButtonSamples
import com.code.damahe.feature.screen.home.SimpleBottomAppBar
import com.code.damahe.feature.screen.home.SimpleBottomSheetScaffoldSample
import com.code.damahe.feature.screen.home.SwitchSamples
import com.code.damahe.feature.screen.template.LoginSignupScreen
import com.code.damahe.feature.screen.template.ProfileScreen
import com.code.damahe.navigation.NavAppState
import com.code.damahe.res.config.AppActivity
import com.code.damahe.res.config.MainActivityNavigation.animatedExtendedFloatingActionButtonSample
import com.code.damahe.res.config.MainActivityNavigation.homeScreenNavRoute
import com.code.damahe.res.config.MainActivityNavigation.demoUIScreenNavRoute
import com.code.damahe.res.config.MainActivityNavigation.badgeScreenNavRoute
import com.code.damahe.res.config.MainActivityNavigation.bottomAppBarWithFabNavRoute
import com.code.damahe.res.config.MainActivityNavigation.bottomSheetScaffoldNestedScrollNavRoute
import com.code.damahe.res.config.MainActivityNavigation.buttonSamples
import com.code.damahe.res.config.MainActivityNavigation.cardSamples
import com.code.damahe.res.config.MainActivityNavigation.checkBoxes
import com.code.damahe.res.config.MainActivityNavigation.chipSamples
import com.code.damahe.res.config.MainActivityNavigation.datePickerSamples
import com.code.damahe.res.config.MainActivityNavigation.exitAlwaysBottomAppBarNavRoute
import com.code.damahe.res.config.MainActivityNavigation.floatingActionButtonSamples
import com.code.damahe.res.config.MainActivityNavigation.iconButtonSamples
import com.code.damahe.res.config.MainActivityNavigation.listSamples
import com.code.damahe.res.config.MainActivityNavigation.loginSignupScreenNavRoute
import com.code.damahe.res.config.MainActivityNavigation.menuSamples
import com.code.damahe.res.config.MainActivityNavigation.modalBottomSheetNavRoute
import com.code.damahe.res.config.MainActivityNavigation.navigationBarSamples
import com.code.damahe.res.config.MainActivityNavigation.navigationRailSamples
import com.code.damahe.res.config.MainActivityNavigation.profileScreenNavRoute
import com.code.damahe.res.config.MainActivityNavigation.radioButtonSamples
import com.code.damahe.res.config.MainActivityNavigation.segmentedButtonSamples
import com.code.damahe.res.config.MainActivityNavigation.simpleBottomAppBarNavRoute
import com.code.damahe.res.config.MainActivityNavigation.simpleBottomSheetScaffoldNavRoute
import com.code.damahe.res.config.MainActivityNavigation.switchSamples
import com.code.damahe.res.config.MainActivityNavigation.templateScreenNavRoute

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

        composable(
            route = homeScreenNavRoute,
        ) {
            HomeScreen(
                navigateToDestination = {
                    navAppState.navigateToDestination(it)
                },
                startAppActivity = { context, activityName ->
                    if (activityName == AppActivity.PREFERENCE_ACTIVITY) {
                        val intent = Intent(context, PreferenceActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        context.startActivity(intent)
                    }
                }
            )
        }

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
            route = demoUIScreenNavRoute,
        ) {
            DemoUIScreen()
        }

        composable(
            route = templateScreenNavRoute,
        ) {
            TemplateScreen(
                onClick = { featureList, context ->
                    when (featureList.name) {
                        context.getString(R.string.txt_preferences) -> {
                            val intent = Intent(context, PreferenceActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                            context.startActivity(intent)
                        }
                        context.getString(R.string.txt_profile) -> navAppState.navigateToDestination(profileScreenNavRoute)
                        context.getString(R.string.txt_login_signup) -> navAppState.navigateToDestination(loginSignupScreenNavRoute)
                    }
                }
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