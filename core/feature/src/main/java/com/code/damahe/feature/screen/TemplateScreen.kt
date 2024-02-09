package com.code.damahe.feature.screen

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.unit.dp
import com.code.damahe.feature.model.FeatureList
import com.code.damahe.feature.util.DemoDataProvider
import com.code.damahe.res.R
import com.code.damahe.res.icon.DCodeIcon
import com.code.damahe.res.icon.MyIcons

@OptIn(
    ExperimentalComposeUiApi::class,
    ExperimentalMaterial3Api::class,
)
@Composable
fun TemplateScreen(
    onClick: (FeatureList, Context) -> Unit,
) {

    val context = LocalContext.current

    Scaffold(
        modifier = Modifier.semantics {
            testTagsAsResourceId = true
        },
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.txt_template)) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Transparent,
                ),
            )
        },
    ) { padding ->
        FeatureListContent(
            Modifier.padding(padding),
            onClick,
            DemoDataProvider.templateScreenListItems(context)
        )
    }
}

@Composable
fun FeatureListContent(
    modifier: Modifier = Modifier,
    onClick: (FeatureList, Context) -> Unit,
    list: List<FeatureList>,
) {

    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn {
            items(
                items = list,
                itemContent = {
                    FeatureListView(it, onClick)
                }
            )
        }
    }
}

@Composable
fun FeatureListView(
    featureList: FeatureList,
    onClick: (FeatureList, Context) -> Unit,
) {
    val context = LocalContext.current

    Column(modifier = Modifier.padding(vertical = 8.dp, horizontal = 15.dp)) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8),
            onClick = { onClick(featureList, context) },
        ) {
            Row(
                modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                when (featureList.listIcon) {
                    is DCodeIcon.ImageVectorIcon -> Icon(
                        imageVector = featureList.listIcon.imageVector,
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(6.dp)
                    )

                    is DCodeIcon.DrawableResourceIcon -> Icon(
                        painter = painterResource(id = featureList.listIcon.id),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(6.dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f)
                ) {
                    Text(
                        text = featureList.name,
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
