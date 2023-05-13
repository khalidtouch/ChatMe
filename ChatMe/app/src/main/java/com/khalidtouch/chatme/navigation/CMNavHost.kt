package com.khalidtouch.chatme.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.khalidtouch.chatme.contacts.navigation.navigateToSelectContacts
import com.khalidtouch.chatme.contacts.navigation.selectContactScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CMNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = homeScreenNavigationRoute
) {
    AnimatedNavHost(
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