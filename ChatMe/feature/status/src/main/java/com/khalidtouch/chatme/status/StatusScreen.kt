package com.khalidtouch.chatme.status

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.khalidtouch.chatme.core.designsystem.components.CMFabButton
import com.khalidtouch.chatme.core.designsystem.icons.CMIcons
import com.khalidtouch.chatme.core.ui.MainTabViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatusScreen(
    mainTabViewModel: MainTabViewModel = hiltViewModel<MainTabViewModel>()
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .draggable(
                state = mainTabViewModel.dragState.value!!,
                orientation = Orientation.Horizontal,
                onDragStarted = {},
                onDragStopped = {
                    mainTabViewModel.updateTabIndexBasedOnSwipe()
                }
            )
    ) {
        Scaffold(
            floatingActionButton = {
                CMFabButton {
                    Icon(
                        painter = painterResource(id = CMIcons.Camera2),
                        contentDescription = stringResource(id = R.string.use_camera)
                    )
                }
            },
            content = { padding ->
                StatusScreen(modifier = Modifier.padding(padding))
            }
        )
    }
}


@Composable
private fun StatusScreen(
    modifier: Modifier = Modifier,
){
    Text(
        text = "this is the status screen"
    )
}