package com.example.stockexplorer.feature.watchlist

import androidx.compose.runtime.Immutable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stockexplorer.core.data.model.Watchlist
import com.example.stockexplorer.core.domain.GetWatchlistUseCase
import kotlinx.coroutines.launch

class WatchlistViewModel(private val getWatchlistUseCase: GetWatchlistUseCase) : ViewModel() {

    init {
        fetchWatchlist()
    }

    private val _watchlist = MutableLiveData<WatchlistScreenState>()
    val watchlist: LiveData<WatchlistScreenState> = _watchlist

    private fun fetchWatchlist() = viewModelScope.launch {
        val result = getWatchlistUseCase.invoke()
        _watchlist.value = WatchlistScreenState(watchlistGroup = result)
    }
}

@Immutable
data class WatchlistScreenState( // todo: 所有畫面所需要的資料，都放在這裡
    val watchlistGroup: List<Watchlist>
)
