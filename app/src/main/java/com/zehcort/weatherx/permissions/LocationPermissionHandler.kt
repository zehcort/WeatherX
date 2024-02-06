package com.zehcort.weatherx.permissions

import android.Manifest
import androidx.compose.runtime.Composable

@Composable
fun LocationPermissionHandler(
    grantedContent: @Composable () -> Unit
) {
    SinglePermissionHandler(
        permission = Manifest.permission.ACCESS_COARSE_LOCATION,
        grantedContent = grantedContent
    )
}