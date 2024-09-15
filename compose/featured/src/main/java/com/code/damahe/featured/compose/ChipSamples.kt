package com.code.damahe.featured.compose

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ElevatedSuggestionChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import com.code.damahe.featured.model.ComposeSample
import com.code.damahe.res.R
import com.code.damahe.res.icon.MyIcons

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ChipSamples(onGoBack: () -> Unit) {

    val list = listOf(
        ComposeSample("AssistChipSample") { AssistChipSample() },
        ComposeSample("ElevatedAssistChipSample") { ElevatedAssistChipSample() },
        ComposeSample("FilterChipSample") { FilterChipSample() },
        ComposeSample("ElevatedFilterChipSample") { ElevatedFilterChipSample() },
        ComposeSample("FilterChipWithLeadingIconSample") { FilterChipWithLeadingIconSample() },
        ComposeSample("InputChipSample") { InputChipSample() },
        ComposeSample("InputChipWithAvatarSample") { InputChipWithAvatarSample() },
        ComposeSample("SuggestionChipSample") { SuggestionChipSample() },
        ComposeSample("ElevatedSuggestionChipSample") { ElevatedSuggestionChipSample() },
        ComposeSample("ChipGroupSingleLineSample") { ChipGroupSingleLineSample() },
        ComposeSample("ChipGroupReflowSample") { ChipGroupReflowSample() },
    )

    Scaffold(
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
        contentWindowInsets = WindowInsets(0),
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.chips)) },
                navigationIcon = {
                    IconButton(onClick = onGoBack) {
                        Icon(MyIcons.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                ),
                windowInsets = WindowInsets(0)
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
                text = stringResource(id = R.string.description)
            )
            Text(
                modifier = Modifier.padding(15.dp),
                text = "Chips allow users to enter information, make selections, filter content, or trigger actions."
            )
            Text(
                modifier = Modifier.padding(15.dp),
                style = MaterialTheme.typography.titleMedium,
                text = stringResource(id = R.string.example)
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
fun AssistChipSample() {
    AssistChip(
        onClick = { /* Do something! */ },
        label = { Text("Assist Chip") },
        leadingIcon = {
            Icon(
                Icons.Filled.Settings,
                contentDescription = "Localized description",
                Modifier.size(AssistChipDefaults.IconSize)
            )
        }
    )
}

@Composable
fun ElevatedAssistChipSample() {
    ElevatedAssistChip(
        onClick = { /* Do something! */ },
        label = { Text("Assist Chip") },
        leadingIcon = {
            Icon(
                Icons.Filled.Settings,
                contentDescription = "Localized description",
                Modifier.size(AssistChipDefaults.IconSize)
            )
        }
    )
}

@Composable
fun FilterChipSample() {
    var selected by remember { mutableStateOf(false) }
    FilterChip(
        selected = selected,
        onClick = { selected = !selected },
        label = { Text("Filter chip") },
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Localized Description",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        }
    )
}

@Composable
fun ElevatedFilterChipSample() {
    var selected by remember { mutableStateOf(false) }
    ElevatedFilterChip(
        selected = selected,
        onClick = { selected = !selected },
        label = { Text("Filter chip") },
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Localized Description",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        }
    )
}

@Composable
fun FilterChipWithLeadingIconSample() {
    var selected by remember { mutableStateOf(false) }
    FilterChip(
        selected = selected,
        onClick = { selected = !selected },
        label = { Text("Filter chip") },
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Localized Description",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Localized description",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        }
    )
}

@Composable
fun InputChipSample() {
    var selected by remember { mutableStateOf(false) }
    InputChip(
        selected = selected,
        onClick = { selected = !selected },
        label = { Text("Input Chip") },
    )
}

@Composable
fun InputChipWithAvatarSample() {
    var selected by remember { mutableStateOf(false) }
    InputChip(
        selected = selected,
        onClick = { selected = !selected },
        label = { Text("Input Chip") },
        avatar = {
            Icon(
                Icons.Filled.Person,
                contentDescription = "Localized description",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        }
    )
}

@Composable
fun SuggestionChipSample() {
    SuggestionChip(
        onClick = { /* Do something! */ },
        label = { Text("Suggestion Chip") }
    )
}

@Composable
fun ElevatedSuggestionChipSample() {
    ElevatedSuggestionChip(
        onClick = { /* Do something! */ },
        label = { Text("Suggestion Chip") }
    )
}

@Composable
fun ChipGroupSingleLineSample() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            repeat(9) { index ->
                AssistChip(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    onClick = { /* do something*/ },
                    label = { Text("Chip $index") }
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ChipGroupReflowSample() {
    val colorNames = listOf(
        "Blue", "Yellow", "Red", "Orange", "Black", "Green",
        "White", "Magenta", "Gray", "Transparent"
    )
    Column {
        FlowRow(
            Modifier
                .fillMaxWidth(1f)
                .wrapContentHeight(align = Alignment.Top),
            horizontalArrangement = Arrangement.Start,
        ) {
            colorNames.fastForEachIndexed { index, element ->
                AssistChip(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .align(alignment = Alignment.CenterVertically),
                    onClick = { /* do something*/ },
                    label = { Text("$element $index") }
                )
            }
        }
    }
}