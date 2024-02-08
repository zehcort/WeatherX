package com.zehcort.data.dtos.remote.ow

import com.zehcort.data.datasources.remote.api.ow.Constants
import com.zehcort.data.utils.toDate
import com.zehcort.data.utils.toTime
import kotlin.math.roundToInt
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
    rainIcon = "https://openweathermap.org/img/wn/10d@2x.png",
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
    precipitationProbability = pop?.times(100)?.roundToInt() ?: 0,
    date = dtTxt?.toDate() ?: "",
    time = dtTxt?.toTime() ?: ""
)