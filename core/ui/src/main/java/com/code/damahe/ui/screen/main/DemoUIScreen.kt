package com.code.damahe.ui.screen.main

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.code.damahe.demo.ui.model.FeaturedList
import com.code.damahe.ui.utils.DemoDataProvider
import com.code.damahe.res.icon.DrawIcon
import com.code.damahe.res.icon.MyIcons

@Composable
fun DemoUIScreen(onClick: (FeaturedList, Context) -> Unit) {
    val context = LocalContext.current

    FeaturedListContent(
        onClick = onClick,
        list = DemoDataProvider.demoUIListItems(context)
    )
}

@Composable
fun FeaturedListContent(
    modifier: Modifier = Modifier,
    onClick: (FeaturedList, Context) -> Unit,
    list: List<FeaturedList>,
) {

    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn {
            items(
                items = list,
                itemContent = {
                    FeaturedListView(it, onClick)
                }
            )
        }
    }
}

@Composable
fun FeaturedListView(
    featuredList: FeaturedList,
    onClick: (FeaturedList, Context) -> Unit,
) {
    val context = LocalContext.current

    Column(modifier = Modifier.padding(vertical = 8.dp, horizontal = 15.dp)) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8),
            onClick = { onClick(featuredList, context) },
        ) {
            Row(
                modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                DrawIcon(icon = featuredList.listIcon,
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(6.dp))
                Column(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f)
                ) {
                    Text(
                        text = featuredList.name,
                        style = MaterialTheme.typography.labelLarge,
                    )
                }
                Icon(
                    imageVector = MyIcons.KeyboardArrowRight,
                    contentDescription = null,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }
}