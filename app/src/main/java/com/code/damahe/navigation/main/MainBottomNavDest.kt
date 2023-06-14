package com.code.damahe.navigation.main

import com.code.damahe.res.R
import com.code.damahe.res.icon.MyIcons
import com.code.damahe.res.icon.DCodeIcon
import com.code.damahe.res.icon.DCodeIcon.ImageVectorIcon

enum class MainBottomNavDest(
    val selectedIcon: DCodeIcon,
    val iconTextId: Int,
) {
    HOME(
        selectedIcon = ImageVectorIcon(MyIcons.Home),
        iconTextId = R.string.txt_home,
    ),
    WIDGETS(
        selectedIcon = ImageVectorIcon(MyIcons.Build),
        iconTextId = R.string.txt_widgets,
    ),
    ANIMATION(
        selectedIcon = ImageVectorIcon(MyIcons.PlayArrow),
        iconTextId = R.string.txt_anim,
    ),
    DEMO_UI(
        selectedIcon =  ImageVectorIcon(MyIcons.AccountBox),
        iconTextId = R.string.txt_demo_ui,
    ),
    TEMPLATE(
        selectedIcon = ImageVectorIcon(MyIcons.List),
        iconTextId = R.string.txt_template,
    ),
}