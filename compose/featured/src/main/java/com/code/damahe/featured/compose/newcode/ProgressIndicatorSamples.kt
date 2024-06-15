package com.code.damahe.featured.compose.newcode
//
//import androidx.compose.animation.core.animateFloatAsState
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.requiredHeight
//import androidx.compose.material3.CircularProgressIndicator
//import androidx.compose.material3.LinearProgressIndicator
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.ProgressIndicatorDefaults
//import androidx.compose.material3.Slider
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableFloatStateOf
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.StrokeCap
//import androidx.compose.ui.semantics.semantics
//import androidx.compose.ui.semantics.stateDescription
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun LinearProgressIndicatorSample() {
//    var progress by remember { mutableFloatStateOf(0.1f) }
//    val animatedProgress by animateFloatAsState(
//        targetValue = progress,
//        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec, label = ""
//    )
//
//    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//        LinearProgressIndicator(
//            progress = { animatedProgress },
//        )
//        Spacer(Modifier.requiredHeight(30.dp))
//        Slider(
//            modifier = Modifier
//                .padding(start = 24.dp, end = 24.dp)
//                .semantics {
//                    val progressPercent = (progress * 100).toInt()
//                    if (progressPercent in progressBreakpoints) {
//                        stateDescription = "Progress $progressPercent%"
//                    }
//                },
//            value = progress,
//            valueRange = 0f..1f,
//            steps = 100,
//            onValueChange = {
//                progress = it
//            })
//    }
//}
//
//@Composable
//fun LegacyLinearProgressIndicatorSample() {
//    var progress by remember { mutableFloatStateOf(0.1f) }
//    val animatedProgress by animateFloatAsState(
//        targetValue = progress,
//        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec, label = ""
//    )
//
//    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//        LinearProgressIndicator(
//            progress = { animatedProgress },
//            trackColor = MaterialTheme.colorScheme.surfaceVariant,
//            strokeCap = StrokeCap.Butt,
//            gapSize = 0.dp,
//            drawStopIndicator = null
//        )
//        Spacer(Modifier.requiredHeight(30.dp))
//        Slider(
//            modifier = Modifier
//                .padding(start = 24.dp, end = 24.dp)
//                .semantics {
//                    val progressPercent = (progress * 100).toInt()
//                    if (progressPercent in progressBreakpoints) {
//                        stateDescription = "Progress $progressPercent%"
//                    }
//                },
//            value = progress,
//            valueRange = 0f..1f,
//            steps = 100,
//            onValueChange = {
//                progress = it
//            })
//    }
//}
//
//@Composable
//fun IndeterminateLinearProgressIndicatorSample() {
//    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//        LinearProgressIndicator()
//    }
//}
//
//@Composable
//fun LegacyIndeterminateLinearProgressIndicatorSample() {
//    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//        LinearProgressIndicator(
//            trackColor = MaterialTheme.colorScheme.surfaceVariant,
//            strokeCap = StrokeCap.Butt,
//            gapSize = 0.dp
//        )
//    }
//}
//
//@Composable
//fun CircularProgressIndicatorSample() {
//    var progress by remember { mutableFloatStateOf(0.1f) }
//    val animatedProgress by animateFloatAsState(
//        targetValue = progress,
//        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec, label = ""
//    )
//
//    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//        CircularProgressIndicator(progress = { animatedProgress })
//        Spacer(Modifier.requiredHeight(30.dp))
//        Slider(
//            modifier = Modifier
//                .padding(start = 24.dp, end = 24.dp)
//                .semantics {
//                    val progressPercent = (progress * 100).toInt()
//                    if (progressPercent in progressBreakpoints) {
//                        stateDescription = "Progress $progressPercent%"
//                    }
//                },
//            value = progress,
//            valueRange = 0f..1f,
//            steps = 100,
//            onValueChange = {
//                progress = it
//            })
//    }
//}
//
//@Composable
//fun LegacyCircularProgressIndicatorSample() {
//    var progress by remember { mutableFloatStateOf(0.1f) }
//    val animatedProgress by animateFloatAsState(
//        targetValue = progress,
//        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec, label = ""
//    )
//
//    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//        CircularProgressIndicator(
//            progress = { animatedProgress },
//            trackColor = Color.Transparent,
//            strokeCap = StrokeCap.Butt,
//            gapSize = 0.dp
//        )
//        Spacer(Modifier.requiredHeight(30.dp))
//        Slider(
//            modifier = Modifier
//                .padding(start = 24.dp, end = 24.dp)
//                .semantics {
//                    val progressPercent = (progress * 100).toInt()
//                    if (progressPercent in progressBreakpoints) {
//                        stateDescription = "Progress $progressPercent%"
//                    }
//                },
//            value = progress,
//            valueRange = 0f..1f,
//            steps = 100,
//            onValueChange = {
//                progress = it
//            })
//    }
//}
//
//@Composable
//fun IndeterminateCircularProgressIndicatorSample() {
//    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//        CircularProgressIndicator()
//    }
//}
//
//
//@Composable
//fun LegacyIndeterminateCircularProgressIndicatorSample() {
//    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//        CircularProgressIndicator(
//            strokeCap = StrokeCap.Butt
//        )
//    }
//}
//
//private val progressBreakpoints = listOf(20, 40, 60, 80, 100)