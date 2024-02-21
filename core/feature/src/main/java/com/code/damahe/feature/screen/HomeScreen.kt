package com.code.damahe.feature.screen

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Alignment
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
        MaterialDemo(
            context.getString(R.string.txt_buttons),
            MainActivityNavigation.buttonSamples
        ),
        MaterialDemo(
            context.getString(R.string.txt_card),
            MainActivityNavigation.cardSamples
        ),
        MaterialDemo(
            context.getString(R.string.txt_check_boxes),
            MainActivityNavigation.checkBoxes
        ),
        MaterialDemo(
            context.getString(R.string.txt_chips),
            MainActivityNavigation.chipSamples
        ),
        MaterialDemo(
            context.getString(R.string.txt_Date_pickers),
            MainActivityNavigation.datePickerSamples
        ),
        MaterialDemo(
            context.getString(R.string.txt_floating_action_buttons),
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
            context.getString(R.string.txt_icon_buttons),
            MainActivityNavigation.iconButtonSamples
        ),
        MaterialDemo(
            context.getString(R.string.txt_lists),
            MainActivityNavigation.listSamples
        ),
        MaterialDemo(
            context.getString(R.string.txt_menus),
            MainActivityNavigation.menuSamples
        ),
        MaterialDemo(
            context.getString(R.string.txt_navigation_bar),
            MainActivityNavigation.navigationBarSamples
        ),
        MaterialDemo(
            context.getString(R.string.txt_navigation_rail),
            MainActivityNavigation.navigationRailSamples
        ),
        MaterialDemo(
            context.getString(R.string.txt_radio_buttons),
            MainActivityNavigation.radioButtonSamples
        ),
        MaterialDemo(
            context.getString(R.string.txt_segmented__button),
            MainActivityNavigation.segmentedButtonSamples
        ),
        MaterialDemo(
            context.getString(R.string.txt_switches),
            MainActivityNavigation.switchSamples
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

