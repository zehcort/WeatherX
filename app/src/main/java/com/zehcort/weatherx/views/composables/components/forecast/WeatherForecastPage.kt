package com.zehcort.weatherx.views.composables.components.forecast

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
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
fun WeatherForecastPage(
    forecastWeather: ForecastWeather
) {
    val localContext = LocalContext.current

    Card(modifier = Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "${forecastWeather.temperature}${stringResource(id = R.string.temperature_units)}",
                fontSize = 56.sp,
                fontWeight = FontWeight.Bold
            )

            AsyncImage(
                modifier = Modifier.requiredSize(80.dp),
                model = ImageRequest.Builder(localContext).data(forecastWeather.icon)
                    .crossfade(true).scale(Scale.FIT).build(),
                contentDescription = forecastWeather.weatherCategory
            )
        }

        Row {
            Text(
                text = "${stringResource(id = R.string.high_label_colon)} ${forecastWeather.tempMax}${stringResource(id = R.string.temperature_units)} • "
            )

            Text(
                text = "${stringResource(id = R.string.low_label_colon)} ${forecastWeather.tempMin}${stringResource(id = R.string.temperature_units)}"
            )
        }

        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = forecastWeather.weatherDescription.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
        )

        Text(
            text = "${stringResource(id = R.string.feels_like)} ${forecastWeather.feelsLike}${stringResource(id = R.string.temperature_units)}"
        )
    }
}