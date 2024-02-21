package com.code.damahe.preference.screen

import android.content.Intent
import android.net.Uri
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.code.damahe.material.dialogs.ThemeDialog
import com.code.damahe.material.model.ThemeString
import com.code.damahe.res.R
import com.code.damahe.res.icon.MyIcons
import com.code.damahe.res.icon.DCodeIcon
import com.code.damahe.res.icon.DCodeIcon.DrawableResourceIcon
import com.code.damahe.res.icon.DCodeIcon.ImageVectorIcon

@OptIn(
    ExperimentalComposeUiApi::class,
    ExperimentalMaterial3Api::class,
)
@Composable
fun PreferenceScreen(
    onGoBack: () -> Unit
) {

    val context = LocalContext.current
    val showThemeSettingsDialog = remember { mutableStateOf(false) }

    if (showThemeSettingsDialog.value) {
        ThemeDialog(
            string = ThemeString(R.string.title_app_theme, R.string.loading, R.string.ok, R.string.brand_default,
                R.string.brand_dynamic, R.string.gradient_colors_preference, R.string.gradient_colors_yes,
                R.string.gradient_colors_no, R.string.dark_mode_preference, R.string.dark_mode_config_system_default,
                R.string.dark_mode_config_light, R.string.dark_mode_config_dark),
            onDismiss = {showThemeSettingsDialog.value = false},
        )
    }

    Scaffold(
        modifier = Modifier.semantics {
            testTagsAsResourceId = true
        },
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
        contentWindowInsets = WindowInsets.navigationBars,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.txt_preferences))
                },
                navigationIcon = {
                    IconButton(onClick = onGoBack) {
                        Icon(MyIcons.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                ),
            )
        }
    ) { padding ->


        Column(modifier = Modifier
                .padding(padding)
                .padding(start = 15.dp, end = 15.dp)
                .verticalScroll(rememberScrollState())) {

            SettingsGroup(name = R.string.txt_general) {
                SettingsTextComp(
                    name = R.string.title_app_theme,
                    icon = DrawableResourceIcon(MyIcons.Palette),
                    desc = R.string.txt_theme_description,
                    onClick = { showThemeSettingsDialog.value = true },
                )
            }

            SettingsGroup(name = R.string.txt_more_options) {
                SettingsTextComp(
                    name = R.string.txt_source_code,
                    icon = DrawableResourceIcon(MyIcons.CodeTag),
                    desc = R.string.source_code_description,
                    onClick = {
                        context.startActivity(
                            Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://github.com/damahecode/Jetpack-Compose-UI")
                        ))
                    },
                )

                SettingsTextComp(
                    name = R.string.txt_about,
                    icon = ImageVectorIcon(MyIcons.Info),
                    desc = R.string.about_description,
                    onClick = {  },
                )

                SettingsTextComp(
                    name = R.string.txt_changelog,
                    icon = DrawableResourceIcon(MyIcons.History),
                    desc = R.string.changelog_description,
                    onClick = {  },
                )

                SettingsTextComp(
                    name = R.string.txt_open_source_libraries,
                    icon = DrawableResourceIcon(MyIcons.Android_Head),
                    desc = R.string.open_source_libraries_description,
                    onClick = {  },
                )
            }
        }
    }
}

@Composable
fun SettingsGroup(
    @StringRes name: Int,
    // to accept only composable compatible with column
    content: @Composable ColumnScope.() -> Unit
){
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(
            text = stringResource(id = name),
            style = MaterialTheme.typography.labelMedium,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8),
        ) {
            Column {
                content()
            }
        }
    }
}

@Composable
fun SettingsTextComp(
    icon: DCodeIcon,
    @StringRes desc: Int,
    @StringRes name: Int,
    onClick: () -> Unit,
) {
    Surface(
        onClick = onClick,
    ) {
        Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            when (icon) {
                is ImageVectorIcon -> Icon(
                    imageVector = icon.imageVector,
                    contentDescription = stringResource(id = desc),
                    modifier = Modifier
                        .size(40.dp)
                        .padding(6.dp)
                )

                is DrawableResourceIcon -> Icon(
                    painter = painterResource(id = icon.id),
                    contentDescription = stringResource(id = desc),
                    modifier = Modifier
                        .size(40.dp)
                        .padding(6.dp)
                )
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .weight(1f)
            ) {
                // setting text title
                Text(
                    text = stringResource(id = name),
                    style = MaterialTheme.typography.titleSmall
                )
                // setting text desc
                Text(
                    text = stringResource(id = desc),
                    style = MaterialTheme.typography.bodySmall, maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            Icon(
                imageVector = MyIcons.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier.padding(4.dp)
            )
        }
    }

}