package com.code.damahe.responsive.screen.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.window.layout.DisplayFeature
import androidx.window.layout.FoldingFeature
import com.code.damahe.res.R
import com.code.damahe.responsive.screen.navigation.DCodeBottomNavigationBar
import com.code.damahe.responsive.screen.navigation.DCodeNavigationDrawerContent
import com.code.damahe.responsive.screen.navigation.DCodeNavigationRail
import com.code.damahe.responsive.screen.navigation.main.MainNavHost
import com.code.damahe.responsive.screen.navigation.main.MainNavAppState
import com.code.damahe.responsive.screen.navigation.main.MAIN_TOP_LEVEL_DESTINATIONS
import com.code.damahe.responsive.screen.navigation.main.rememberMainNavAppState
import com.code.damahe.responsive.screen.utils.DCodeContentType
import com.code.damahe.responsive.screen.utils.DCodeNavigationContentPosition
import com.code.damahe.responsive.screen.utils.DCodeNavigationType
import com.code.damahe.responsive.screen.utils.DevicePosture
import com.code.damahe.responsive.screen.utils.isBookPosture
import com.code.damahe.responsive.screen.utils.isSeparating
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    windowSize: WindowSizeClass,
    displayFeatures: List<DisplayFeature>,
) {
    /**
     * This will help us select type of navigation and content type depending on window size and
     * fold state of the device.
     */
    val navigationType: DCodeNavigationType
    val contentType: DCodeContentType

    /**
     * We are using display's folding features to map the device postures a fold is in.
     * In the state of folding device If it's half fold in BookPosture we want to avoid content
     * at the crease/hinge
     */
    val foldingFeature = displayFeatures.filterIsInstance<FoldingFeature>().firstOrNull()

    val foldingDevicePosture = when {
        isBookPosture(foldingFeature) ->
            DevicePosture.BookPosture(foldingFeature.bounds)

        isSeparating(foldingFeature) ->
            DevicePosture.Separating(foldingFeature.bounds, foldingFeature.orientation)

        else -> DevicePosture.NormalPosture
    }

    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            navigationType = DCodeNavigationType.BOTTOM_NAVIGATION
            contentType = DCodeContentType.SINGLE_PANE
        }
        WindowWidthSizeClass.Medium -> {
            navigationType = DCodeNavigationType.NAVIGATION_RAIL
            contentType = if (foldingDevicePosture is DevicePosture.NormalPosture) {
                DCodeContentType.SINGLE_PANE
            } else {
                DCodeContentType.DUAL_PANE
            }
        }
        WindowWidthSizeClass.Expanded -> {
            navigationType = if (foldingDevicePosture is DevicePosture.BookPosture) {
                DCodeNavigationType.NAVIGATION_RAIL
            } else {
                DCodeNavigationType.PERMANENT_NAVIGATION_DRAWER
            }
            contentType = if (foldingDevicePosture is DevicePosture.NormalPosture) {
                DCodeContentType.SINGLE_PANE
            } else {
                DCodeContentType.DUAL_PANE
            }
        }
        else -> {
            navigationType = DCodeNavigationType.BOTTOM_NAVIGATION
            contentType = DCodeContentType.SINGLE_PANE
        }
    }

    /**
     * Content inside Navigation Rail/Drawer can also be positioned at top, bottom or center for
     * ergonomics and reachability depending upon the height of the device.
     */
    val navigationContentPosition = when (windowSize.heightSizeClass) {
        WindowHeightSizeClass.Compact -> {
            DCodeNavigationContentPosition.TOP
        }
        WindowHeightSizeClass.Medium,
        WindowHeightSizeClass.Expanded -> {
            DCodeNavigationContentPosition.CENTER
        }
        else -> {
            DCodeNavigationContentPosition.TOP
        }
    }

    DCodeNavigationWrapper(
        navAppState = rememberMainNavAppState(
            displayFeatures = displayFeatures,
            navigationType = navigationType,
            contentType = contentType,
            navigationContentPosition =  navigationContentPosition
        )
    )
}

