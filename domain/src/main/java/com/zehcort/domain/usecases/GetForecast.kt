package com.zehcort.domain.usecases

import com.zehcort.domain.models.Forecast
import com.zehcort.domain.repositories.WeatherRepository
import com.zehcort.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetForecast(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(latitude: Double, longitude: Double): Flow<Resource<Forecast>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.getForecast(latitude = latitude, longitude = longitude)
            emit(Resource.Success(response))
        } catch (ex: Exception) {
            emit(Resource.Error(message = ex.message!!, stacktrace = ex.stackTrace))
        }
    }
}