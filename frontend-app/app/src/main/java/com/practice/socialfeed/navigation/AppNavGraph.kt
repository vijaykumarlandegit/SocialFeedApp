package com.practice.socialfeed.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.practice.socialfeed.presentation.add.AddPostScreen
import com.practice.socialfeed.presentation.add.AddPostViewModel
import com.practice.socialfeed.presentation.feed.FeedScreen
import com.practice.socialfeed.presentation.feed.FeedViewModel
import com.practice.socialfeed.presentation.login.LoginScreen
import com.practice.socialfeed.presentation.login.LoginViewModel
import com.practice.socialfeed.ui.auth.LoginScreen
import com.practice.socialfeed.ui.feed.FeedScreen
import com.practice.socialfeed.ui.viewmodel.AddPostViewModel
import com.practice.socialfeed.ui.viewmodel.FeedViewModel
import com.practice.socialfeed.ui.viewmodel.LoginViewModel

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppScreen.Login.route
    ) {
        composable(AppScreen.Login.route) {
            val viewModel = LoginViewModel()
            LoginScreen(
                viewModel = viewModel,
                onLoginSuccess = {
                    navController.navigate(AppScreen.Feed.route) {
                        popUpTo(AppScreen.Login.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(AppScreen.Feed.route) {
            val viewModel: FeedViewModel = hiltViewModel()
            FeedScreen(
                viewModel = viewModel,
                onAddPostClick = {
                    navController.navigate(AppScreen.AddPost.route)
                }
            )
        }

        composable(AppScreen.AddPost.route) {
            val viewModel: AddPostViewModel = hiltViewModel()
            AddPostScreen(
                viewModel = viewModel,
                onPostSaved = {
                    navController.popBackStack()
                }
            )
        }
    }
}
