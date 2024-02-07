package com.zehcort.weatherx.views.composables.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.zehcort.weatherx.viewmodels.WeatherViewModel
import com.zehcort.weatherx.views.composables.components.LoadingIndicator

@Composable
fun ForecastScreen(
    viewModel: WeatherViewModel = hiltViewModel()
) {
    val state = viewModel.forecastUiState.value
    val errorMessage = state.errorMessage

    if (state.isLoading) {
        LoadingIndicator()
    } else {
        if (errorMessage.isNullOrEmpty()) {
            state.forecast?.let { forecast ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = forecast.forecastWeatherList[0].temperature.toString(),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        modifier = Modifier.padding(top = 16.dp),
                        text = forecast.forecastWeatherList[0].feelsLike.toString(),
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = errorMessage,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.fetchForecast(latitude = 3.4535748, longitude = -76.537262)
    }
}