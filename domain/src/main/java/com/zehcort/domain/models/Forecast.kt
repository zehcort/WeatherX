package com.zehcort.domain.models

data class Forecast(
    val cityName: String,
    val countryCode: String,
    val forecastWeatherList: List<ForecastWeather>
)

data class ForecastWeather(
    val weatherCategory: String,
    val weatherDescription: String,
    val icon: String,
    val rainIcon: String,
    val temperature: Float,
    val feelsLike: Float,
    val tempMin: Float,
    val tempMax: Float,
    val pressure: Int,
    val seaLevel: Int,
    val groundLevel: Int,
    val temperatureKf: Float,
    val humidity: Int,
    val cloudiness: Int,
    val precipitationProbability: Int,
    val date: String,
    val time: String
)