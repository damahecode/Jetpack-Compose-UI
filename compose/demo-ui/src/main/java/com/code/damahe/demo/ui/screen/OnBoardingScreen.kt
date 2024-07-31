package com.code.damahe.demo.ui.screen

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.code.damahe.res.icon.LottieLoadingView
import kotlinx.coroutines.launch

data class Onboard(val title: String, val description: String, val lottieFile: String)

val onboardingList = listOf(
    Onboard(
        "Team Collaborations",
        "Our tools help your teams collaborate for the best output results",
        "profile.json"
    ),
    Onboard(
        "Improve Productivity",
        "Our tools are designed to improve productivity by automating all the stuff for you",
        "working.json"
    ),
    Onboard(
        "Growth Tracking",
        "We provide dashboard and charts to track your growth easily and suggestions.",
        "food.json"
    )
)

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(onBack: () -> Unit) {
    val composableScope = rememberCoroutineScope()
    val pagerState: PagerState = run {
        rememberPagerState(0, 0f) {
            onboardingList.size
        }
    }

    Scaffold(containerColor = Color.Transparent) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) {
                OnboardingPagerItem(onboardingList[it])
            }
            Text(
                text = "Skip",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(vertical = 48.dp, horizontal = 16.dp)
                    .clickable(onClick = onBack)
            )
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 120.dp)
            ) {
                onboardingList.forEachIndexed { index, _ ->
                    OnboardingPagerSlide(
                        selected = index == pagerState.currentPage,
                        MaterialTheme.colorScheme.primary,
                        Icons.Filled.AddCircle
                    )
                }
            }
            Button(
                onClick = {
                    composableScope.launch {
                        if (pagerState.currentPage != onboardingList.size)
                            pagerState.scrollToPage(pagerState.currentPage + 1)
                    }
                },
                modifier = Modifier
                    .animateContentSize()
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 32.dp)
                    .height(50.dp)
                    .clip(CircleShape)
            ) {
                Text(
                    text = if (pagerState.currentPage == onboardingList.size - 1) "Let's Begin" else "Next",
                    modifier = Modifier.padding(horizontal = 32.dp),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}

@Composable
fun OnboardingPagerSlide(selected: Boolean, color: Color, icon: ImageVector) {
    Icon(
        imageVector = icon,
        modifier = Modifier.padding(4.dp),
        contentDescription = null,
        tint = if (selected) color else Color.Gray
    )
}

@Composable
fun OnboardingPagerItem(item: Onboard) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieLoadingView(
            file = item.lottieFile,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )
        Text(
            text = item.title,
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.ExtraBold),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = item.description,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}