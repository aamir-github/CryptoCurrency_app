package com.example.expcryptocurrency.presentation.coin_list

import com.example.expcryptocurrency.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
