package com.code.damahe.ui.screen.main

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.code.damahe.demo.ui.model.FeaturedList
import com.code.damahe.ui.utils.DemoDataProvider

@Composable
fun TemplateScreen(onClick: (FeaturedList, Context) -> Unit) {
    val context = LocalContext.current

    FeaturedListContent(
        onClick = onClick,
        list = DemoDataProvider.templateListItems(context)
    )
}