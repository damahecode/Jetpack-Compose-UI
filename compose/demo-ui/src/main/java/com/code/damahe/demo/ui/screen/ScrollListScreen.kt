package com.code.damahe.demo.ui.screen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.code.damahe.res.icon.MyIcons

@Composable
fun ScrollListScreen() {

    val scrollState = rememberScrollState(0)

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        BoxTopSection(scrollState = scrollState)
        TopSectionOverlay(scrollState = scrollState)
        BottomScrollableContent(scrollState = scrollState)
        AnimatedToolBar(scrollState = scrollState)
    }
}

@Composable
fun AnimatedToolBar(scrollState: ScrollState) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(
                if (Dp(scrollState.value.toFloat()) < 800.dp)
                    Color.Transparent else MaterialTheme.colorScheme.surfaceVariant
            )
            .padding(horizontal = 8.dp, vertical = 12.dp)
    ) {
        Icon(
            imageVector = MyIcons.ArrowBack,
            contentDescription = null
        )
        Text(
            text = "album.song",
            modifier = Modifier
                .alpha(((scrollState.value + 0.001f) / 700).coerceIn(0f, 1f)),
            fontWeight = FontWeight.Bold
        )
        Icon(
            imageVector = MyIcons.MoreVert,
            contentDescription = null
        )
    }
}

@Composable
fun BottomScrollableContent(scrollState: ScrollState) {
    Column(modifier = Modifier.verticalScroll(state = scrollState)) {
        Spacer(modifier = Modifier.height(480.dp))
        Column(modifier = Modifier
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .navigationBarsPadding()
        ) {
            val list = listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)
//            list.forEach {
//                val music = if (it%2==0)
//                    Music("Music $it", "/storage/emulated/0/music-$it", "$it:20", MyIcons.Palette)
//                else
//                    Music("Music $it", "/storage/emulated/0/music-$it", "$it:20", MyIcons.Policy)
//                SongItemSection(music)
//            }
        }
    }
}

@Composable
fun TopSectionOverlay(scrollState: ScrollState) {
    //slowly increase alpha till it reaches 1
    val dynamicAlpha = ((scrollState.value + 0.00f) / 1000).coerceIn(0f, 1f)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .background(
                MaterialTheme.colorScheme.surface.copy(
                    alpha = animateFloatAsState(dynamicAlpha, label = "").value
                )
            )
    )
}

@Composable
fun BoxTopSection(scrollState: ScrollState) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
        )
        //animate as scroll value increase but not fast so divide by random number 50
        val dynamicValue =
            if (250.dp - Dp(scrollState.value / 50f) < 10.dp) 10.dp //prevent going 0 cause crash
            else 250.dp - Dp(scrollState.value / 20f)
        val animateImageSize = animateDpAsState(dynamicValue, label = "").value
        Image(
            painter = painterResource(id = MyIcons.Android_Head),
            contentDescription = null,
            modifier = Modifier
                .size(animateImageSize)
                .padding(8.dp)
        )
        Text(
            text = "album.song",
            style = typography.headlineMedium.copy(fontWeight = FontWeight.ExtraBold),
            modifier = Modifier.padding(8.dp),
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = "FOLLOWING",
            color = MaterialTheme.colorScheme.onSurface,
            style = typography.headlineSmall.copy(fontSize = 12.sp),
            modifier = Modifier
                .padding(4.dp)
                .border(
                    border = BorderStroke(2.dp, MaterialTheme.colorScheme.primaryContainer),
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(vertical = 4.dp, horizontal = 24.dp)
        )
        Text(
            text = "album.descriptions",
            style = typography.labelMedium,
            modifier = Modifier.padding(4.dp)
        )
    }
}

//@Composable
//fun SongItemSection(music: Music) {
//
//    Row(
//        modifier = Modifier.padding(8.dp),
//        verticalAlignment = Alignment.CenterVertically,
//    ) {
//        Image(
//            painter = painterResource(id = music.imageUri),
//            contentDescription = null,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .size(55.dp)
//                .padding(4.dp)
//        )
//        Column(
//            modifier = Modifier
//                .padding(horizontal = 4.dp)
//                .weight(1f)
//        ) {
//            Text(
//                text = music.name,
//                style = typography.headlineSmall.copy(fontSize = 16.sp),
//                fontWeight = FontWeight.Bold,
//                color = MaterialTheme.colorScheme.onSurface
//            )
//            Text(
//                text = music.path,
//                style = typography.labelMedium,
//                fontWeight = FontWeight.Light,
//                maxLines = 1,
//                overflow = TextOverflow.Ellipsis
//            )
//        }
//        Icon(
//            imageVector = MyIcons.MoreVert,
//            contentDescription = null,
//            modifier = Modifier.padding(4.dp)
//        )
//    }
//}
