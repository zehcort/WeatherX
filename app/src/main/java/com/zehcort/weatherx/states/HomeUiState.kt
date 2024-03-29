package com.zehcort.weatherx.states

import com.zehcort.domain.models.CurrentWeather

data class HomeUiState(
    var isLoading: Boolean = false,
    var errorMessage: String? = null,
    var currentWeather: CurrentWeather? = null
)