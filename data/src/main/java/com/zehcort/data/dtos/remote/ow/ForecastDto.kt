package com.zehcort.data.dtos.remote.ow

import com.zehcort.data.datasources.remote.api.ow.Constants
import com.zehcort.data.entities.remote.ow.Forecast as ForecastEntity
import com.zehcort.data.entities.remote.ow.ForecastWeather as ForecastWeatherEntity
import com.zehcort.domain.models.Forecast as ForecastDomain
import com.zehcort.domain.models.ForecastWeather as ForecastWeatherDomain

fun ForecastEntity.toDomain(): ForecastDomain = ForecastDomain(
    cityName = city?.name ?: "",
    countryCode = city?.country ?: "",
    forecastWeatherList = list.map { it.toDomain() }
)

private fun ForecastWeatherEntity.toDomain(): ForecastWeatherDomain = ForecastWeatherDomain(
    weatherCategory = weather[0].main ?: "",
    weatherDescription = weather[0].description ?: "",
    icon = String.format(Constants.OW_ICON_URL, weather[0].icon),
    temperature = main?.temp ?: 0F,
    feelsLike = main?.feelsLike ?: 0F,
    tempMin = main?.tempMin ?: 0F,
    tempMax = main?.tempMax ?: 0F,
    pressure = main?.pressure ?: 0,
    seaLevel = main?.seaLevel ?: 0,
    groundLevel = main?.grndLevel ?: 0,
    temperatureKf = main?.tempKf ?: 0F,
    humidity = main?.humidity ?: 0,
    cloudiness = clouds?.all ?: 0,
    precipitationProbability = pop ?: 0F
)