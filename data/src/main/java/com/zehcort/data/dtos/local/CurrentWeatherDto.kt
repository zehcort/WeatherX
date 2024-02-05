package com.zehcort.data.dtos.local

import com.zehcort.data.entities.local.CurrentWeather as CurrentWeatherEntity
import com.zehcort.domain.models.CurrentWeather as CurrentWeatherDomain

fun CurrentWeatherEntity.toDomain(): CurrentWeatherDomain = CurrentWeatherDomain(
    weatherCategory = weatherCategory,
    weatherDescription = weatherDescription,
    icon = icon,
    temperature = temperature,
    feelsLike = feelsLike,
    tempMin = tempMin,
    tempMax = tempMax,
    pressure = pressure,
    humidity = humidity,
    cloudiness = cloudiness,
    countryCode = countryCode,
    cityName = cityName
)

fun CurrentWeatherDomain.toLocalEntity(): CurrentWeatherEntity = CurrentWeatherEntity(
    id = 0,
    weatherCategory = weatherCategory,
    weatherDescription = weatherDescription,
    icon = icon,
    temperature = temperature,
    feelsLike = feelsLike,
    tempMin = tempMin,
    tempMax = tempMax,
    pressure = pressure,
    humidity = humidity,
    cloudiness = cloudiness,
    countryCode = countryCode,
    cityName = cityName
)