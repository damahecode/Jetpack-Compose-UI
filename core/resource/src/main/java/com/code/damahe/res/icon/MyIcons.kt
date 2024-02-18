package com.code.damahe.res.icon

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.rounded.List
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.code.damahe.res.icon.DCodeIcon.ImageVectorIcon
import com.code.damahe.res.icon.DCodeIcon.DrawableResourceIcon
import com.code.damahe.res.R

/**
 * Damahe Code icons. Material icons are [ImageVector]s, custom icons are drawable resource IDs.
 */
object MyIcons {
    val Settings = Icons.Rounded.Settings
    val Home = Icons.Default.Home
    val List = Icons.AutoMirrored.Rounded.List
    val Info = Icons.Rounded.Info
    val AccountBox = Icons.Default.AccountBox
    val Location = Icons.Rounded.LocationOn
    val ArrowBack = Icons.AutoMirrored.Filled.ArrowBack
    val Search = Icons.Filled.Search
    val MoreVert = Icons.Filled.MoreVert
    val Star = Icons.Filled.Star
    val Email = Icons.Filled.Email
    val Share = Icons.Filled.Share
    val Edit = Icons.Filled.Edit
    val KeyboardArrowRight = Icons.AutoMirrored.Filled.KeyboardArrowRight

    val Palette = R.drawable.ic_palette_24dp
    val History = R.drawable.ic_round_history_24dp
    val Android_Head = R.drawable.ic_android_head_24dp
    val AppIcon = R.drawable.ic_launcher_background
    val Policy = R.drawable.ic_policy_24dp
}

/**
 * A sealed class to make dealing with [ImageVector] and [DrawableRes] icons easier.
 */
sealed class DCodeIcon {
    data class ImageVectorIcon(val imageVector: ImageVector) : DCodeIcon()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : DCodeIcon()
}

/**
 * A Material Design icon component that draws [DCodeIcon] using [tint], with a default value of [LocalContentColor].
 */
@Composable
fun DrawIcon(
    icon: DCodeIcon,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current
) {
    when (icon) {
        is ImageVectorIcon -> Icon(
            imageVector = icon.imageVector,
            contentDescription = contentDescription,
            modifier = modifier,
            tint = tint
        )

        is DrawableResourceIcon -> Icon(
            painter = painterResource(id = icon.id),
            contentDescription = contentDescription,
            modifier = modifier,
            tint = tint
        )
    }
}