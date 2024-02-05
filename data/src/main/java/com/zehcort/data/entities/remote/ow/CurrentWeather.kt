package com.zehcort.data.entities.remote.ow

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrentWeather(
    @Json(name = "coord")
    val coord: Coord? = null,
    @Json(name = "weather")
    val weather: List<Weather> = listOf(),
    @Json(name = "base")
    val base: String? = null,
    @Json(name = "main")
    val main: Main? = null,
    @Json(name = "visibility")
    val visibility: Int? = null,
    @Json(name = "wind")
    val wind: Wind? = null,
    @Json(name = "clouds")
    val clouds: Clouds? = null,
    @Json(name = "dt")
    val dt: Int? = null,
    @Json(name = "sys")
    val sys: Sys? = null,
    @Json(name = "timezone")
    val timezone: Int? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "cod")
    val cod: Int? = null
)

@JsonClass(generateAdapter = true)
data class Coord(
    @Json(name = "lon")
    val lon: Double? = null,
    @Json(name = "lat")
    val lat: Double? = null
)

@JsonClass(generateAdapter = true)
data class Weather(
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "main")
    val main: String? = null,
    @Json(name = "description")
    val description: String? = null,
    @Json(name = "icon")
    val icon: String? = null
)

@JsonClass(generateAdapter = true)
data class Main(
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
    @Json(name = "humidity")
    val humidity: Int? = null
)

@JsonClass(generateAdapter = true)
data class Wind(
    @Json(name = "speed")
    val speed: Float? = null,
    @Json(name = "deg")
    val deg: Int? = null
)

@JsonClass(generateAdapter = true)
data class Clouds(
    @Json(name = "all")
    val all: Int? = null
)

@JsonClass(generateAdapter = true)
data class Sys(
    @Json(name = "type")
    val type: Int? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "country")
    val country: String? = null,
    @Json(name = "sunrise")
    val sunrise: Int? = null,
    @Json(name = "sunset")
    val sunset: Int? = null
)