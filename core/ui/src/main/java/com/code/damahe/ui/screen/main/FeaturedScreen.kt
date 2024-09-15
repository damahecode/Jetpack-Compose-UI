package com.code.damahe.ui.screen.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.code.damahe.res.R
import com.code.damahe.res.icon.MyIcons
import com.code.damahe.res.navigation.NavigationRoute
import com.code.damahe.ui.model.MaterialDemo
import com.code.damahe.ui.model.MaterialList

@Composable
fun FeaturedScreen(
    navigateToDestination: (String) -> Unit,
) {
    val context = LocalContext.current

    val materialDemos = listOf(
        MaterialDemo(
            context.getString(R.string.badge),
            NavigationRoute.badgeScreenNavRoute
        ),
        MaterialDemo(
            context.getString(R.string.bottom_app_bar),
            NavigationRoute.simpleBottomAppBarNavRoute,
            listOf(
                MaterialList(
                    "SimpleBottomAppBar",
                    NavigationRoute.simpleBottomAppBarNavRoute
                ),
                MaterialList(
                    "BottomAppBarWithFab",
                    NavigationRoute.bottomAppBarWithFabNavRoute
                ),
                MaterialList(
                    "ExitAlwaysBottomAppBar",
                    NavigationRoute.exitAlwaysBottomAppBarNavRoute
                ),
            ),
        ),
        MaterialDemo(
            context.getString(R.string.bottom_sheet),
            NavigationRoute.modalBottomSheetNavRoute,
            listOf(
                MaterialList(
                    "ModalBottomSheetSample",
                    NavigationRoute.modalBottomSheetNavRoute
                ),
                MaterialList(
                    "SimpleBottomSheetScaffoldSample",
                    NavigationRoute.simpleBottomSheetScaffoldNavRoute
                ),
                MaterialList(
                    "BottomSheetScaffoldNestedScrollSample",
                    NavigationRoute.bottomSheetScaffoldNestedScrollNavRoute
                ),
            ),
        ),
        MaterialDemo(
            context.getString(R.string.buttons),
            NavigationRoute.buttonSamples
        ),
        MaterialDemo(
            context.getString(R.string.card),
            NavigationRoute.cardSamples
        ),
        MaterialDemo(
            context.getString(R.string.check_boxes),
            NavigationRoute.checkBoxes
        ),
        MaterialDemo(
            context.getString(R.string.chips),
            NavigationRoute.chipSamples
        ),
        MaterialDemo(
            context.getString(R.string.date_pickers),
            NavigationRoute.datePickerSamples
        ),
        MaterialDemo(
            context.getString(R.string.floating_action_buttons),
            NavigationRoute.floatingActionButtonSamples,
            listOf(
                MaterialList(
                    "Simple FAB Sample",
                    NavigationRoute.floatingActionButtonSamples
                ),
                MaterialList(
                    "Animated FAB Sample",
                    NavigationRoute.animatedExtendedFloatingActionButtonSample
                ),
            ),
        ),
        MaterialDemo(
            context.getString(R.string.icon_buttons),
            NavigationRoute.iconButtonSamples
        ),
        MaterialDemo(
            context.getString(R.string.lists),
            NavigationRoute.listSamples
        ),
        MaterialDemo(
            context.getString(R.string.menus),
            NavigationRoute.menuSamples
        ),
        MaterialDemo(
            context.getString(R.string.navigation_bar),
            NavigationRoute.navigationBarSamples
        ),
        MaterialDemo(
            context.getString(R.string.navigation_rail),
            NavigationRoute.navigationRailSamples
        ),
        MaterialDemo(
            context.getString(R.string.radio_buttons),
            NavigationRoute.radioButtonSamples
        ),
        MaterialDemo(
            context.getString(R.string.segmented__button),
            NavigationRoute.segmentedButtonSamples
        ),
        MaterialDemo(
            context.getString(R.string.switches),
            NavigationRoute.switchSamples
        ),
        MaterialDemo(
            context.getString(R.string.tabs),
            NavigationRoute.tabSamples
        ),
        MaterialDemo(
            context.getString(R.string.text_fields),
            NavigationRoute.textFieldSamples
        ),
        MaterialDemo(
            context.getString(R.string.search_bars),
            NavigationRoute.searchBarSample,
            listOf(
                MaterialList(
                    "SearchBar",
                    NavigationRoute.searchBarSample
                ),
                MaterialList(
                    "DockedSearchBar",
                    NavigationRoute.dockedSearchBarSample
                ),
            ),
        ),
    )

    val clickRemember = remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()
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