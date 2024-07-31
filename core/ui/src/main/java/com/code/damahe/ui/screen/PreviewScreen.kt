package com.code.damahe.ui.screen

import androidx.compose.runtime.Composable
import com.code.damahe.demo.ui.screen.ChatScreen
import com.code.damahe.demo.ui.screen.LoginSignupScreen
import com.code.damahe.demo.ui.screen.OnBoardingScreen
import com.code.damahe.demo.ui.screen.ProfileScreen
import com.code.damahe.material.theme.DCodeBackground
import com.code.damahe.material.theme.DCodeGradientBackground
import com.code.damahe.material.theme.GradientColors
import com.code.damahe.material.theme.LocalGradientColors
import com.code.damahe.res.navigation.MainActivityNavigation.chatScreenNavRoute
import com.code.damahe.res.navigation.MainActivityNavigation.loginSignupScreenNavRoute
import com.code.damahe.res.navigation.MainActivityNavigation.onBoardingScreenNavRoute
import com.code.damahe.res.navigation.MainActivityNavigation.profileScreenNavRoute

@Composable
fun PreviewScreen(route: String?, onGoBack: ()-> Unit) {

    DCodeBackground {
        DCodeGradientBackground(
            gradientColors = LocalGradientColors.current
        ) {
            when (route ?: "") {
                profileScreenNavRoute -> ProfileScreen(onGoBack)
                loginSignupScreenNavRoute -> LoginSignupScreen(onGoBack)
                chatScreenNavRoute -> ChatScreen(onGoBack)
                onBoardingScreenNavRoute -> OnBoardingScreen(onGoBack)
                else -> EmptyScreen()
            }
        }
    }

}