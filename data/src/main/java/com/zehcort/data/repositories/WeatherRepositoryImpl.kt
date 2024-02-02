package com.zehcort.data.repositories

import com.zehcort.data.datasources.remote.api.ow.WeatherApi
import com.zehcort.data.dtos.toDomain
import com.zehcort.domain.models.CurrentWeather
import com.zehcort.domain.repositories.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val owWeatherApi: WeatherApi
) : WeatherRepository {
    override suspend fun getCurrentWeather(latitude: Double, longitude: Double): CurrentWeather =
        owWeatherApi.getCurrentWeather(latitude = latitude, longitude = longitude).toDomain()
}