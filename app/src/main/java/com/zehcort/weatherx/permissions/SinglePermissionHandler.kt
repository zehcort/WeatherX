package com.zehcort.weatherx.permissions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.zehcort.weatherx.R

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun SinglePermissionHandler(
    permission: String,
    grantedContent: @Composable () -> Unit,
    rationaleMessage: String,
    requiredMessage: String
) {
    val permissionState = rememberPermissionState(permission)

    if (permissionState.status.isGranted) {
        grantedContent()
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = if (permissionState.status.shouldShowRationale) rationaleMessage else requiredMessage,
                textAlign = TextAlign.Center
            )

            Button(
                modifier = Modifier.padding(top = 8.dp),
                onClick = { permissionState.launchPermissionRequest() }) {
                Text(text = stringResource(id = R.string.request_permission))
            }
        }
    }
}