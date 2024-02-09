package com.code.damahe.navigation.main

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.code.damahe.res.config.DemoUIScreenNavigation
import com.code.damahe.res.config.HomeScreenNavigation
import com.code.damahe.res.config.TemplateScreenNavigation

fun NavController.navigateToHomeScreen(navOptions: NavOptions? = null) {
    this.navigate(HomeScreenNavigation.homeScreenNavRoute, navOptions)
}

fun NavController.navigateToDemoUIScreen(navOptions: NavOptions? = null) {
    this.navigate(DemoUIScreenNavigation.demoUIScreenNavRoute, navOptions)
}

fun NavController.navigateToTemplateScreen(navOptions: NavOptions? = null) {
    this.navigate(TemplateScreenNavigation.templateScreenNavRoute, navOptions)
}