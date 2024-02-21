package com.code.damahe.feature.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.unit.dp
import com.code.damahe.feature.model.HomeSample
import com.code.damahe.res.R
import com.code.damahe.res.icon.MyIcons

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ButtonSamples(onGoBack: () -> Unit) {

    val buttons = listOf(
        HomeSample("ButtonSample") { ButtonSample() },
        HomeSample("ElevatedButtonSample") { ElevatedButtonSample() },
        HomeSample("FilledTonalButtonSample") { FilledTonalButtonSample() },
        HomeSample("OutlineButtonSample") { OutlinedButtonSample() },
        HomeSample("TextButtonSample") { TextButtonSample() },
        HomeSample("ButtonWidthIconSample") { ButtonWithIconSample() },
    )

    Scaffold(
        modifier = Modifier.semantics {
            testTagsAsResourceId = true
        },
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
        contentWindowInsets = WindowInsets.safeContent,
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.txt_buttons)) },
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
                text = "Buttons help people initiate actions from sending an email, to sharing a document, to liking a post."
            )
            Text(
                modifier = Modifier.padding(15.dp),
                style = MaterialTheme.typography.titleMedium,
                text = stringResource(id = R.string.txt_example)
            )
            buttons.forEach {
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
fun ButtonSample() {
    Button(onClick = { /* Do something! */ }) { Text("Button") }
}

@Composable
fun ElevatedButtonSample() {
    ElevatedButton(onClick = { /* Do something! */ }) { Text("Elevated Button") }
}

@Composable
fun FilledTonalButtonSample() {
    FilledTonalButton(onClick = { /* Do something! */ }) { Text("Filled Tonal Button") }
}

@Composable
fun OutlinedButtonSample() {
    OutlinedButton(onClick = { /* Do something! */ }) { Text("Outlined Button") }
}

@Composable
fun TextButtonSample() {
    TextButton(onClick = { /* Do something! */ }) { Text("Text Button") }
}

@Composable
fun ButtonWithIconSample() {
    Button(
        onClick = { /* Do something! */ },
        contentPadding = ButtonDefaults.ButtonWithIconContentPadding
    ) {
        Icon(
            Icons.Filled.Favorite,
            contentDescription = "Localized description",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("Like")
    }
}