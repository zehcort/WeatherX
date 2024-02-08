package com.zehcort.weatherx.views.composables.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.zehcort.domain.models.Forecast
import com.zehcort.weatherx.R
import com.zehcort.weatherx.permissions.LocationPermissionHandler
import com.zehcort.weatherx.states.ForecastUiState
import com.zehcort.weatherx.utils.LocationHelper
import com.zehcort.weatherx.viewmodels.WeatherViewModel
import com.zehcort.weatherx.views.composables.components.ErrorContent
import com.zehcort.weatherx.views.composables.components.LoadingIndicator
import com.zehcort.weatherx.views.composables.components.common.LocationTopBar
import com.zehcort.weatherx.views.composables.components.forecast.WeatherForecastPage

@Composable
fun ForecastScreen(
    modifier: Modifier = Modifier,
    viewModel: WeatherViewModel = hiltViewModel()
) {
    val state = viewModel.forecastUiState.value
    val errorMessage = state.errorMessage

    if (state.isLoading) {
        LoadingIndicator(modifier = modifier)
    } else if (errorMessage.isNullOrEmpty()) {
        LocationPermissionHandler(
            grantedContent = {
                SuccessContent(
                    modifier = modifier,
                    state = viewModel.forecastUiState.value,
                    onFetchData = { latitude, longitude ->
                        viewModel.fetchForecast(
                            latitude = latitude.toDouble(),
                            longitude = longitude.toDouble()
                        )
                    }
                )
            })
    } else {
        ErrorContent(
            modifier = modifier,
            errorMessage = errorMessage
        )
    }
}

@Composable
private fun SuccessContent(
    state: ForecastUiState,
    onFetchData: (latitude: String, longitude: String) -> Unit,
    modifier: Modifier = Modifier
) {
    val forecast = state.forecast
    val localContext = LocalContext.current

    if (forecast != null) {
        Content(modifier = modifier, forecast = forecast)
    } else {
        ErrorContent(
            modifier = modifier,
            errorMessage = stringResource(id = R.string.forecast_general_error)
        )
    }

    LaunchedEffect(Unit) {
        val location = LocationHelper.getLocation(localContext)
        if (location.latitude.isNotEmpty() && location.longitude.isNotEmpty()) onFetchData(location.latitude, location.longitude)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun Content(
    forecast: Forecast,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState(pageCount = {
        forecast.forecastWeatherList.size
    })

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LocationTopBar(
            cityName = forecast.cityName,
            countryCode = forecast.countryCode,
            modifier = Modifier
                .padding(horizontal = 4.dp)
        )

        HorizontalPager(
            modifier = Modifier
                .fillMaxSize(),
            state = pagerState
        ) { page ->
            WeatherForecastPage(forecastWeather = forecast.forecastWeatherList[page])
        }
    }


}