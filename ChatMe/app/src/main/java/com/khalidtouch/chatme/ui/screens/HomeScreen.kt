package com.khalidtouch.chatme.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.khalidtouch.chatme.R
import com.khalidtouch.chatme.calls.CallsScreen
import com.khalidtouch.chatme.chats.ChatsScreen
import com.khalidtouch.chatme.core.designsystem.components.CMMainTopAppBar
import com.khalidtouch.chatme.core.designsystem.components.CMTab
import com.khalidtouch.chatme.core.designsystem.components.CMTabRow
import com.khalidtouch.chatme.core.ui.MainTabViewModel
import com.khalidtouch.chatme.status.StatusScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HomeScreen(
    mainTabViewModel: MainTabViewModel = hiltViewModel<MainTabViewModel>(),
    onSelectContact: () -> Unit = {},
) {
    Scaffold(
        topBar = {
            CMMainTopAppBar(
                titleRes = R.string.app_name,
                onSearchChats = {},
                onTakePhoto = {},
                onMoreOptions = {}
            )
        },
        content = { padding ->
            val selectedTabIndex = mainTabViewModel.selectedTabIndex.observeAsState()

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padding)
            ) {
                CMTabRow(
                    selectedTabIndex = selectedTabIndex.value!!
                ) {

                    val style = MaterialTheme.typography.labelLarge.copy(
                        textAlign = TextAlign.Center,
                    )

                    mainTabViewModel.Tabs.forEachIndexed { index, mainTab ->
                        CMTab(
                            selected = selectedTabIndex.value!! == index,
                            unreadChats = 26,
                            onClick = { mainTabViewModel.updateTabIndex(index) },
                            tabState = mainTab.state,
                            text = {
                                ProvideTextStyle(value = style) {
                                    Text(
                                        text = mainTab.name,
                                    )
                                }
                            }
                        )
                    }
                }

                when (selectedTabIndex.value!!) {
                    0 -> ChatsScreen(
                        onSelectContact = onSelectContact,
                    )

                    1 -> StatusScreen()
                    2 -> CallsScreen()
                }
            }
        }
    )

}