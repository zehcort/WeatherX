package com.zehcort.data.dtos.remote.ow

import com.zehcort.data.datasources.remote.api.ow.Constants
import com.zehcort.data.entities.remote.ow.CurrentWeather as CurrentWeatherEntity
import com.zehcort.domain.models.CurrentWeather as CurrentWeatherDomain

fun CurrentWeatherEntity.toDomain(): CurrentWeatherDomain = CurrentWeatherDomain(
    weatherCategory = weather[0].main ?: "",
    weatherDescription = weather[0].description ?: "",
    icon = String.format(Constants.OW_ICON_URL, weather[0].icon),
    temperature = main?.temp ?: 0F,
    feelsLike = main?.feelsLike ?: 0F,
    tempMin = main?.tempMin ?: 0F,
    tempMax = main?.tempMax ?: 0F,
    pressure = main?.pressure ?: 0,
    humidity = main?.humidity ?: 0,
    cloudiness = clouds?.all ?: 0,
    countryCode = sys?.country ?: "",
    cityName = name ?: ""
)