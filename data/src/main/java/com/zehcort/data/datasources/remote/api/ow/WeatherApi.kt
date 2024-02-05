package com.zehcort.data.datasources.remote.api.ow

import com.zehcort.data.entities.remote.ow.CurrentWeather
import com.zehcort.data.entities.remote.ow.Forecast
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET(value = Constants.OW_CURRENT_WEATHER)
    suspend fun getCurrentWeather(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double
    ): CurrentWeather

    @GET(value = Constants.OW_FORECAST)
    suspend fun getForecast(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double
    ): Forecast
}