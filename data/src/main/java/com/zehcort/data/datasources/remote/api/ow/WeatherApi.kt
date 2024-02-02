package com.zehcort.data.datasources.remote.api.ow

import com.zehcort.data.entities.remote.ow.CurrentWeather
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET(value = Constants.OW_CURRENT_WEATHER)
    suspend fun getCurrentWeather(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double
    ): CurrentWeather
}