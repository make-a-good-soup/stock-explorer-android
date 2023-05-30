package com.example.stockexplorer.core.data.repository.watchlist

import com.example.stockexplorer.core.data.model.Watchlist

class MockWatchlistRepositoryImpl : WatchlistRepository {
    override suspend fun getWatchlist(): List<Watchlist> {
        TODO("Not yet implemented") //todo: 假資料
    }
}