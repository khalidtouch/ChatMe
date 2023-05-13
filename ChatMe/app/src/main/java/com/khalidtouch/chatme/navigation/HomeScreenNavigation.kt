package com.khalidtouch.chatme.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.khalidtouch.chatme.ui.screens.HomeScreen

const val homeScreenNavigationRoute = "homeScreenNavigationRoute"


fun NavGraphBuilder.homeScreen(
    onSelectContact: () -> Unit,
) {
    composable(route = homeScreenNavigationRoute) {
        HomeScreen(
            onSelectContact = onSelectContact,
        )
    }
}

fun NavController.navigateToHomeScreen(navOptions: NavOptions? = null) {
    this.navigate(homeScreenNavigationRoute, navOptions)
}