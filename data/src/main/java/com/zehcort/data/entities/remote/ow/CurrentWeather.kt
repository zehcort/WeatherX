package com.zehcort.data.entities.remote.ow

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrentWeather(
    @Json(name = "coord")
    val coordinates: Coordinates? = null,
    @Json(name = "weather")
    val weather: ArrayList<Weather> = arrayListOf(),
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
    val system: System? = null,
    @Json(name = "timezone")
    val timezone: Int? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "name")
    val cityName: String? = null,
    @Json(name = "cod")
    val cod: Int? = null
)

@JsonClass(generateAdapter = true)
data class Coordinates(
    @Json(name = "lon")
    val longitude: Double? = null,
    @Json(name = "lat")
    val latitude: Double? = null
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
    var temperature: Float? = null,
    @Json(name = "feels_like")
    var feelsLike: Float? = null,
    @Json(name = "temp_min")
    var tempMin: Float? = null,
    @Json(name = "temp_max")
    var tempMax: Float? = null,
    @Json(name = "pressure")
    var pressure: Int? = null,
    @Json(name = "humidity")
    var humidity: Int? = null
)

@JsonClass(generateAdapter = true)
data class Wind(
    @Json(name = "speed")
    var speed: Float? = null,
    @Json(name = "deg")
    var deg: Int? = null
)

@JsonClass(generateAdapter = true)
data class Clouds(
    @Json(name = "all")
    val all: Int? = null
)

@JsonClass(generateAdapter = true)
data class System(
    @Json(name = "type")
    var type: Int? = null,
    @Json(name = "id")
    var id: Int? = null,
    @Json(name = "country")
    var country: String? = null,
    @Json(name = "sunrise")
    var sunrise: Int? = null,
    @Json(name = "sunset")
    var sunset: Int? = null
)