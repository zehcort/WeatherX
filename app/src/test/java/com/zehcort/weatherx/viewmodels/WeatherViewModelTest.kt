package com.zehcort.weatherx.viewmodels

import com.zehcort.domain.usecases.GetCurrentWeather
import com.zehcort.domain.usecases.GetForecast
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test

class WeatherViewModelTest {
    private lateinit var weatherViewModel: WeatherViewModel
    private val dispatcher = StandardTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        val getCurrentWeather: GetCurrentWeather = mockk()
        val getForecast: GetForecast = mockk()
        weatherViewModel = WeatherViewModel(getCurrentWeather = getCurrentWeather, getForecast = getForecast)
    }

    @Test
    fun `When fetching current weather, the information is gathered`() {
        weatherViewModel.fetchCurrentWeather(latitude = 3.4591967, longitude = -76.5331969)
        assert(weatherViewModel.homeUiState.value.currentWeather != null)
    }
}