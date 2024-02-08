package com.zehcort.weatherx.views.composables.components.forecast

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.zehcort.domain.models.ForecastWeather
import com.zehcort.weatherx.R
import java.util.Locale

@Composable
fun ForecastWeatherCard(
    forecastWeather: ForecastWeather,
    modifier: Modifier = Modifier
) {
    val localContext = LocalContext.current

    Card(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = forecastWeather.date
            )

            Text(
                text = forecastWeather.time
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "${forecastWeather.temperature}${stringResource(id = R.string.temperature_units)}",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )

                AsyncImage(
                    modifier = Modifier.requiredSize(60.dp),
                    model = ImageRequest.Builder(localContext).data(forecastWeather.icon)
                        .crossfade(true).scale(Scale.FIT).build(),
                    contentDescription = forecastWeather.weatherCategory
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "${forecastWeather.precipitationProbability}${stringResource(id = R.string.precipitation_probability_units)}")

                AsyncImage(
                    modifier = Modifier.requiredSize(40.dp),
                    model = ImageRequest.Builder(localContext).data(forecastWeather.rainIcon)
                        .crossfade(true).scale(Scale.FIT).build(),
                    contentDescription = forecastWeather.weatherCategory
                )
            }

            Text(
                text = forecastWeather.weatherDescription.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
            )
        }
    }
}