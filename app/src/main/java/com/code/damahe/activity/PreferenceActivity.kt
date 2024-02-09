package com.code.damahe.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.code.damahe.app.Activity
import com.code.damahe.app.MainContent
import com.code.damahe.screen.NavPreferenceScreen

class PreferenceActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Turn off the decor fitting system windows, which allows us to handle insets,
        // including IME animations
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            MainContent(themeUiState = themeUiState) {
                NavPreferenceScreen(onFinish = { finish() })
            }
        }
    }

}