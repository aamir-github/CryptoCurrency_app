package com.example.expcryptocurrency.domain.use_case.get_coin

import com.example.expcryptocurrency.common.Resource
import com.example.expcryptocurrency.data.remote.dto.toCoin
import com.example.expcryptocurrency.data.remote.dto.toCoinDetail
import com.example.expcryptocurrency.domain.model.Coin
import com.example.expcryptocurrency.domain.model.CoinDetail
import com.example.expcryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String) : Flow<Resource<CoinDetail>> = flow {

        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Unable to reach server, check your internet connection"))
        }
    }
}