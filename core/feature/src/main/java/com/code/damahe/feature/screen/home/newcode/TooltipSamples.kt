package com.code.damahe.feature.screen.home.newcode
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.requiredHeight
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.AddCircle
//import androidx.compose.material.icons.filled.Favorite
//import androidx.compose.material.icons.filled.Info
//import androidx.compose.material3.CaretProperties
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.OutlinedButton
//import androidx.compose.material3.PlainTooltip
//import androidx.compose.material3.RichTooltip
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextButton
//import androidx.compose.material3.TooltipBox
//import androidx.compose.material3.TooltipDefaults
//import androidx.compose.material3.rememberTooltipState
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import kotlinx.coroutines.launch
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun PlainTooltipSample() {
//    TooltipBox(
//        positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
//        tooltip = {
//            PlainTooltip {
//                Text("Add to favorites")
//            }
//        },
//        state = rememberTooltipState()
//    ) {
//        IconButton(
//            onClick = { /* Icon button's click event */ }
//        ) {
//            Icon(
//                imageVector = Icons.Filled.Favorite,
//                contentDescription = "Localized Description"
//            )
//        }
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun PlainTooltipWithManualInvocationSample() {
//    val tooltipState = rememberTooltipState()
//    val scope = rememberCoroutineScope()
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        TooltipBox(
//            positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
//            tooltip = {
//                PlainTooltip {
//                    Text("Add to list")
//                }
//            },
//            state = tooltipState
//        ) {
//            Icon(
//                imageVector = Icons.Filled.AddCircle,
//                contentDescription = "Localized Description"
//            )
//        }
//        Spacer(Modifier.requiredHeight(30.dp))
//        OutlinedButton(
//            onClick = { scope.launch { tooltipState.show() } }
//        ) {
//            Text("Display tooltip")
//        }
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun PlainTooltipWithCaret() {
//    TooltipBox(
//        positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
//        tooltip = {
//            PlainTooltip(
//                caretProperties = TooltipDefaults.caretProperties
//            ) {
//                Text("Add to favorites")
//            }
//        },
//        state = rememberTooltipState()
//    ) {
//        IconButton(
//            onClick = { /* Icon button's click event */ }
//        ) {
//            Icon(
//                imageVector = Icons.Filled.Favorite,
//                contentDescription = "Localized Description"
//            )
//        }
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun PlainTooltipWithCustomCaret() {
//    TooltipBox(
//        positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
//        tooltip = {
//            PlainTooltip(
//                caretProperties = CaretProperties(12.dp, 24.dp)
//            ) {
//                Text("Add to favorites")
//            }
//        },
//        state = rememberTooltipState()
//    ) {
//        IconButton(
//            onClick = { /* Icon button's click event */ }
//        ) {
//            Icon(
//                imageVector = Icons.Filled.Favorite,
//                contentDescription = "Localized Description"
//            )
//        }
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun RichTooltipSample() {
//    val tooltipState = rememberTooltipState(isPersistent = true)
//    val scope = rememberCoroutineScope()
//    TooltipBox(
//        positionProvider = TooltipDefaults.rememberRichTooltipPositionProvider(),
//        tooltip = {
//            RichTooltip(
//                title = { Text(richTooltipSubheadText) },
//                action = {
//                    TextButton(
//                        onClick = { scope.launch { tooltipState.dismiss() } }
//                    ) { Text(richTooltipActionText) }
//                }
//            ) {
//                Text(richTooltipText)
//            }
//        },
//        state = tooltipState
//    ) {
//        IconButton(
//            onClick = { /* Icon button's click event */ }
//        ) {
//            Icon(
//                imageVector = Icons.Filled.Info,
//                contentDescription = "Localized Description"
//            )
//        }
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun RichTooltipWithManualInvocationSample() {
//    val tooltipState = rememberTooltipState(isPersistent = true)
//    val scope = rememberCoroutineScope()
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        TooltipBox(
//            positionProvider = TooltipDefaults.rememberRichTooltipPositionProvider(),
//            tooltip = {
//                RichTooltip(
//                    title = { Text(richTooltipSubheadText) },
//                    action = {
//                        TextButton(
//                            onClick = {
//                                scope.launch {
//                                    tooltipState.dismiss()
//                                }
//                            }
//                        ) { Text(richTooltipActionText) }
//                    }
//                ) { Text(richTooltipText) }
//            },
//            state = tooltipState
//        ) {
//            Icon(
//                imageVector = Icons.Filled.Info,
//                contentDescription = "Localized Description"
//            )
//        }
//        Spacer(Modifier.requiredHeight(30.dp))
//        OutlinedButton(
//            onClick = { scope.launch { tooltipState.show() } }
//        ) {
//            Text("Display tooltip")
//        }
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun RichTooltipWithCaretSample() {
//    val tooltipState = rememberTooltipState(isPersistent = true)
//    val scope = rememberCoroutineScope()
//    TooltipBox(
//        positionProvider = TooltipDefaults.rememberRichTooltipPositionProvider(),
//        tooltip = {
//            RichTooltip(
//                title = { Text(richTooltipSubheadText) },
//                action = {
//                    TextButton(
//                        onClick = { scope.launch { tooltipState.dismiss() } }
//                    ) { Text(richTooltipActionText) }
//                },
//                caretProperties = TooltipDefaults.caretProperties
//            ) {
//                Text(richTooltipText)
//            }
//        },
//        state = tooltipState
//    ) {
//        IconButton(
//            onClick = { /* Icon button's click event */ }
//        ) {
//            Icon(
//                imageVector = Icons.Filled.Info,
//                contentDescription = "Localized Description"
//            )
//        }
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun RichTooltipWithCustomCaretSample() {
//    val tooltipState = rememberTooltipState(isPersistent = true)
//    val scope = rememberCoroutineScope()
//    TooltipBox(
//        positionProvider = TooltipDefaults.rememberRichTooltipPositionProvider(),
//        tooltip = {
//            RichTooltip(
//                title = { Text(richTooltipSubheadText) },
//                action = {
//                    TextButton(
//                        onClick = { scope.launch { tooltipState.dismiss() } }
//                    ) { Text(richTooltipActionText) }
//                },
//                caretProperties = CaretProperties(16.dp, 32.dp)
//            ) {
//                Text(richTooltipText)
//            }
//        },
//        state = tooltipState
//    ) {
//        IconButton(
//            onClick = { /* Icon button's click event */ }
//        ) {
//            Icon(
//                imageVector = Icons.Filled.Info,
//                contentDescription = "Localized Description"
//            )
//        }
//    }
//}
//
//const val richTooltipSubheadText = "Permissions"
//const val richTooltipText =
//    "Configure permissions for selected service accounts. " +
//            "You can add and remove service account members and assign roles to them. " +
//            "Visit go/permissions for details"
//const val richTooltipActionText = "Request Access"