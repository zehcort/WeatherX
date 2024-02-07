package com.zehcort.weatherx.views.composables.screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.zehcort.domain.models.CurrentWeather
import com.zehcort.weatherx.R
import com.zehcort.weatherx.permissions.LocationPermissionHandler
import com.zehcort.weatherx.states.HomeUiState
import com.zehcort.weatherx.utils.LocationHelper
import com.zehcort.weatherx.viewmodels.WeatherViewModel
import com.zehcort.weatherx.views.composables.components.ErrorContent
import com.zehcort.weatherx.views.composables.components.LoadingIndicator
import com.zehcort.weatherx.views.composables.components.home.WeatherConditionCard
import java.util.Locale

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: WeatherViewModel = hiltViewModel()
) {
    val state = viewModel.homeUiState.value
    val errorMessage = state.errorMessage

    if (state.isLoading) {
        LoadingIndicator(modifier = modifier)
    } else if (errorMessage.isNullOrEmpty()) {
        LocationPermissionHandler(
            grantedContent = {
                SuccessContent(
                    modifier = modifier,
                    state = viewModel.homeUiState.value,
                    onFetchData = { latitude, longitude ->
                        viewModel.fetchCurrentWeather(
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
    state: HomeUiState,
    onFetchData: (latitude: String, longitude: String) -> Unit,
    modifier: Modifier = Modifier
) {
    val currentWeather = state.currentWeather
    val localContext = LocalContext.current

    if (currentWeather != null) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            TopContent(currentWeather, localContext)

            BottomContent(currentWeather)
        }
    } else {
        ErrorContent(
            modifier = modifier,
            errorMessage = stringResource(id = R.string.current_weather_general_error)
        )
    }

    LaunchedEffect(Unit) {
        val location = LocationHelper.getLocation(localContext)
        onFetchData(location.latitude, location.longitude)
    }
}

@Composable
private fun TopContent(
    currentWeather: CurrentWeather,
    localContext: Context
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp)
        ) {
            Row(modifier = Modifier.padding(16.dp)) {
                Icon(
                    imageVector = Icons.Default.Place,
                    contentDescription = stringResource(id = R.string.empty_content),
                )

                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = "${currentWeather.cityName}, ${currentWeather.countryCode}",
                    textAlign = TextAlign.Center
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "${currentWeather.temperature}${stringResource(id = R.string.temperature_units)}",
                    fontSize = 56.sp,
                    fontWeight = FontWeight.Bold
                )

                AsyncImage(
                    modifier = Modifier.requiredSize(80.dp),
                    model = ImageRequest.Builder(localContext).data(currentWeather.icon)
                        .crossfade(true).scale(Scale.FIT).build(),
                    contentDescription = currentWeather.weatherCategory
                )
            }

            Row {
                Text(
                    text = "${stringResource(id = R.string.high_label_colon)} ${currentWeather.tempMax}${stringResource(id = R.string.temperature_units)} • "
                )

                Text(
                    text = "${stringResource(id = R.string.low_label_colon)} ${currentWeather.tempMin}${stringResource(id = R.string.temperature_units)}"
                )
            }

            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = currentWeather.weatherDescription.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
            )

            Text(
                text = "${stringResource(id = R.string.feels_like)} ${currentWeather.feelsLike}${stringResource(id = R.string.temperature_units)}"
            )
        }
    }
}

@Composable
private fun BottomContent(
    currentWeather: CurrentWeather
) {
    Column {
        WeatherConditionCard(
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(id = R.string.cloudiness),
            text = "${currentWeather.cloudiness}${stringResource(id = R.string.cloudiness_units)}"
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            WeatherConditionCard(
                modifier = Modifier.weight(1F),
                label = stringResource(id = R.string.humidity),
                text = "${currentWeather.humidity}${stringResource(id = R.string.humidity_units)}"
            )

            Spacer(modifier = Modifier.requiredWidth(8.dp))

            WeatherConditionCard(
                modifier = Modifier.weight(1F),
                label = stringResource(id = R.string.pressure),
                text = "${currentWeather.pressure} ${stringResource(id = R.string.pressure_units)}"
            )
        }
    }
}