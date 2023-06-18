package com.code.damahe.navigation.main

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.code.damahe.res.config.AnimationScreenNavigation
import com.code.damahe.res.config.DemoUIScreenNavigation
import com.code.damahe.res.config.HomeScreenNavigation
import com.code.damahe.res.config.TemplateScreenNavigation
import com.code.damahe.res.config.WidgetsScreenNavigation

fun NavController.navigateToHomeScreen(navOptions: NavOptions? = null) {
    this.navigate(HomeScreenNavigation.homeScreenNavRoute, navOptions)
}

fun NavController.navigateToWidgetsScreen(navOptions: NavOptions? = null) {
    this.navigate(WidgetsScreenNavigation.widgetsScreenNavRoute, navOptions)
}

fun NavController.navigateToAnimationScreen(navOptions: NavOptions? = null) {
    this.navigate(AnimationScreenNavigation.animationScreenNavRoute, navOptions)
}

fun NavController.navigateToDemoUIScreen(navOptions: NavOptions? = null) {
    this.navigate(DemoUIScreenNavigation.demoUIScreenNavRoute, navOptions)
}

fun NavController.navigateToTemplateScreen(navOptions: NavOptions? = null) {
    this.navigate(TemplateScreenNavigation.templateScreenNavRoute, navOptions)
}