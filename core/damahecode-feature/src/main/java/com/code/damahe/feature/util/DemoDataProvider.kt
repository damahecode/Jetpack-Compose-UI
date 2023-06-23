package com.code.damahe.feature.util

import com.code.damahe.feature.model.FeatureList
import com.code.damahe.res.R
import com.code.damahe.res.icon.DCodeIcon
import com.code.damahe.res.icon.MyIcons

object DemoDataProvider {

    val homeScreenListItems = listOf(
        FeatureList(R.string.txt_preferences, DCodeIcon.ImageVectorIcon(MyIcons.Settings)),
        FeatureList(R.string.txt_profile, DCodeIcon.ImageVectorIcon(MyIcons.AccountBox))
    )
}