package com.code.damahe.ui.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailDefaults
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.offset
import androidx.compose.ui.unit.sp
import com.code.damahe.res.R
import com.code.damahe.res.icon.DrawIcon
import com.code.damahe.ui.model.TopLevelDestination

@Composable
fun DCodeNavigationRail(
    topLevelDestinations: List<TopLevelDestination>,
    selectedDestination: String,
    navigateToTopLevelDestination: (TopLevelDestination) -> Unit,
    isPermanentNavDrawer: Boolean = false,
    actionButton: @Composable () -> Unit = {},
    actionButtonPos: Int = topLevelDestinations.size / 2
) {
    NavigationRail(
        modifier = Modifier.fillMaxHeight(),
        windowInsets = if (isPermanentNavDrawer) WindowInsets(0) else NavigationRailDefaults.windowInsets
    ) {
        Spacer(modifier = Modifier.weight(1f))
        var i = 0
        topLevelDestinations.forEach { destination ->
            if (i == actionButtonPos) {
                actionButton()
            }
            i++
            NavigationRailItem(
                selected = selectedDestination == destination.route,
                onClick = { navigateToTopLevelDestination(destination) },
                icon = {
                    DrawIcon(icon = destination.selectedIcon,
                        contentDescription = stringResource(
                            id = destination.iconTextId
                        )
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = destination.iconTextId),
                        fontSize = 10.sp
                    )
                },
            )
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun DCodeBottomNavigationBar(
    topLevelDestinations: List<TopLevelDestination>,
    selectedDestination: String,
    navigateToTopLevelDestination: (TopLevelDestination) -> Unit,
    actionButton: @Composable () -> Unit = {},
    actionButtonPos: Int = topLevelDestinations.size / 2
) {
    NavigationBar(modifier = Modifier.fillMaxWidth()) {
        var i = 0
        topLevelDestinations.forEach { destination ->
            if (i == actionButtonPos) {
                actionButton()
            }
            i++
            NavigationBarItem(
                selected = selectedDestination == destination.route,
                onClick = { navigateToTopLevelDestination(destination) },
                icon = {
                    DrawIcon(
                        icon = destination.selectedIcon,
                        contentDescription = stringResource(id = destination.iconTextId)
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = destination.iconTextId),
                        fontSize = 9.sp,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 1,
                    )
                },
            )
        }
    }
}

@Composable
fun DCodeNavigationDrawerContent(
    title: String,
    topLevelDestinations: List<TopLevelDestination>,
    selectedDestination: String,
    navigationContentPosition: DCodeNavigationContentPosition,
    navigateToTopLevelDestination: (TopLevelDestination) -> Unit,
    extendedFloatingActionButton: @Composable () -> Unit = {},
    showBackButton: Boolean = true,
    onDrawerClicked: () -> Unit = {},
) {

        // TODO remove custom nav drawer content positioning when NavDrawer component supports it. ticket : b/232495216
        Layout(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .padding(start = 16.dp, end = 16.dp),
            content = {
                Column(
                    modifier = Modifier.layoutId(LayoutType.HEADER),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                        if (showBackButton) {
                            FilledIconButton(onClick = onDrawerClicked) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                                    contentDescription = stringResource(id = R.string.navigation_drawer)
                                )
                            }
                        }
                    }
                    extendedFloatingActionButton()
                    Spacer(Modifier.height(5.dp))
                }

                Column(
                    modifier = Modifier
                        .layoutId(LayoutType.CONTENT)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    topLevelDestinations.forEach { destination ->
                        NavigationDrawerItem(
                            selected = selectedDestination == destination.route,
                            label = {
                                Text(
                                    text = stringResource(id = destination.iconTextId),
                                    modifier = Modifier.padding(horizontal = 16.dp)
                                )
                            },
                            icon = {
                                DrawIcon(
                                    icon = destination.selectedIcon,
                                    contentDescription = stringResource(
                                        id = destination.iconTextId
                                    )
                                )
                            },
                            colors = NavigationDrawerItemDefaults.colors(
                                unselectedContainerColor = Color.Transparent
                            ),
                            onClick = {
                                navigateToTopLevelDestination(destination)
                                if (showBackButton) onDrawerClicked()
                            }
                        )
                    }
                }
            },
            measurePolicy = navigationMeasurePolicy(navigationContentPosition)
        )
}

fun navigationMeasurePolicy(
    navigationContentPosition: DCodeNavigationContentPosition,
): MeasurePolicy {
    return MeasurePolicy { measurable, constraints ->
        lateinit var headerMeasurable: Measurable
        lateinit var contentMeasurable: Measurable
        measurable.forEach {
            when (it.layoutId) {
                LayoutType.HEADER -> headerMeasurable = it
                LayoutType.CONTENT -> contentMeasurable = it
                else -> error("Unknown layoutId encountered!")
            }
        }

        val headerPlaceable = headerMeasurable.measure(constraints)
        val contentPlaceable = contentMeasurable.measure(
            constraints.offset(vertical = -headerPlaceable.height)
        )
        layout(constraints.maxWidth, constraints.maxHeight) {
            // Place the header, this goes at the top
            headerPlaceable.placeRelative(0, 0)

            // Determine how much space is not taken up by the content
            val nonContentVerticalSpace = constraints.maxHeight - contentPlaceable.height

            val contentPlaceableY = when (navigationContentPosition) {
                // Figure out the place we want to place the content, with respect to the
                // parent (ignoring the header for now)
                DCodeNavigationContentPosition.TOP -> 0
                DCodeNavigationContentPosition.CENTER -> nonContentVerticalSpace / 2
            }
                // And finally, make sure we don't overlap with the header.
                .coerceAtLeast(headerPlaceable.height)

            contentPlaceable.placeRelative(0, contentPlaceableY)
        }
    }
}

enum class LayoutType {
    HEADER, CONTENT
}