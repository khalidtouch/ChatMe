package com.khalidtouch.chatme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.khalidtouch.chatme.core.designsystem.theme.CMTheme
import com.khalidtouch.chatme.ui.app.CMApp
import com.khalidtouch.chatme.ui.theme.ChatMeTheme
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CMTheme(
                darkTheme = true,
                androidTheme = true,
                disableDynamicTheming = true,
            ) {
                CMApp(windowSizeClass = calculateWindowSizeClass(activity = this))
            }
        }
    }
}