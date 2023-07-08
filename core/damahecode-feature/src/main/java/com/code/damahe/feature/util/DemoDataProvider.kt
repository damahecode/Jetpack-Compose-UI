package com.code.damahe.feature.util

import android.content.Context
import com.code.damahe.feature.model.FeatureList
import com.code.damahe.res.R
import com.code.damahe.res.icon.DCodeIcon.ImageVectorIcon
import com.code.damahe.res.icon.DCodeIcon.DrawableResourceIcon
import com.code.damahe.res.icon.MyIcons

object DemoDataProvider {

    fun templateScreenListItems(context: Context) = listOf(
        FeatureList(context.getString(R.string.txt_preferences), ImageVectorIcon(MyIcons.Settings), "https://github.com/damahecode/Damahe-Code-Compose-UI"),
        FeatureList(context.getString(R.string.txt_profile), ImageVectorIcon(MyIcons.AccountBox), "https://github.com/damahecode/Damahe-Code-Compose-UI"),
    )

    fun demoUIScreenListItems(context: Context) = listOf(
        FeatureList(context.getString(R.string.txt_day_night_theme), DrawableResourceIcon(MyIcons.Palette), "https://github.com/damahecode/DayNight-Theme"),
    )
}