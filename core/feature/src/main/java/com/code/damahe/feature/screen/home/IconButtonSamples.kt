package com.code.damahe.feature.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.FilledTonalIconToggleButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedIconToggleButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.code.damahe.feature.model.HomeSample
import com.code.damahe.res.R
import com.code.damahe.res.icon.MyIcons

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IconButtonSamples(onGoBack: () -> Unit) {
    val list = listOf(
        HomeSample("IconButton") { IconButtonSample() },
        HomeSample("IconToggleButton") { IconToggleButtonSample() },
        HomeSample("FilledIconButton") { FilledIconButtonSample() },
        HomeSample("FilledIconToggleButton") { FilledIconToggleButtonSample() },
        HomeSample("FilledTonalIconButton") { FilledTonalIconButtonSample() },
        HomeSample("FilledTonalIconToggleButton") { FilledTonalIconToggleButtonSample() },
        HomeSample("OutlineIconButton") { OutlinedIconButtonSample() },
        HomeSample("OutlineIconToggleButton") { OutlinedIconToggleButtonSample() },
    )

    Scaffold(
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
        contentWindowInsets = WindowInsets.safeContent,
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.txt_icon_buttons)) },
                navigationIcon = {
                    IconButton(onClick = onGoBack) {
                        Icon(MyIcons.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                ),
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                modifier = Modifier.padding(15.dp),
                style = MaterialTheme.typography.titleMedium,
                text = stringResource(id = R.string.txt_description)
            )
            Text(
                modifier = Modifier.padding(15.dp),
                text = "Icon buttons allow users to take actions and make choices with a single tap."
            )
            Text(
                modifier = Modifier.padding(15.dp),
                style = MaterialTheme.typography.titleMedium,
                text = stringResource(id = R.string.txt_example)
            )
            list.forEach {
                OutlinedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Text(
                        modifier = Modifier.padding(10.dp),
                        style = MaterialTheme.typography.titleLarge,
                        text = it.name
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    it.content()
                }
            }
        }
    }
}

@Composable
fun IconButtonSample() {
    IconButton(onClick = { /* doSomething() */ }) {
        Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
    }
}

@Composable
fun IconToggleButtonSample() {
    var checked by remember { mutableStateOf(false) }
    IconToggleButton(checked = checked, onCheckedChange = { checked = it }) {
        if (checked) {
            Icon(Icons.Filled.Lock, contentDescription = "Localized description")
        } else {
            Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
        }
    }
}

@Composable
fun FilledIconButtonSample() {
    FilledIconButton(onClick = { /* doSomething() */ }) {
        Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
    }
}

@Composable
fun FilledIconToggleButtonSample() {
    var checked by remember { mutableStateOf(false) }
    FilledIconToggleButton(checked = checked, onCheckedChange = { checked = it }) {
        if (checked) {
            Icon(Icons.Filled.Lock, contentDescription = "Localized description")
        } else {
            Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
        }
    }
}

@Composable
fun FilledTonalIconButtonSample() {
    FilledTonalIconButton(onClick = { /* doSomething() */ }) {
        Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
    }
}

@Composable
fun FilledTonalIconToggleButtonSample() {
    var checked by remember { mutableStateOf(false) }
    FilledTonalIconToggleButton(checked = checked, onCheckedChange = { checked = it }) {
        if (checked) {
            Icon(Icons.Filled.Lock, contentDescription = "Localized description")
        } else {
            Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
        }
    }
}

@Composable
fun OutlinedIconButtonSample() {
    OutlinedIconButton(onClick = { /* doSomething() */ }) {
        Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
    }
}

@Composable
fun OutlinedIconToggleButtonSample() {
    var checked by remember { mutableStateOf(false) }
    OutlinedIconToggleButton(checked = checked, onCheckedChange = { checked = it }) {
        if (checked) {
            Icon(Icons.Filled.Lock, contentDescription = "Localized description")
        } else {
            Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
        }
    }
}