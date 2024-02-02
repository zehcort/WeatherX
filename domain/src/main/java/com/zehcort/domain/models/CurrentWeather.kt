package com.zehcort.domain.models

data class CurrentWeather(
    val weatherCategory: String,
    val weatherDescription: String,
    val icon: String,
    val temperature: Float,
    val feelsLike: Float,
    val tempMin: Float,
    val tempMax: Float,
    val pressure: Int,
    val humidity: Int,
    val cloudiness: Int,
    val countryCode: String,
    val cityName: String
)