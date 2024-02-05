package com.zehcort.data.repositories

import com.zehcort.data.datasources.local.daos.CurrentWeatherDao
import com.zehcort.data.datasources.remote.api.ow.WeatherApi
import com.zehcort.data.dtos.local.toDomain
import com.zehcort.data.dtos.local.toLocalEntity
import com.zehcort.data.dtos.remote.toDomain
import com.zehcort.domain.models.CurrentWeather
import com.zehcort.domain.repositories.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val owWeatherApi: WeatherApi,
    private val currentWeatherDao: CurrentWeatherDao
) : WeatherRepository {
    override suspend fun getCurrentWeather(latitude: Double, longitude: Double): CurrentWeather {
        val localData = currentWeatherDao.getLastRecord()

        return if (localData == null) {
            val remoteResponse = owWeatherApi.getCurrentWeather(latitude = latitude, longitude = longitude)
                .toDomain()

            currentWeatherDao.saveRecord(remoteResponse.toLocalEntity())

            remoteResponse
        } else {
            localData.toDomain()
        }
    }
}