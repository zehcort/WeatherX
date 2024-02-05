package com.zehcort.weatherx.states

import com.zehcort.domain.models.Forecast

data class ForecastUiState(
    var isLoading: Boolean = true,
    var errorMessage: String? = null,
    var forecast: Forecast? = null
)