package com.code.damahe.feature.util

import com.code.damahe.feature.model.FeatureList
import com.code.damahe.res.R
import com.code.damahe.res.icon.DCodeIcon
import com.code.damahe.res.icon.MyIcons

object DemoDataProvider {

    val templateScreenListItems = listOf(
        FeatureList(R.string.txt_preferences, DCodeIcon.ImageVectorIcon(MyIcons.Settings), "https://github.com/damahecode/Damahe-Code-Compose-UI"),
        FeatureList(R.string.txt_profile, DCodeIcon.ImageVectorIcon(MyIcons.AccountBox), "https://github.com/damahecode/Damahe-Code-Compose-UI")
    )

    val demoUIScreenListItems = listOf(
        FeatureList(R.string.txt_day_night_theme, DCodeIcon.DrawableResourceIcon(MyIcons.Palette), "https://github.com/damahecode/DayNight-Theme"),
    )
}