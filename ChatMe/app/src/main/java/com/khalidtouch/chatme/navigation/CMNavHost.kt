package com.khalidtouch.chatme.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun CMNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = homeScreenNavigationRoute
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        homeScreen()
        /*todo: add screens here ...*/
    }
}