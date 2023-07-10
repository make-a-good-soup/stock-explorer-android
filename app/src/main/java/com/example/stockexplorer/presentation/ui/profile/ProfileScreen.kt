package com.example.stockexplorer.presentation.ui.profile

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
fun ProfileScreen() {
    // TODO: Implement ProfileScreen
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("會員") }
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
private fun ProfileScreenPreview() {
    ProfileScreen()
}