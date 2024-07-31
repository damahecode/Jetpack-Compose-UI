package com.code.damahe.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.code.damahe.material.app.DCodeActivity
import com.code.damahe.material.app.MainContent
import com.code.damahe.ui.screen.PreviewScreen

class PreviewActivity: DCodeActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Turn off the decor fitting system windows, which allows us to handle insets,
        // including IME animations
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val intent = intent
        val route = intent.getStringExtra("route")

        setContent {
            MainContent(themeUiState = themeUiState) {
                PreviewScreen(route) { finish() }
            }
        }
    }
}