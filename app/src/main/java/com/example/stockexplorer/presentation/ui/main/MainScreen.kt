package com.example.stockexplorer.presentation.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.stockexplorer.presentation.Screen
import com.example.stockexplorer.presentation.ui.news.NewsScreen
import com.example.stockexplorer.presentation.ui.profile.ProfileScreen
import com.example.stockexplorer.presentation.ui.watchlist.WatchlistScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val selectedItemIndex = remember { mutableStateOf(0) }

    val items = listOf(
        Screen.Watchlist,
        Screen.News,
        Screen.Profile
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, screen ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                Icons.Default.Favorite,
                                contentDescription = null
                            )
                        }, // replace with appropriate icon
                        label = { Text(screen.route) },
                        selected = index == selectedItemIndex.value,
                        onClick = {
                            selectedItemIndex.value = index
                            navController.navigate(screen.route) {
                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
        }
    ) {
        Box(Modifier.padding(it)) {
            NavHost(navController, startDestination = Screen.Watchlist.route) {
                composable(Screen.Watchlist.route) { WatchlistScreen() }
                composable(Screen.News.route) { NewsScreen() }
                composable(Screen.Profile.route) { ProfileScreen() }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    MainScreen()
}