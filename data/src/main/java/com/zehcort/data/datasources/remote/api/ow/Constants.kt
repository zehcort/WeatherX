package com.zehcort.data.datasources.remote.api.ow

object Constants {
    private const val OW_API_KEY = "b1b7f499974749c810fe86f351711a94"
    const val OW_BASE_URL = "https://api.openweathermap.org/"
    const val OW_CURRENT_WEATHER = "data/2.5/weather?appid=$OW_API_KEY&units=metric"
    const val OW_FORECAST = "data/2.5/forecast?appid=$OW_API_KEY&units=metric"
    const val OW_ICON_URL = "https://openweathermap.org/img/wn/%s@2x.png"
}