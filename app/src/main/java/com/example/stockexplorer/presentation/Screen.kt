package com.example.stockexplorer.presentation

sealed class Screen(val route: String) {
    object Watchlist : Screen("watchlist")
    object News : Screen("news")
    object Profile : Screen("profile")
}