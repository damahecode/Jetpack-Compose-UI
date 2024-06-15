package com.code.damahe.responsive.screen.model

import com.code.damahe.res.icon.DCodeIcon

data class TopLevelDestination(
    val route: String,
    val selectedIcon: DCodeIcon,
    val unselectedIcon: DCodeIcon,
    val iconTextId: Int
)
