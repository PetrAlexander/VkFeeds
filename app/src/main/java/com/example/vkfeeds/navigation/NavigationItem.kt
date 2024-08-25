package com.example.vkfeeds.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.vkfeeds.R

sealed class NavigationItem(
    val screen: Screen,
    val imageVector: ImageVector,
    val title: Int
) {
    data object News : NavigationItem(
        Screen.News,
        Icons.Rounded.Home,
        R.string.news,
    )

    data object Favourite : NavigationItem(
        Screen.Favourite,
        Icons.Rounded.FavoriteBorder,
        R.string.favourite,
    )

    data object Profile : NavigationItem(
        Screen.Profile,
        Icons.Rounded.Person,
        R.string.profile,
    )
}