package com.khalidtouch.chatme.contacts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.khalidtouch.chatme.core.designsystem.components.SelectContactTopBar
import com.khalidtouch.chatme.core.designsystem.icons.CMIcons
import com.khalidtouch.chatme.core.ui.SelectContactExtra


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectContactScreen(
    onBack: () -> Unit,
    onMoreOptions: () -> Unit,
    onSearchContacts: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            val headerTextStyle = MaterialTheme.typography.titleMedium
            val subtitleTextStyle = MaterialTheme.typography.titleSmall

            SelectContactTopBar(
                title = {
                    Column(modifier = Modifier) {
                        ProvideTextStyle(headerTextStyle) {
                            Text(
                                text = stringResource(id = R.string.select_contact)
                            )
                        }
                        ProvideTextStyle(subtitleTextStyle) {
                            Text(
                                text = "899 Contacts"
                            )
                        }
                    }
                },
                onBack = onBack,
                onMoreOptions = onMoreOptions,
                onSearchContacts = onSearchContacts
            )
        },
        content = { padding ->
            SelectContactScreenContent(
                modifier = Modifier.padding(padding)
            )
        }
    )
}


@Composable
fun SelectContactScreenContent(
    modifier: Modifier = Modifier,
    onCreateNewGroup: () -> Unit = {},
    onCreateNewContact: () -> Unit = {},
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
    ) {
        item {
            val headerStyle = MaterialTheme.typography.titleMedium.copy(
                color = Color.Black
            )

            Box(modifier = Modifier.padding(top = 8.dp)) {
                SelectContactExtra(
                    icon = {
                        Icon(
                            painter = painterResource(id = CMIcons.Group),
                            contentDescription = stringResource(id = R.string.create_group)
                        )
                    },
                    onClick = onCreateNewGroup,
                    text = {
                        ProvideTextStyle(headerStyle) {
                            Text(
                                text = stringResource(id = R.string.new_group)
                            )
                        }
                    }
                )
            }

            SelectContactExtra(
                icon = {
                    Icon(
                        painter = painterResource(id = CMIcons.AddContact),
                        contentDescription = stringResource(id = R.string.create_contact)
                    )
                },
                onClick = onCreateNewContact,
                text = {
                    ProvideTextStyle(headerStyle) {
                        Text(
                            text = stringResource(id = R.string.new_contact)
                        )
                    }
                }
            )
        }

        item {
            val smallHeaderStyle = MaterialTheme.typography.titleSmall.copy(
                color = Color.Black
            )
            Box(modifier = Modifier.padding(start = 8.dp, top = 32.dp)) {
                ProvideTextStyle(smallHeaderStyle) {
                    Text(
                        text = stringResource(id = R.string.contacts_on_chat_me),
                    )
                }
            }
        }
    }
}
