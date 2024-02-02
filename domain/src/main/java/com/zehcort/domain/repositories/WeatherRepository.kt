package com.zehcort.domain.repositories

import com.zehcort.domain.models.CurrentWeather

interface WeatherRepository {
    suspend fun getCurrentWeather(latitude: Double, longitude: Double): CurrentWeather
}