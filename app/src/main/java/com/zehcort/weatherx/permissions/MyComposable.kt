package com.zehcort.weatherx.permissions

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.zehcort.weatherx.views.composables.screens.HomeScreen

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MyComposable() {
    val locationPermissionState = rememberPermissionState(Manifest.permission.ACCESS_FINE_LOCATION)

    when {
        locationPermissionState.status.isGranted -> HomeScreen()
        else -> {
            LaunchedEffect(Unit) {
                locationPermissionState.launchPermissionRequest()
            }
            Column(Modifier.padding(vertical = 120.dp, horizontal = 16.dp)) {
                Icon(
                    Icons.Rounded.Done,
                    contentDescription = null
                )
                Spacer(Modifier.height(8.dp))
                Text("Camera permission required")
                Spacer(Modifier.height(4.dp))
                Text("This is required in order for the app to take pictures")
            }
            val context = LocalContext.current
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                onClick = {
                    val intent =
                        Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                            data = Uri.fromParts("package", context.packageName, null)
                        }
                    context.startActivity(intent)
                }) {
                Text("Go to settings")
            }
        }
    }
}