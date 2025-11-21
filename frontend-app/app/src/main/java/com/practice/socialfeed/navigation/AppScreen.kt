package com.practice.socialfeed.navigation

sealed class AppScreen(val route: String) {
    object Login : AppScreen("login")
    object Feed : AppScreen("feed")
    object AddPost : AppScreen("add_post")
}