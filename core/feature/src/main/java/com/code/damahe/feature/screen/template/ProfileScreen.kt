package com.code.damahe.feature.screen.template

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.code.damahe.feature.model.FeatureList
import com.code.damahe.feature.model.ImageTextList
import com.code.damahe.feature.model.ProfilePopularList
import com.code.damahe.feature.util.manageModalBottomSheet
import com.code.damahe.feature.util.modalBottomSheetState
import com.code.damahe.res.R
import com.code.damahe.res.icon.DCodeIcon.ImageVectorIcon
import com.code.damahe.res.icon.DCodeIcon.DrawableResourceIcon
import com.code.damahe.res.icon.MyIcons

const val displayName = "Damahe Code"
const val username = "damahecode"
const val my_description = "Passionate developer creating innovative solutions with a love for technology. Solving problems, learning and building applications that drive positive change"
val profilePopularList = listOf(
    ProfilePopularList("Jetpack-Compose-UI", "A Collection on all Jetpack compose UI Layouts and Demo screens to see it's potential", "25", "Kotlin"),
    ProfilePopularList("Leaf-Explorer", "File Manager, File Sharing & Music Player App for Android", "100", "Kotlin"),
    ProfilePopularList("Material-Theme", "A Material Design-based Theme Management System for Android Jetpack Compose.", "150", "Kotlin"),
    ProfilePopularList("Weather", "A demo implementation of Weather API in Android App.", "15", "Kotlin")
)
val imageTextList = listOf(
    ImageTextList(ImageVectorIcon(MyIcons.Location), "Bharat/India"),
    ImageTextList(ImageVectorIcon(MyIcons.Email), "damahecode@gmail.com"),
    ImageTextList(ImageVectorIcon(MyIcons.AccountBox), "100 followers")
)
val moreOptionsList = listOf(
    FeatureList("Edit Profile", ImageVectorIcon(MyIcons.Edit), ""),
    FeatureList("Manage Account", ImageVectorIcon(MyIcons.AccountBox), ""),
    FeatureList("Privacy Policy", DrawableResourceIcon(MyIcons.Policy), ""),
    FeatureList("About", ImageVectorIcon(MyIcons.Info), ""),
    FeatureList("Help & Feedback", DrawableResourceIcon(MyIcons.Android_Head), ""),
    FeatureList("Share '$displayName'", ImageVectorIcon(MyIcons.Share), ""),
)

@OptIn(
    ExperimentalComposeUiApi::class,
    ExperimentalMaterial3Api::class
)
@Composable
fun ProfileScreen(onGoBack: () -> Unit) {

    val modalSheetState = modalBottomSheetState()

    val openMoreDetailsBottomSheet = manageModalBottomSheet(sheetState = modalSheetState)

    if (modalSheetState.isVisible) {
        ModalBottomSheet(onDismissRequest = {},
            sheetState = modalSheetState,
            scrimColor = Color.Black.copy(alpha = 0.7f),
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            containerColor = Color.Transparent,
        ) {
            Column {
                FooterContent()
            }
        }
    }

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
        contentWindowInsets = WindowInsets.safeContent,
        topBar = {
            TopAppBar(
                scrollBehavior = scrollBehavior,
                title = {
                    Text(text = stringResource(id = R.string.txt_profile))
                },
                navigationIcon = {
                    IconButton(onClick = onGoBack) {
                        Icon(MyIcons.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(MyIcons.Search, contentDescription = "Search")
                    }
                    IconButton(onClick = {
                        openMoreDetailsBottomSheet()
                    }) {
                        Icon(MyIcons.MoreVert, contentDescription = "More")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                    scrolledContainerColor = Color.Transparent,
                ),
            )
        }
    ) { padding ->

        Column(modifier = Modifier
            .padding(padding)
            .verticalScroll(rememberScrollState())) {

            TopProfileLayout()
            MainProfileContent()
            FooterContent()
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TopProfileLayout() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        shape = RoundedCornerShape(8),
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Row(
                modifier = Modifier.padding(vertical = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(id = DrawableResourceIcon(MyIcons.AppIcon).id),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(60.dp)
                )
                Column(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .weight(1f)
                ) {
                    Text(
                        text = displayName,
                        style = MaterialTheme.typography.titleLarge
                    )

                    Text(
                        text = username,
                        style = MaterialTheme.typography.labelMedium,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }

            Text(
                modifier = Modifier.padding(vertical = 5.dp),
                text = my_description,
                style = MaterialTheme.typography.bodySmall,
            )

            FlowRow(modifier = Modifier.padding(vertical = 5.dp)) {
                imageTextList.forEach {
                    ImageTextContent(
                        modifier = Modifier.padding(vertical = 5.dp),
                        icon = {
                            when (it.icon) {
                                is ImageVectorIcon -> Icon(
                                    imageVector = it.icon.imageVector,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(20.dp)
                                )

                                is DrawableResourceIcon -> Icon(
                                    painter = painterResource(id = it.icon.id),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(20.dp)
                                )
                            }
                        },
                        text = {
                            Text(
                                text = it.text,
                                style = MaterialTheme.typography.labelLarge,
                            )
                        }
                    )
                }
            }

        }

    }
}

@Composable
fun ImageTextContent(
    icon: @Composable () -> Unit,
    text: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        icon()
        Spacer(modifier = Modifier.width(5.dp))
        text()
        Spacer(modifier = Modifier.width(10.dp))
    }
}

@Composable
fun MainProfileContent() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        shape = RoundedCornerShape(8),
    ) {
        Column(modifier = Modifier.padding(5.dp)) {
            Text(
                modifier = Modifier
                    .padding(10.dp),
                text = "Popular",
                style = MaterialTheme.typography.titleMedium,
            )
            PopularContentList()

            HorizontalDivider(modifier = Modifier.padding(vertical = 15.dp))

            GitContentItem(
                modifier = Modifier.padding(vertical = 2.dp),
                icon = {
                    Icon(
                        imageVector = ImageVectorIcon(MyIcons.List).imageVector,
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(6.dp)
                    )
                },
                text = {
                    Text(
                        text = "Repositories",
                        style = MaterialTheme.typography.labelLarge,
                    )
                },
                endItem = {
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "24"
                    )
                }
            )
            GitContentItem(
                modifier = Modifier.padding(vertical = 2.dp),
                icon = {
                    Icon(
                        imageVector = ImageVectorIcon(MyIcons.Star).imageVector,
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(6.dp)
                    )
                },
                text = {
                    Text(
                        text = "Starred",
                        style = MaterialTheme.typography.labelLarge,
                    )
                },
                endItem = {
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "60"
                    )
                }
            )
        }
    }
}

