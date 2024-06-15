package com.code.damahe.featured.model

import androidx.compose.runtime.Composable

data class ComposeSample(val name: String, val content: @Composable () -> Unit)
