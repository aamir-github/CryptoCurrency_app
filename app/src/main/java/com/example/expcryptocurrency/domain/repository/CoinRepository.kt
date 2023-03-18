package com.example.expcryptocurrency.domain.repository

import com.example.expcryptocurrency.data.remote.dto.CoinDetailDto
import com.example.expcryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins() : List<CoinDto>

    suspend fun getCoinById(coinId: String) : CoinDetailDto
}