package com.code.damahe.feature.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.code.damahe.feature.model.HomeSample
import com.code.damahe.res.R
import com.code.damahe.res.icon.MyIcons

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RadioButtonSamples(onGoBack: () -> Unit) {
    val list = listOf(
        HomeSample("RadioButton") { RadioButtonSample() },
        HomeSample("RadioGroup") { RadioGroupSample() },
    )

    Scaffold(
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
        contentWindowInsets = WindowInsets.safeContent,
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.txt_radio_buttons)) },
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
                text = "Radio buttons allow the user to select one option from a set."
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
fun RadioButtonSample() {
    // We have two radio buttons and only one can be selected
    var state by remember { mutableStateOf(true) }
    // Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior.
    // We also set a content description for this sample, but note that a RadioButton would usually
    // be part of a higher level component, such as a raw with text, and that component would need
    // to provide an appropriate content description. See RadioGroupSample.
    Row(Modifier.selectableGroup()) {
        RadioButton(
            selected = state,
            onClick = { state = true },
            modifier = Modifier.semantics { contentDescription = "Localized Description" }
        )
        RadioButton(
            selected = !state,
            onClick = { state = false },
            modifier = Modifier.semantics { contentDescription = "Localized Description" }
        )
    }
}

@Composable
fun RadioGroupSample() {
    val radioOptions = listOf("Calls", "Missed", "Friends")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
    // Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior
    Column(Modifier.selectableGroup()) {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = null // null recommended for accessibility with screenreaders
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}