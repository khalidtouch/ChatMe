package com.khalidtouch.chatme.contacts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.khalidtouch.chatme.core.designsystem.components.SelectContactTopBar


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
fun SelectContactScreenContent(modifier: Modifier = Modifier) {
    Text(
        text = "this is the contact screen"
    )
}