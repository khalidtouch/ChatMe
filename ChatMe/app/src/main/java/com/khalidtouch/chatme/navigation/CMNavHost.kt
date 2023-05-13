package com.khalidtouch.chatme.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.khalidtouch.chatme.contacts.navigation.navigateToSelectContacts
import com.khalidtouch.chatme.contacts.navigation.selectContactScreen

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
        homeScreen(
            onSelectContact = { navController.navigateToSelectContacts() }
        )
        selectContactScreen(
            onBack = { navController.navigateToHomeScreen() },
            onSearchContacts = {},
            onMoreOptions = {}
        )
        /*todo: add screens here ...*/
    }
}