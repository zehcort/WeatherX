package com.zehcort.data.entities.remote.ow

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Forecast(
    @Json(name = "cod")
    val cod: String? = null,
    @Json(name = "message")
    val message: Int? = null,
    @Json(name = "cnt")
    val cnt: Int? = null,
    @Json(name = "list")
    val list: List<ForecastWeather> = listOf(),
    @Json(name = "city")
    val city: City? = null
)

@JsonClass(generateAdapter = true)
data class ForecastWeather(
    @Json(name = "dt")
    val dt: Int? = null,
    @Json(name = "main")
    val main: ForecastMain? = null,
    @Json(name = "weather")
    val weather: List<Weather> = listOf(),
    @Json(name = "clouds")
    val clouds: Clouds? = null,
    @Json(name = "wind")
    val wind: ForecastWind? = null,
    @Json(name = "visibility")
    val visibility: Int? = null,
    @Json(name = "pop")
    val pop: Float? = null,
    @Json(name = "sys")
    val system: ForecastSys? = null,
    @Json(name = "dt_txt")
    val dtTxt: String? = null
)

@JsonClass(generateAdapter = true)
data class ForecastMain(
    @Json(name = "temp")
    val temp: Float? = null,
    @Json(name = "feels_like")
    val feelsLike: Float? = null,
    @Json(name = "temp_min")
    val tempMin: Float? = null,
    @Json(name = "temp_max")
    val tempMax: Float? = null,
    @Json(name = "pressure")
    val pressure: Int? = null,
    @Json(name = "sea_level")
    val seaLevel: Int? = null,
    @Json(name = "grnd_level")
    val grndLevel: Int? = null,
    @Json(name = "humidity")
    val humidity: Int? = null,
    @Json(name = "temp_kf")
    val tempKf: Float? = null
)

@JsonClass(generateAdapter = true)
data class ForecastWind(
    @Json(name = "speed")
    val speed: Float? = null,
    @Json(name = "deg")
    val deg: Int? = null,
    @Json(name = "gust")
    val gust: Float? = null
)

@JsonClass(generateAdapter = true)
data class ForecastSys(
    @Json(name = "pod")
    val pod: String? = null
)

@JsonClass(generateAdapter = true)
data class City(
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "coord")
    val coord: Coord? = null,
    @Json(name = "country")
    val country: String? = null,
    @Json(name = "population")
    val population: Int? = null,
    @Json(name = "timezone")
    val timezone: Int? = null,
    @Json(name = "sunrise")
    val sunrise: Int? = null,
    @Json(name = "sunset")
    val sunset: Int? = null
)