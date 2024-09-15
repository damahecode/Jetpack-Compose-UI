package com.code.damahe.ui.utils

import android.content.Context
import com.code.damahe.demo.ui.model.FeaturedList
import com.code.damahe.res.R
import com.code.damahe.res.icon.DCodeIcon
import com.code.damahe.res.icon.DCodeIcon.ImageVectorIcon
import com.code.damahe.res.icon.MyIcons
import com.code.damahe.res.navigation.AppActivity.URL_ACTIVITY
import com.code.damahe.res.navigation.AppActivity.PREVIEW_ACTIVITY
import com.code.damahe.res.navigation.NavigationRoute.chatScreenNavRoute
import com.code.damahe.res.navigation.NavigationRoute.emptyScreenNavRoute
import com.code.damahe.res.navigation.NavigationRoute.locBiometricScreenNavRoute
import com.code.damahe.res.navigation.NavigationRoute.loginSignupScreenNavRoute
import com.code.damahe.res.navigation.NavigationRoute.onBoardingScreenNavRoute
import com.code.damahe.res.navigation.NavigationRoute.profileScreenNavRoute
import com.code.damahe.res.navigation.NavigationRoute.settingsScreenNavRoute

object DemoDataProvider {

    fun demoUIListItems(context: Context) = listOf(
        FeaturedList(context.getString(R.string.profile), ImageVectorIcon(MyIcons.Account), PREVIEW_ACTIVITY, profileScreenNavRoute),
        FeaturedList(context.getString(R.string.login_signup), ImageVectorIcon(MyIcons.Account), PREVIEW_ACTIVITY, loginSignupScreenNavRoute),
        FeaturedList(context.getString(R.string.chatScreen), ImageVectorIcon(MyIcons.Send), PREVIEW_ACTIVITY, chatScreenNavRoute),
        FeaturedList(context.getString(R.string.on_boarding), ImageVectorIcon(MyIcons.List), PREVIEW_ACTIVITY, onBoardingScreenNavRoute),
        FeaturedList(context.getString(R.string.empty_screen), ImageVectorIcon(MyIcons.Info), PREVIEW_ACTIVITY, emptyScreenNavRoute),
        FeaturedList(context.getString(R.string.settings), ImageVectorIcon(MyIcons.Settings), PREVIEW_ACTIVITY, settingsScreenNavRoute),
        FeaturedList(context.getString(R.string.pin_loc_biometric), ImageVectorIcon(MyIcons.Lock), PREVIEW_ACTIVITY, locBiometricScreenNavRoute),
    )

    fun templateListItems(context: Context) = listOf(
        FeaturedList(context.getString(R.string.responsive_ui), DCodeIcon.DrawableResourceIcon(MyIcons.CodeTag), URL_ACTIVITY, ""),
        FeaturedList(context.getString(R.string.music_player), DCodeIcon.DrawableResourceIcon(MyIcons.Music_Library), URL_ACTIVITY,  "https://github.com/damahecode/Leaf-Music-Player"),
        FeaturedList(context.getString(R.string.material_theme), DCodeIcon.DrawableResourceIcon(MyIcons.Palette), URL_ACTIVITY, "https://github.com/damahecode/Material-Theme"),
        FeaturedList(context.getString(R.string.news_app), DCodeIcon.DrawableResourceIcon(MyIcons.News_Paper), URL_ACTIVITY, "https://github.com/damahecode/DCode-News"),
        FeaturedList(context.getString(R.string.chat_app), ImageVectorIcon(MyIcons.Send), URL_ACTIVITY, "https://github.com/damahecode/Chat-App"),
        FeaturedList(context.getString(R.string.weather), DCodeIcon.DrawableResourceIcon(MyIcons.Solar_Power), URL_ACTIVITY, "https://github.com/damahecode/Weather"),
    )
}