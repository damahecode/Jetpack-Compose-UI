package com.code.damahe.navigation.main

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.code.damahe.activity.PreferenceActivity
import com.code.damahe.navigation.NavAppState
import com.code.damahe.res.config.AppActivityObject
import com.code.damahe.res.config.HomeScreenNavigation.homeScreenNavRoute

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

        homeScreen(
            navAppState.getContext,
            onNavigateToDestination = {
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

        widgetsScreen()

        animationScreen()

        demoUIScreen()

        templateScreen()

        preferenceScreen(onGoBack = {
            navController.popBackStack()
        })
    }
}