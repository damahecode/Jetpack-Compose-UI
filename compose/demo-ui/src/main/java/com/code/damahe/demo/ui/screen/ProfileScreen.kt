package com.code.damahe.demo.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.code.damahe.demo.ui.model.FeaturedList
import com.code.damahe.demo.ui.model.ImageTextList
import com.code.damahe.demo.ui.model.ProfilePopularList
import com.code.damahe.res.R
import com.code.damahe.res.icon.DCodeIcon.ImageVectorIcon
import com.code.damahe.res.icon.DCodeIcon.DrawableResourceIcon
import com.code.damahe.res.icon.MyIcons

const val displayName = "Damahe Code"
const val username = "damahecode"
const val my_description = "Passionate developer creating innovative solutions with a love for technology. Solving problems, learning and building applications that drive positive change"
val profilePopularList = listOf(
    ProfilePopularList("Leaf-Explorer", "File Manager, File Sharing & Music Player App for Android", "13", "Kotlin"),
    ProfilePopularList("Material-Theme", "A Material Design-based Theme Management System for Android Jetpack Compose.", "2", "Kotlin"),
    ProfilePopularList("Leaf-Music-Player", "Music player for Android\n", "1", "Kotlin"),
    ProfilePopularList("Chat-App", "A Chat App for Android using Firebase\n", "1", "Kotlin"),
    ProfilePopularList("Jetpack-Compose-UI", "A Collection on all Jetpack compose UI Layouts and Demo screens to see it's potential", "1", "Kotlin"),
    ProfilePopularList("Weather", "A demo implementation of Weather API in Android App.", "1", "Kotlin")
)
val imageTextList = listOf(
    ImageTextList(ImageVectorIcon(MyIcons.Location), "Bharat/India"),
    ImageTextList(ImageVectorIcon(MyIcons.Account), "100 followers"),
    ImageTextList(ImageVectorIcon(MyIcons.Email), "damahecode@gmail.com"),
)
val moreOptionsList = listOf(
    FeaturedList("Edit Profile", ImageVectorIcon(MyIcons.Edit), "", ""),
    FeaturedList("Manage Account", ImageVectorIcon(MyIcons.Account), "", ""),
    FeaturedList("Privacy Policy", DrawableResourceIcon(MyIcons.Policy), "", ""),
    FeaturedList("About", ImageVectorIcon(MyIcons.Info), "", ""),
    FeaturedList("Help & Feedback", DrawableResourceIcon(MyIcons.Android_Head), "", ""),
    FeaturedList("Share '$displayName'", ImageVectorIcon(MyIcons.Share), "", ""),
)

@OptIn(
    ExperimentalMaterial3Api::class
)
@Composable
fun ProfileScreen(onGoBack: () -> Unit) {

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
        contentWindowInsets = WindowInsets(0),
        topBar = {
            TopAppBar(
                scrollBehavior = scrollBehavior,
                title = {
                    Text(text = stringResource(id = R.string.profile))
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
                    IconButton(onClick = {}) {
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
        Box(
            Modifier
                .fillMaxSize()
                .padding(padding)
                .consumeWindowInsets(padding)
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(
                        WindowInsetsSides.Horizontal,
                    ),
                ),
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(5.dp)
                    .systemBarsPadding()
                    .verticalScroll(rememberScrollState())
            ) {
                TopProfileLayout()
                MainProfileContent()
                FooterContent()
            }
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
            .padding(top = 12.dp, bottom = 12.dp),
    ) {
        Column(modifier = Modifier.padding(5.dp)) {
            Text(
                modifier = Modifier
                    .padding(start = 12.dp, bottom = 5.dp),
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
                        text = "10"
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
                        text = "20"
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
        modifier = Modifier.fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp),
        shape = RoundedCornerShape(8),
    ) {
        Column(modifier = Modifier.padding(5.dp)) {
            Text(
                modifier = Modifier.fillMaxWidth()
                    .padding(bottom = 10.dp),
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.more_options),
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
    featureList: FeaturedList,
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