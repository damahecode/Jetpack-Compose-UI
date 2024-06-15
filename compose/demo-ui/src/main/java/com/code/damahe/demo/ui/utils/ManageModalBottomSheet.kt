package com.code.damahe.demo.ui.utils

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * This modal sheet is used across all screens with default sheet config.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun modalBottomSheetState(
    skipHalfExpanded: Boolean = true
): SheetState {
    return rememberModalBottomSheetState(
        skipPartiallyExpanded = skipHalfExpanded
    )
}

/**
 * We no more have to create coroutine scope or launch effects anywhere in any composables when we
 * have to use [SheetState] to manage it show or hide states.
 * Not necessary to check whether sheet is open or not, if the current sheet state is Visible sheet
 * will close, if sheet state is Hidden then it will open.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun manageModalBottomSheet(
    sheetState: SheetState
): () -> Job {
    val coroutineScope = rememberCoroutineScope()

    val hideOrShowModalBottomSheet = {
        coroutineScope.launch {
            when {
                sheetState.isVisible -> sheetState.hide()
                !sheetState.isVisible -> sheetState.show()
            }
        }
    }

    return hideOrShowModalBottomSheet
}