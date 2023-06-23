package com.code.damahe.feature.screen.template

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import com.code.damahe.feature.screen.ExampleScreen
import com.code.damahe.res.R

@OptIn(
    ExperimentalComposeUiApi::class,
    ExperimentalMaterial3Api::class
)
@Composable
fun ProfileScreen(onGoBack: () -> Unit) {


    Scaffold(
        modifier = Modifier.semantics {
            testTagsAsResourceId = true
        },
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.txt_profile))
                },
                navigationIcon = {
                    IconButton(onClick = onGoBack) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Transparent,
                ),
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier.padding(padding)
        ) {

            ExampleScreen()

        }
    }
}