package com.example.expcryptocurrency.data.repository

import com.example.expcryptocurrency.data.remote.CoinPaprikaApi
import com.example.expcryptocurrency.data.remote.dto.CoinDetailDto
import com.example.expcryptocurrency.data.remote.dto.CoinDto
import com.example.expcryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}