@Composable
private fun DCodeNavigationWrapper(
    navAppState: MainNavAppState,
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val navBackStackEntry by navAppState.navController.currentBackStackEntryAsState()

    if (navAppState.navigationType == DCodeNavigationType.PERMANENT_NAVIGATION_DRAWER) {
        // TODO check on custom width of PermanentNavigationDrawer: b/232495216
        PermanentNavigationDrawer(drawerContent = {
            PermanentDrawerSheet(
                modifier = Modifier.sizeIn(minWidth = 200.dp, maxWidth = 300.dp),
                drawerContainerColor = MaterialTheme.colorScheme.inverseOnSurface,
            ) {
                DCodeNavigationDrawerContent(
                    title = stringResource(id = R.string.app_name).uppercase(),
                    topLevelDestinations = MAIN_TOP_LEVEL_DESTINATIONS,
                    selectedDestination = navAppState.selectedDestination(navBackStackEntry),
                    navigationContentPosition = navAppState.navigationContentPosition,
                    navigateToTopLevelDestination = navAppState::navigateTo,
                    showBackButton = false,
                    extendedFloatingActionButton = {
                        ExtendedFloatingActionButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp, bottom = 15.dp),
                            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                            contentColor = MaterialTheme.colorScheme.onTertiaryContainer
                        ) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = stringResource(id = R.string.edit),
                                modifier = Modifier.size(18.dp)
                            )
                            Text(
                                text = stringResource(id = R.string.compose),
                                modifier = Modifier.weight(1f),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                )
            }
        }) {
            MainAppContent(
                navAppState = navAppState,
                selectedDestination = navAppState.selectedDestination(navBackStackEntry)
            )
        }
    } else {
        fun onDrawerClicked() {
            scope.launch {
                if (drawerState.isOpen) {
                    drawerState.close()
                } else {
                    drawerState.open()
                }
            }
        }

        ModalNavigationDrawer(
            drawerContent = {
                ModalDrawerSheet(
                    modifier = Modifier.sizeIn(minWidth = 200.dp, maxWidth = 300.dp),
                    drawerContainerColor = MaterialTheme.colorScheme.inverseOnSurface,
                ) {
                    DCodeNavigationDrawerContent(
                        title = stringResource(id = R.string.app_name).uppercase(),
                        topLevelDestinations = MAIN_TOP_LEVEL_DESTINATIONS,
                        selectedDestination = navAppState.selectedDestination(navBackStackEntry),
                        navigationContentPosition = navAppState.navigationContentPosition,
                        navigateToTopLevelDestination = navAppState::navigateTo,
                        onDrawerClicked = {
                            onDrawerClicked()
                        },
                        extendedFloatingActionButton = {
                            ExtendedFloatingActionButton(
                                onClick = { onDrawerClicked() },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp, bottom = 15.dp),
                                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                                contentColor = MaterialTheme.colorScheme.onTertiaryContainer
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Edit,
                                    contentDescription = stringResource(id = R.string.edit),
                                    modifier = Modifier.size(18.dp)
                                )
                                Text(
                                    text = stringResource(id = R.string.compose),
                                    modifier = Modifier.weight(1f),
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    )
                }
            },
            drawerState = drawerState
        ) {
            MainAppContent(
                navAppState = navAppState,
                selectedDestination = navAppState.selectedDestination(navBackStackEntry)
            ) {
                onDrawerClicked()
            }
        }
    }
}

@Composable
fun MainAppContent(
    modifier: Modifier = Modifier,
    navAppState: MainNavAppState,
    selectedDestination: String,
    onDrawerClicked: () -> Unit = {}
) {
    Row(modifier = modifier.fillMaxSize()) {
        val typeRail = navAppState.navigationType == DCodeNavigationType.NAVIGATION_RAIL
        val typePerNavDrawer = navAppState.navigationType == DCodeNavigationType.PERMANENT_NAVIGATION_DRAWER
        AnimatedVisibility(visible = (typeRail || typePerNavDrawer)) {
            DCodeNavigationRail(
                topLevelDestinations = MAIN_TOP_LEVEL_DESTINATIONS,
                selectedDestination = selectedDestination,
                navigateToTopLevelDestination = navAppState::navigateTo,
                isPermanentNavDrawer = typePerNavDrawer,
                actionButton = {
                    FloatingActionButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.padding(top = 8.dp, bottom = 15.dp),
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                        contentColor = MaterialTheme.colorScheme.onTertiaryContainer
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = stringResource(id = R.string.edit),
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            MainNavHost(
                navAppState = navAppState,
                modifier = Modifier.weight(1f),
                onDrawerClicked = onDrawerClicked
            )
            AnimatedVisibility(visible = navAppState.navigationType == DCodeNavigationType.BOTTOM_NAVIGATION) {
                DCodeBottomNavigationBar(
                    topLevelDestinations = MAIN_TOP_LEVEL_DESTINATIONS,
                    selectedDestination = selectedDestination,
                    navigateToTopLevelDestination = navAppState::navigateTo,
                    actionButton = {
                        FloatingActionButton(
                            onClick = { /*TODO*/ },
                            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                            contentColor = MaterialTheme.colorScheme.onTertiaryContainer
                        ) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = stringResource(id = R.string.edit),
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }
                )
            }
        }
    }
}