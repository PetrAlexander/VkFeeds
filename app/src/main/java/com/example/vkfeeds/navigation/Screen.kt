package com.example.vkfeeds.navigation

sealed class Screen(val route: String) {
    data object News: Screen(ROUTE_NEWS)
    data object Profile: Screen(ROUTE_PROFILE)
    data object Favourite: Screen(ROUTE_FAVOURITE)
    companion object {
        private const val ROUTE_NEWS = "news"
        private const val ROUTE_PROFILE = "profile"
        private const val ROUTE_FAVOURITE = "favourite"
    }
}