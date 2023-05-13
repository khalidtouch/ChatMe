package com.khalidtouch.chatme.contacts.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.khalidtouch.chatme.contacts.SelectContactScreen

const val selectContactNavigationRoute = "SelectContactNavigationRoute"


fun NavController.navigateToSelectContacts(navOptions: NavOptions? = null) {
    this.navigate(selectContactNavigationRoute, navOptions)
}

fun NavGraphBuilder.selectContactScreen(
    onBack: () -> Unit,
    onMoreOptions: () -> Unit,
    onSearchContacts: () -> Unit,
) {
    composable(route = selectContactNavigationRoute) {
        SelectContactScreen(
            onBack = onBack,
            onMoreOptions = onMoreOptions,
            onSearchContacts = onSearchContacts,
        )
    }
}