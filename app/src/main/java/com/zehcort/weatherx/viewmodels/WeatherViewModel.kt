package com.zehcort.weatherx.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zehcort.domain.usecases.GetCurrentWeather
import com.zehcort.domain.usecases.GetForecast
import com.zehcort.domain.utils.Resource
import com.zehcort.weatherx.states.ForecastUiState
import com.zehcort.weatherx.states.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getCurrentWeather: GetCurrentWeather,
    private val getForecast: GetForecast
) : ViewModel() {
    private val _homeUiState = mutableStateOf(HomeUiState())
    val homeUiState: State<HomeUiState> = _homeUiState

    private val _forecastUiState = mutableStateOf(ForecastUiState())
    val forecastUiState: State<ForecastUiState> = _forecastUiState

    fun fetchCurrentWeather(latitude: Double, longitude: Double) {
        viewModelScope.launch {
            getCurrentWeather(latitude = latitude, longitude = longitude).collect { result ->
                when (result) {
                    is Resource.Error -> _homeUiState.value = homeUiState.value.copy(
                        isLoading = false,
                        errorMessage = result.message
                    )

                    is Resource.Loading -> _homeUiState.value = homeUiState.value.copy(
                        isLoading = true
                    )

                    is Resource.Success -> _homeUiState.value = homeUiState.value.copy(
                        isLoading = false,
                        currentWeather = result.data
                    )
                }
            }
        }
    }

    fun fetchForecast(latitude: Double, longitude: Double) {
        viewModelScope.launch {
            getForecast(latitude = latitude, longitude = longitude).collect { result ->
                when (result) {
                    is Resource.Error -> _forecastUiState.value = forecastUiState.value.copy(
                        isLoading = false,
                        errorMessage = result.message
                    )

                    is Resource.Loading -> _forecastUiState.value = forecastUiState.value.copy(
                        isLoading = true
                    )

                    is Resource.Success -> _forecastUiState.value = forecastUiState.value.copy(
                        isLoading = false,
                        forecast = result.data
                    )
                }
            }
        }
    }
}