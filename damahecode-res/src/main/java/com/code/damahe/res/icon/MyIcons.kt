package com.code.damahe.res.icon

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.code.damahe.res.R

/**
 * Damahe Code icons. Material icons are [ImageVector]s, custom icons are drawable resource IDs.
 */
object MyIcons {
    val Settings = Icons.Rounded.Settings
    val Home = Icons.Default.Home
    val List = Icons.Rounded.List
    val Info = Icons.Rounded.Info
    val AccountBox = Icons.Default.AccountBox

    val Palette = R.drawable.ic_palette_24dp
    val History = R.drawable.ic_round_history_24dp
    val Android_Head = R.drawable.ic_android_head_24dp
}

/**
 * A sealed class to make dealing with [ImageVector] and [DrawableRes] icons easier.
 */
sealed class DCodeIcon {
    data class ImageVectorIcon(val imageVector: ImageVector) : DCodeIcon()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : DCodeIcon()
}