package com.example.stockexplorer.feature.watchlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.stockexplorer.core.data.repository.watchlist.MockWatchlistRepositoryImpl
import com.example.stockexplorer.core.domain.GetWatchlistUseCase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WatchlistScreen(
    viewModel: WatchlistViewModel = WatchlistViewModel(
        GetWatchlistUseCase(
            MockWatchlistRepositoryImpl()
        )
    )
) {
    val screenState by viewModel.watchlist.observeAsState(initial = WatchlistScreenState(emptyList()))

    Scaffold(
        topBar = {}
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding))
    }
}

@Preview(showBackground = true)
@Composable
fun WatchlistScreenPreview() {
    WatchlistScreen()
}