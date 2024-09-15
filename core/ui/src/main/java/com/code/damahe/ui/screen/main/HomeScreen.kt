package com.code.damahe.ui.screen.main

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.window.layout.DisplayFeature
import com.code.damahe.res.R
import com.code.damahe.res.icon.LottieLoadingView
import com.code.damahe.ui.screen.EmptyScreen
import com.code.damahe.ui.utils.DCodeContentType
import com.google.accompanist.adaptive.HorizontalTwoPaneStrategy
import com.google.accompanist.adaptive.TwoPane

@Composable
fun HomeScreen(
    contentType: DCodeContentType,
    displayFeatures: List<DisplayFeature>,
) {

    if (contentType == DCodeContentType.DUAL_PANE) {
        TwoPane(
            first = {
                HomeScreenContent()
            },
            second = {
                EmptyScreen()
            },
            strategy = HorizontalTwoPaneStrategy(splitFraction = 0.5f, gapWidth = 16.dp),
            displayFeatures = displayFeatures
        )
    } else {
        HomeScreenContent()
    }
}

@Composable
fun HomeScreenContent() {
    val context = LocalContext.current

    Box(
        Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LottieLoadingView(
                file = "working.json",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Home page is under development")
            // on below line adding a spacer.
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                val urlIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/damahecode/Jetpack-Compose-UI")
                )
                context.startActivity(urlIntent)
            }) {
                Text(
                    text = stringResource(id = R.string.txt_github),
                    modifier = Modifier.padding(10.dp),
                    fontSize = 15.sp
                )
            }
        }
    }
}