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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.zehcort.weatherx.viewmodels.WeatherViewModel
import com.zehcort.weatherx.views.composables.components.LoadingIndicator

@Composable
fun HomeScreen(
    viewModel: WeatherViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val errorMessage = state.errorMessage

    if (state.isLoading) {
        Text(text = "Loading...")
    } else {
        if (errorMessage.isNullOrEmpty()) {
            state.currentWeather?.let { currentWeather ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = currentWeather.temperature.toString(),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )

                    Text(
                        modifier = Modifier.padding(top = 16.dp),
                        text = currentWeather.feelsLike.toString(),
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White
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
        viewModel.fetchCurrentWeather(latitude = 3.4535748, longitude = -76.537262)
    }
}