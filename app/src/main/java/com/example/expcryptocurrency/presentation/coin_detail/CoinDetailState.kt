package com.example.expcryptocurrency.presentation.coin_detail

import com.example.expcryptocurrency.domain.model.Coin
import com.example.expcryptocurrency.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
