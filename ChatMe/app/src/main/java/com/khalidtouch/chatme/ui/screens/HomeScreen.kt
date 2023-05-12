package com.khalidtouch.chatme.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.khalidtouch.chatme.core.designsystem.components.CMTab
import com.khalidtouch.chatme.core.designsystem.components.CMTabRow
import com.khalidtouch.chatme.core.ui.MainTabViewModel


@Composable
internal fun HomeScreen(
    mainTabViewModel: MainTabViewModel = hiltViewModel<MainTabViewModel>()
) {
    val selectedTabIndex = mainTabViewModel.selectedTabIndex.observeAsState()

    Column(
        modifier = Modifier.fillMaxWidth()
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
            /*todo: add screens here */
            0 -> Text("0", modifier = Modifier.fillMaxSize())
            1 -> Text("1", modifier = Modifier.fillMaxSize())
            2 -> Text("2", modifier = Modifier.fillMaxSize())
        }
    }

}