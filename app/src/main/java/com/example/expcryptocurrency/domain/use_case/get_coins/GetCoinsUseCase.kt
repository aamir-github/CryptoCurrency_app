package com.example.expcryptocurrency.domain.use_case.get_coins

import com.example.expcryptocurrency.common.Resource
import com.example.expcryptocurrency.data.remote.dto.toCoin
import com.example.expcryptocurrency.domain.model.Coin
import com.example.expcryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {

        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Unable to reach server, check your internet connection"))
        }
    }
}