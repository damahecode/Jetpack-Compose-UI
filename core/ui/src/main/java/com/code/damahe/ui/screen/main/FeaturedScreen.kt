package com.code.damahe.ui.screen.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.unit.dp
import com.code.damahe.res.R
import com.code.damahe.res.icon.MyIcons
import com.code.damahe.res.icon.DCodeIcon.ImageVectorIcon
import com.code.damahe.res.icon.DrawIcon
import com.code.damahe.res.navigation.MainActivityNavigation
import com.code.damahe.ui.model.MaterialDemo
import com.code.damahe.ui.model.MaterialList

@OptIn(
    ExperimentalComposeUiApi::class,
    ExperimentalMaterial3Api::class,
)
@Composable
fun FeaturedScreen(
    navigateToDestination: (String) -> Unit,
    onDrawerClicked: () -> Unit = {}
) {
    val context = LocalContext.current

    val materialDemos = listOf(
        MaterialDemo(
            context.getString(R.string.badge),
            MainActivityNavigation.badgeScreenNavRoute
        ),
        MaterialDemo(
            context.getString(R.string.bottom_app_bar),
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
            context.getString(R.string.bottom_sheet),
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
        MaterialDemo(
            context.getString(R.string.buttons),
            MainActivityNavigation.buttonSamples
        ),
        MaterialDemo(
            context.getString(R.string.card),
            MainActivityNavigation.cardSamples
        ),
        MaterialDemo(
            context.getString(R.string.check_boxes),
            MainActivityNavigation.checkBoxes
        ),
        MaterialDemo(
            context.getString(R.string.chips),
            MainActivityNavigation.chipSamples
        ),
        MaterialDemo(
            context.getString(R.string.date_pickers),
            MainActivityNavigation.datePickerSamples
        ),
        MaterialDemo(
            context.getString(R.string.floating_action_buttons),
            MainActivityNavigation.floatingActionButtonSamples,
            listOf(
                MaterialList(
                    "Simple FAB Sample",
                    MainActivityNavigation.floatingActionButtonSamples
                ),
                MaterialList(
                    "Animated FAB Sample",
                    MainActivityNavigation.animatedExtendedFloatingActionButtonSample
                ),
            ),
        ),
        MaterialDemo(
            context.getString(R.string.icon_buttons),
            MainActivityNavigation.iconButtonSamples
        ),
        MaterialDemo(
            context.getString(R.string.lists),
            MainActivityNavigation.listSamples
        ),
        MaterialDemo(
            context.getString(R.string.menus),
            MainActivityNavigation.menuSamples
        ),
        MaterialDemo(
            context.getString(R.string.navigation_bar),
            MainActivityNavigation.navigationBarSamples
        ),
        MaterialDemo(
            context.getString(R.string.navigation_rail),
            MainActivityNavigation.navigationRailSamples
        ),
        MaterialDemo(
            context.getString(R.string.radio_buttons),
            MainActivityNavigation.radioButtonSamples
        ),
        MaterialDemo(
            context.getString(R.string.segmented__button),
            MainActivityNavigation.segmentedButtonSamples
        ),
        MaterialDemo(
            context.getString(R.string.switches),
            MainActivityNavigation.switchSamples
        ),
        MaterialDemo(
            context.getString(R.string.tabs),
            MainActivityNavigation.tabSamples
        ),
        MaterialDemo(
            context.getString(R.string.text_fields),
            MainActivityNavigation.textFieldSamples
        ),
        MaterialDemo(
            context.getString(R.string.search_bars),
            MainActivityNavigation.searchBarSample,
            listOf(
                MaterialList(
                    "SearchBar",
                    MainActivityNavigation.searchBarSample
                ),
                MaterialList(
                    "DockedSearchBar",
                    MainActivityNavigation.dockedSearchBarSample
                ),
            ),
        ),
    )

    val clickRemember = remember { mutableStateOf("") }

    Scaffold(
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
        contentWindowInsets = WindowInsets(0),
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.featured)) },
                navigationIcon = {
                    IconButton(onClick = { onDrawerClicked() }
                    ) {
                        DrawIcon(ImageVectorIcon(MyIcons.Menu), contentDescription = stringResource(id = R.string.navigation_drawer))
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                ),
            )
        },
    ) { padding ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(padding)
                .consumeWindowInsets(padding)
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(
                        WindowInsetsSides.Horizontal,
                    ),
                ),
        ) {
            Column(modifier = Modifier.fillMaxWidth()
                .padding(5.dp)
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
                        Row(
                            modifier = Modifier.padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                modifier = Modifier.weight(1f),
                                style = MaterialTheme.typography.titleLarge,
                                text = it.name
                            )
                            Icon(
                                imageVector = MyIcons.KeyboardArrowRight,
                                contentDescription = null,
                                modifier = Modifier.padding(4.dp)
                            )
                        }
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
}