package com.code.damahe.navigation.main

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.code.damahe.activity.PreferenceActivity
import com.code.damahe.feature.screen.DemoUIScreen
import com.code.damahe.feature.screen.HomeScreen
import com.code.damahe.feature.screen.TemplateScreen
import com.code.damahe.navigation.NavAppState
import com.code.damahe.preferences.screen.PreferenceScreen
import com.code.damahe.res.config.AppActivityObject
import com.code.damahe.res.config.HomeScreenNavigation.homeScreenNavRoute
import com.code.damahe.res.config.DemoUIScreenNavigation.demoUIScreenNavRoute
import com.code.damahe.res.config.PreferenceScreenNavigation.preferenceScreenNavRoute
import com.code.damahe.res.config.TemplateScreenNavigation.templateScreenNavRoute

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
                navAppState.getContext,
                navigateToDestination = {
                    navAppState.navigateToDestination(it)
                },
                startAppActivity = { context, activityName ->
                    if (activityName == AppActivityObject.PREFERENCE_ACTIVITY) {
                        val intent = Intent(context, PreferenceActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        context.startActivity(intent)
                    }
                }
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
            TemplateScreen()
        }

        composable(
            route = preferenceScreenNavRoute,
        ) {
            PreferenceScreen(
                onGoBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}