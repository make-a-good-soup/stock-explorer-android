package com.example.stockexplorer.core.domain

import com.example.stockexplorer.core.data.model.Watchlist
import com.example.stockexplorer.core.data.repository.watchlist.WatchlistRepository

class GetWatchlistUseCase(private val repository: WatchlistRepository) {

    // todo: 可能需要不同來源的資料組合再一起，建立一個 entity 物件，將所有需要的資料放進去
    // todo: 目前還不確定需要什麼，所以先不建立
    suspend operator fun invoke(): List<Watchlist> = repository.getWatchlist()
}