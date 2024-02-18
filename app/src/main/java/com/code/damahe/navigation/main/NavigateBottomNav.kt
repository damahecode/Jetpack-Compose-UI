package com.code.damahe.navigation.main

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.code.damahe.res.config.MainActivityNavigation

fun NavController.navigateToDestination(navRoute: String, navOptions: NavOptions? = null) {
    this.navigate(navRoute, navOptions)
}

fun NavController.navigateToHomeScreen(navOptions: NavOptions? = null) {
    this.navigate(MainActivityNavigation.homeScreenNavRoute, navOptions)
}

fun NavController.navigateToDemoUIScreen(navOptions: NavOptions? = null) {
    this.navigate(MainActivityNavigation.demoUIScreenNavRoute, navOptions)
}

fun NavController.navigateToTemplateScreen(navOptions: NavOptions? = null) {
    this.navigate(MainActivityNavigation.templateScreenNavRoute, navOptions)
}