package com.example.stockexplorer.presentation.ui.watchlist

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WatchlistScreen() {
    // TODO: Implement WatchlistScreen
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("追蹤清單") }
            )
        }
    ) { innerPadding ->
        Text(
            text = "Hello, Jetpack Compose!",
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WatchlistScreenPreview() {
    WatchlistScreen()
}