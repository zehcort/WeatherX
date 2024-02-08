package com.zehcort.weatherx.views.composables.components.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.zehcort.weatherx.R

@Composable
fun LocationTopBar(
    cityName: String,
    countryCode: String,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Row(modifier = Modifier.padding(16.dp)) {
            Icon(
                imageVector = Icons.Default.Place,
                contentDescription = stringResource(id = R.string.empty_content),
            )

            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = "$cityName, $countryCode",
                textAlign = TextAlign.Center
            )
        }
    }
}