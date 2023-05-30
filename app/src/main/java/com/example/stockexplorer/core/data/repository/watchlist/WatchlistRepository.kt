package com.example.stockexplorer.core.data.repository.watchlist

import com.example.stockexplorer.core.data.model.Watchlist

interface WatchlistRepository {
    // todo: 暫時使用 Entity 當作 model，如果有接真實資料，在改為 WatchlistDTO
    suspend fun getWatchlist(): List<Watchlist>
}