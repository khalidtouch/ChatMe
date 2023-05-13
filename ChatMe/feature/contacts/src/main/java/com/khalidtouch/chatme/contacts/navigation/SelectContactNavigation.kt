package com.khalidtouch.chatme.contacts.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.google.accompanist.navigation.animation.composable
import com.khalidtouch.chatme.contacts.SelectContactScreen

const val selectContactNavigationRoute = "SelectContactNavigationRoute"


fun NavController.navigateToSelectContacts(navOptions: NavOptions? = null) {
    this.navigate(selectContactNavigationRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.selectContactScreen(
    onBack: () -> Unit,
    onMoreOptions: () -> Unit,
    onSearchContacts: () -> Unit,
) {
    composable(
        route = selectContactNavigationRoute,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { 1800 }
            )
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -1800 }
            )
        }
    ) {
        SelectContactScreen(
            onBack = onBack,
            onMoreOptions = onMoreOptions,
            onSearchContacts = onSearchContacts,
        )
    }
}