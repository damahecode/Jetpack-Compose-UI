package com.code.damahe.ui.utils

import android.content.Context
import com.code.damahe.demo.ui.model.FeaturedList
import com.code.damahe.res.R
import com.code.damahe.res.icon.DCodeIcon
import com.code.damahe.res.icon.DCodeIcon.ImageVectorIcon
import com.code.damahe.res.icon.MyIcons

object DemoDataProvider {

    fun demoUIListItems(context: Context) = listOf(
        FeaturedList(context.getString(R.string.profile), ImageVectorIcon(MyIcons.Account), "https://github.com/damahecode/Jetpack-Compose-UI"),
        FeaturedList(context.getString(R.string.login_signup), ImageVectorIcon(MyIcons.Account), "https://github.com/damahecode/Jetpack-Compose-UI"),
    )

    fun templateListItems(context: Context) = listOf(
        FeaturedList(context.getString(R.string.responsive_screen), DCodeIcon.DrawableResourceIcon(MyIcons.CodeTag), "https://github.com/damahecode/Jetpack-Compose-UI"),
    )
}