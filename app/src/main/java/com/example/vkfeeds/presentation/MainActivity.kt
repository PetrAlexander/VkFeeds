package com.example.vkfeeds.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.vkfeeds.navigation.AppNavGraph
import com.example.vkfeeds.navigation.NavigationItem
import com.example.vkfeeds.navigation.rememberNavigationState
import com.example.vkfeeds.presentation.favourite.Favourite
import com.example.vkfeeds.presentation.news.NewsScreen
import com.example.vkfeeds.presentation.news.PostViewModel
import com.example.vkfeeds.presentation.profile.Profile
import com.example.vkfeeds.presentation.theme.VkFeedsTheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<PostViewModel>()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VkFeedsTheme {
                val navigationState = rememberNavigationState()
                Scaffold(
                    bottomBar = {
                        val backStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
                        val currentRoute = backStackEntry?.destination?.route
                        NavigationBar {
                            val navItems = listOf(
                                NavigationItem.News,
                                NavigationItem.Favourite,
                                NavigationItem.Profile
                            )
                            navItems.forEach { navItem ->
                                NavigationBarItem(
                                    selected = currentRoute == navItem.screen.route,
                                    onClick = { navigationState.navigateTo(navItem.screen.route) },
                                    icon = {
                                        Icon(
                                            imageVector = navItem.imageVector,
                                            contentDescription = null
                                        )
                                    },
                                    label = { Text(text = getString(navItem.title)) },
                                    colors = NavigationBarItemDefaults.colors(
                                        selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                                        unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                                    )
                                )
                            }
                        }
                    }
                ) {
                    AppNavGraph(
                        navHostController = navigationState.navHostController,
                        news = { NewsScreen(viewModel = viewModel) },
                        profile = { Profile() },
                        favourite = { Favourite() }
                    )
                }
            }
        }
    }
}