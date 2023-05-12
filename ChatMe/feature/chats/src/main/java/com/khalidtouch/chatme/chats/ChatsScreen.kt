package com.khalidtouch.chatme.chats

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.khalidtouch.chatme.core.ui.MainTabViewModel

@Composable
fun ChatsScreen(
    mainTabViewModel: MainTabViewModel = hiltViewModel<MainTabViewModel>()
) {
    Surface(modifier = Modifier.fillMaxSize()
        .draggable(
            state = mainTabViewModel.dragState.value!!,
            orientation = Orientation.Horizontal,
            onDragStarted = {},
            onDragStopped = {
                mainTabViewModel.updateTabIndexBasedOnSwipe()
            }
        ),
    ){
        Text(
            "this is the chats screen"
        )
    }
}