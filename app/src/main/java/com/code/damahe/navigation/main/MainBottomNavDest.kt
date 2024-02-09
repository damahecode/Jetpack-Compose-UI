package com.code.damahe.navigation.main

import com.code.damahe.res.R
import com.code.damahe.res.icon.MyIcons
import com.code.damahe.res.icon.DCodeIcon
import com.code.damahe.res.icon.DCodeIcon.ImageVectorIcon
import com.code.damahe.res.icon.DCodeIcon.DrawableResourceIcon

enum class MainBottomNavDest(
    val selectedIcon: DCodeIcon,
    val iconTextId: Int,
) {
    HOME(
        selectedIcon = ImageVectorIcon(MyIcons.Home),
        iconTextId = R.string.txt_home,
    ),
    DEMO_UI(
        selectedIcon =  DrawableResourceIcon(MyIcons.Android_Head),
        iconTextId = R.string.txt_demo_ui,
    ),
    TEMPLATE(
        selectedIcon = ImageVectorIcon(MyIcons.List),
        iconTextId = R.string.txt_template,
    ),
}