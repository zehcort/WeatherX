package com.zehcort.domain.repositories

import com.zehcort.domain.models.CurrentWeather
import com.zehcort.domain.models.Forecast

interface WeatherRepository {
    suspend fun getCurrentWeather(latitude: Double, longitude: Double): CurrentWeather
    suspend fun getForecast(latitude: Double, longitude: Double): Forecast
}