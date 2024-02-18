package com.code.damahe.feature.screen

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.unit.dp
import com.code.damahe.feature.model.MaterialDemo
import com.code.damahe.feature.model.MaterialList
import com.code.damahe.res.R
import com.code.damahe.res.config.AppActivity
import com.code.damahe.res.config.MainActivityNavigation
import com.code.damahe.res.icon.MyIcons
import com.code.damahe.res.icon.DCodeIcon.ImageVectorIcon

@OptIn(
    ExperimentalComposeUiApi::class,
    ExperimentalMaterial3Api::class,
)
@Composable
fun HomeScreen(
    navigateToDestination: (String) -> Unit,
    startAppActivity: (Context, String) -> Unit
) {
    val context = LocalContext.current

    val materialDemos = listOf(
        MaterialDemo(
            context.getString(R.string.txt_badge),
            MainActivityNavigation.badgeScreenNavRoute
        ),
        MaterialDemo(
            context.getString(R.string.txt_bottom_app_bar),
            MainActivityNavigation.simpleBottomAppBarNavRoute,
            listOf(
                MaterialList(
                    "SimpleBottomAppBar",
                    MainActivityNavigation.simpleBottomAppBarNavRoute
                ),
                MaterialList(
                    "BottomAppBarWithFab",
                    MainActivityNavigation.bottomAppBarWithFabNavRoute
                ),
                MaterialList(
                    "ExitAlwaysBottomAppBar",
                    MainActivityNavigation.exitAlwaysBottomAppBarNavRoute
                ),
            ),
        ),
        MaterialDemo(
            context.getString(R.string.txt_bottom_sheet),
            MainActivityNavigation.modalBottomSheetNavRoute,
            listOf(
                MaterialList(
                    "ModalBottomSheetSample",
                    MainActivityNavigation.modalBottomSheetNavRoute
                ),
                MaterialList(
                    "SimpleBottomSheetScaffoldSample",
                    MainActivityNavigation.simpleBottomSheetScaffoldNavRoute
                ),
                MaterialList(
                    "BottomSheetScaffoldNestedScrollSample",
                    MainActivityNavigation.bottomSheetScaffoldNestedScrollNavRoute
                ),
            ),
        ),
    )

    val clickRemember = remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.semantics {
            testTagsAsResourceId = true
        },
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
        contentWindowInsets = WindowInsets.safeContent,
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) },
                navigationIcon = {
                    IconButton(onClick = { startAppActivity(context, AppActivity.PREFERENCE_ACTIVITY) }
                    ) {
                        Icon(ImageVectorIcon(MyIcons.Settings).imageVector, contentDescription = stringResource(id = R.string.txt_preferences))
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                ),
            )
        },
    ) { padding ->
        Column(modifier = Modifier
            .padding(padding)
            .verticalScroll(rememberScrollState())) {

            materialDemos.forEach {
                OutlinedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clickable {
                            if (it.list.isEmpty()) {
                                navigateToDestination(it.navRoute)
                            } else {
                                clickRemember.value = it.name
                            }
                        },
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text(
                        modifier = Modifier.padding(10.dp),
                        style = MaterialTheme.typography.titleLarge,
                        text = it.name
                    )
                }
                if (clickRemember.value == it.name) {
                    it.list.forEach { list ->
                        Card(
                            modifier = Modifier.fillMaxWidth().padding(start = 25.dp, end = 15.dp, top = 10.dp)
                                .clickable {
                                    navigateToDestination(list.navRoute)
                                },
                            shape = RoundedCornerShape(8.dp),
                        ) {
                            Text(
                                modifier = Modifier.padding(10.dp),
                                style = MaterialTheme.typography.titleLarge,
                                text = list.name
                            )
                        }
                    }
                }
            }
        }
    }
}

