package com.zehcort.data.entities.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CurrentWeather(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "weather_category") val weatherCategory: String,
    @ColumnInfo(name = "weather_description") val weatherDescription: String,
    @ColumnInfo(name = "icon") val icon: String,
    @ColumnInfo(name = "temperature") val temperature: Float,
    @ColumnInfo(name = "feels_like") val feelsLike: Float,
    @ColumnInfo(name = "temp_min") val tempMin: Float,
    @ColumnInfo(name = "temp_max") val tempMax: Float,
    @ColumnInfo(name = "pressure") val pressure: Int,
    @ColumnInfo(name = "humidity") val humidity: Int,
    @ColumnInfo(name = "cloudiness") val cloudiness: Int,
    @ColumnInfo(name = "country_code") val countryCode: String,
    @ColumnInfo(name = "city_name") val cityName: String
)