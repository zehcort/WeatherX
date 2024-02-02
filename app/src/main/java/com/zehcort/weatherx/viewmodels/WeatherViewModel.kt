package com.zehcort.weatherx.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zehcort.domain.usecases.GetCurrentWeather
import com.zehcort.domain.utils.Resource
import com.zehcort.weatherx.states.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getCurrentWeather: GetCurrentWeather
) : ViewModel() {
    private val _state = mutableStateOf(HomeUiState())
    val state: State<HomeUiState> = _state

    fun fetchCurrentWeather(latitude: Double, longitude: Double) {
        viewModelScope.launch {
            getCurrentWeather(latitude = latitude, longitude = longitude).collect { result ->
                when (result) {
                    is Resource.Error -> _state.value = state.value.copy(
                        isLoading = false,
                        errorMessage = result.message
                    )

                    is Resource.Loading -> _state.value = state.value.copy(
                        isLoading = true
                    )

                    is Resource.Success -> _state.value = state.value.copy(
                        isLoading = false,
                        currentWeather = result.data
                    )
                }
            }
        }
    }
}