package com.zehcort.weatherx.navigation

sealed class Route(val route: String) {
    data object Home : Route("Home")
    data object Forecast : Route("Forecast")
}