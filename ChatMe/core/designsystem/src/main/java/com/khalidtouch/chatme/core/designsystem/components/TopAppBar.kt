package com.khalidtouch.chatme.core.designsystem.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.khalidtouch.chatme.core.designsystem.icons.CMIcons
import com.khalidtouch.chatme.core.designsystem.R as CMResource


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CMMainTopAppBar(
    modifier: Modifier = Modifier,
    @StringRes titleRes: Int,
    @DrawableRes moreIconRes: Int = CMIcons.More,
    @DrawableRes searchIconRes: Int = CMIcons.Search,
    @DrawableRes cameraIconRes: Int = CMIcons.Camera,
    onSearchChats: () -> Unit = {},
    onTakePhoto: () -> Unit = {},
    onMoreOptions: () -> Unit = {},
    colors: TopAppBarColors = TopAppBarDefaults.smallTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.primary,
        titleContentColor = MaterialTheme.colorScheme.onPrimary,
        actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
        scrolledContainerColor = MaterialTheme.colorScheme.primary
    ),
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(id = titleRes),
            )
        },
        actions = {
            IconButton(onClick = onTakePhoto) {
                Icon(
                    painter = painterResource(id = cameraIconRes),
                    contentDescription = stringResource(id = CMResource.string.take_photo)
                )
            }

            IconButton(onClick = onSearchChats) {
                Icon(
                    painter = painterResource(id = searchIconRes),
                    contentDescription = stringResource(id = CMResource.string.search_chats)
                )
            }

            IconButton(onClick = onMoreOptions) {
                Icon(
                    painter = painterResource(id = moreIconRes),
                    contentDescription = stringResource(id = CMResource.string.more_options)
                )
            }
        },
        colors = colors,
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CMSecondaryTopAppBar(
    modifier: Modifier = Modifier,
    @StringRes titleRes: Int,
    @DrawableRes navIconRes: Int = CMIcons.Back,
    onBack: () -> Unit = {},
    colors: TopAppBarColors = TopAppBarDefaults.smallTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        titleContentColor = MaterialTheme.colorScheme.onPrimary,
        actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
        scrolledContainerColor = MaterialTheme.colorScheme.primary
    ),
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = stringResource(id = titleRes))
        },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(
                    painter = painterResource(id = navIconRes),
                    contentDescription = stringResource(id = CMResource.string.go_back)
                )
            }
        },
        colors = colors,
    )
}