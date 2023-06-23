package com.code.damahe.feature.model

import androidx.annotation.StringRes
import com.code.damahe.res.icon.DCodeIcon

data class FeatureList(
    @StringRes val name: Int,
    val listIcon: DCodeIcon
)
