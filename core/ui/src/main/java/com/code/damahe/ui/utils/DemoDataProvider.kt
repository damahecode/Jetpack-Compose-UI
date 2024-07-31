package com.code.damahe.ui.utils

import android.content.Context
import com.code.damahe.demo.ui.model.FeaturedList
import com.code.damahe.res.R
import com.code.damahe.res.icon.DCodeIcon
import com.code.damahe.res.icon.DCodeIcon.ImageVectorIcon
import com.code.damahe.res.icon.MyIcons
import com.code.damahe.res.navigation.MainActivityNavigation.chatScreenNavRoute
import com.code.damahe.res.navigation.MainActivityNavigation.emptyScreenNavRoute
import com.code.damahe.res.navigation.MainActivityNavigation.locBiometricScreenNavRoute
import com.code.damahe.res.navigation.MainActivityNavigation.loginSignupScreenNavRoute
import com.code.damahe.res.navigation.MainActivityNavigation.onBoardingScreenNavRoute
import com.code.damahe.res.navigation.MainActivityNavigation.profileScreenNavRoute
import com.code.damahe.res.navigation.MainActivityNavigation.settingsScreenNavRoute

object DemoDataProvider {

    fun demoUIListItems(context: Context) = listOf(
        FeaturedList(context.getString(R.string.profile), ImageVectorIcon(MyIcons.Account), profileScreenNavRoute),
        FeaturedList(context.getString(R.string.login_signup), ImageVectorIcon(MyIcons.Account), loginSignupScreenNavRoute),
        FeaturedList(context.getString(R.string.chatScreen), ImageVectorIcon(MyIcons.Send), chatScreenNavRoute),
        FeaturedList(context.getString(R.string.on_boarding), ImageVectorIcon(MyIcons.List), onBoardingScreenNavRoute),
        FeaturedList(context.getString(R.string.empty_screen), ImageVectorIcon(MyIcons.Info), emptyScreenNavRoute),
        FeaturedList(context.getString(R.string.settings), ImageVectorIcon(MyIcons.Settings), settingsScreenNavRoute),
        FeaturedList(context.getString(R.string.pin_loc_biometric), ImageVectorIcon(MyIcons.Lock), locBiometricScreenNavRoute),
    )

    fun templateListItems(context: Context) = listOf(
        FeaturedList(context.getString(R.string.responsive_screen), DCodeIcon.DrawableResourceIcon(MyIcons.CodeTag), ""),
    )
}