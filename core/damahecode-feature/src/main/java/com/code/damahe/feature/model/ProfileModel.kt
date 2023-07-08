package com.code.damahe.feature.model

import com.code.damahe.res.icon.DCodeIcon

data class ProfilePopularList(
    val name: String,
    val description: String,
    val star: String,
    val language: String
)

data class ImageTextList(
    val icon: DCodeIcon,
    val text: String
)
