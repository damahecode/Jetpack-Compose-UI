package com.code.damahe.feature.screen.template

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.code.damahe.res.R
import com.code.damahe.res.icon.MyIcons

@OptIn(
    ExperimentalMaterial3Api::class
)
@Composable
fun LoginSignupScreen(onGoBack: () -> Unit) {

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    val isCollapsed: Boolean by remember {
        derivedStateOf {
            scrollBehavior.state.collapsedFraction == 1f
        }
    }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LSTopBar(scrollBehavior, isCollapsed, onGoBack)
        }
    ) {
        Surface(
            shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
            modifier = Modifier.fillMaxWidth().padding(it),
        ) {
            Column(modifier = Modifier.padding(30.dp)) {

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 20.dp),
                    text = "Log in to your account",
                    textAlign = TextAlign.Center,
                    fontSize = 22.sp,
                )
                Text(
                    text = "Email Address",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(bottom = 10.dp, top = 10.dp)
                )
//                CustomStyleTextField(
//                    "Email Address",
//                    R.drawable.ic_email,
//                    KeyboardType.Email,
//                    VisualTransformation.None
//                )

            }
        }
    }
}

@OptIn(
    ExperimentalMaterial3Api::class
)
@Composable
fun LSTopBar(scrollBehavior: TopAppBarScrollBehavior, isCollapse: Boolean, onGoBack: () -> Unit) = LargeTopAppBar(
    title = { Text(text = stringResource(id = R.string.txt_login_signup))},
    navigationIcon = {
        IconButton(onClick = onGoBack) {
            Icon(MyIcons.ArrowBack, contentDescription = "Back")
        }
    },
    scrollBehavior = scrollBehavior
)