package com.khalidtouch.chatme.ui.app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import com.khalidtouch.chatme.core.designsystem.components.CMBackground
import com.khalidtouch.chatme.navigation.CMNavHost

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CMApp(
    windowSizeClass: WindowSizeClass,
    appState: CMAppState = rememberCMAppState(windowSizeClass = windowSizeClass),
) {
    CMBackground {
        Scaffold(
            modifier = Modifier
                .semantics { testTagsAsResourceId = true },
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface,
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
            topBar = {

            },
            content = { padding ->
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(padding)) {
                    CMNavHost(navController = appState.navController)
                }
            }
        )
    }
}