package com.example.stockexplorer.presentation.ui.news

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
fun NewsScreen() {
    // TODO: Implement NewsScreen
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("最新消息") }
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
private fun NewsScreenPreview() {
    NewsScreen()
}