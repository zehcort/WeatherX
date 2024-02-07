package com.zehcort.weatherx.permissions

import android.Manifest
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.zehcort.weatherx.R

@Composable
fun LocationPermissionHandler(
    grantedContent: @Composable () -> Unit
) {
    SinglePermissionHandler(
        permission = Manifest.permission.ACCESS_COARSE_LOCATION,
        grantedContent = grantedContent,
        rationaleMessage = stringResource(id = R.string.rationale_location_permission),
        requiredMessage = stringResource(id = R.string.required_location_permission)
    )
}