@Composable
fun PopularContentList() {
    LazyRow {
        items(
            items = profilePopularList,
            itemContent = {
                Surface(
                    modifier = Modifier
                        .width(250.dp)
                        .padding(5.dp),
                    shape = RoundedCornerShape(8),
                    border = BorderStroke(0.1.dp, MaterialTheme.colorScheme.outline)
                ) {
                    Column(modifier = Modifier.padding(5.dp)) {
                        Row(
                            modifier = Modifier.padding(vertical = 5.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                painter = painterResource(id = DrawableResourceIcon(MyIcons.AppIcon).id),
                                contentDescription = null,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = it.name,
                                style = MaterialTheme.typography.titleSmall,
                            )
                        }

                        Text(
                            modifier = Modifier.padding(vertical = 5.dp),
                            text = it.description,
                            style = MaterialTheme.typography.bodySmall, maxLines = 2,
                        )

                        Row(
                            modifier = Modifier.padding(vertical = 5.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            ImageTextContent(
                                modifier = Modifier.padding(vertical = 5.dp),
                                icon = {
                                    Icon(
                                        imageVector = ImageVectorIcon(MyIcons.Star).imageVector,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .clip(CircleShape)
                                            .size(15.dp)
                                    )
                                },
                                text = {
                                    Text(
                                        text = it.star,
                                        style = MaterialTheme.typography.labelLarge,
                                    )
                                }
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            ImageTextContent(
                                modifier = Modifier.padding(vertical = 5.dp),
                                icon = {
                                    Icon(
                                        painter = painterResource(id = DrawableResourceIcon(MyIcons.AppIcon).id),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .clip(CircleShape)
                                            .size(10.dp)
                                    )
                                },
                                text = {
                                    Text(
                                        text = it.language,
                                        style = MaterialTheme.typography.labelLarge,
                                    )
                                }
                            )
                        }
                    }
                }
            }
        )
    }
}

@Composable
fun GitContentItem(
    modifier: Modifier = Modifier,
    icon: @Composable () -> Unit,
    text: @Composable () -> Unit,
    endItem: @Composable () -> Unit,
) {
    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        icon()
        Column(
            modifier = Modifier
                .padding(horizontal = 5.dp)
                .weight(1f)
        ) {
            text()
        }
        endItem()
    }
}

@Composable
fun FooterContent() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        shape = RoundedCornerShape(8),
    ) {
        Column(modifier = Modifier.padding(5.dp)) {
            Text(
                modifier = Modifier
                    .padding(10.dp),
                text = stringResource(id = R.string.txt_more_options),
                style = MaterialTheme.typography.titleMedium,
            )
            moreOptionsList.forEach {
                MoreOptionsComp(it)
            }
        }
    }
}

@Composable
fun MoreOptionsComp(
    featureList: FeatureList,
) {
    Row(
        modifier = Modifier.padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        when (featureList.listIcon) {
            is ImageVectorIcon -> Icon(
                imageVector = featureList.listIcon.imageVector,
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(6.dp)
            )

            is DrawableResourceIcon -> Icon(
                painter = painterResource(id = featureList.listIcon.id),
                contentDescription = null,
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
            Text(
                text = featureList.name,
                style = MaterialTheme.typography.labelLarge
            )
        }
        Icon(
            imageVector = MyIcons.KeyboardArrowRight,
            contentDescription = null,
            modifier = Modifier.padding(4.dp)
        )
    }
}