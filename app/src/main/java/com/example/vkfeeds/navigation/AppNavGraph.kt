package com.example.vkfeeds.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    news: @Composable () -> Unit,
    profile: @Composable () -> Unit,
    favourite: @Composable () -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.News.route
    ) {
        composable(Screen.News.route) {
            news()
        }
        composable(Screen.Favourite.route) {
            profile()
        }
        composable(Screen.Profile.route) {
            favourite()
        }
    }
}