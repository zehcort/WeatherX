package com.zehcort.weatherx.utils

import android.content.Context
import android.location.LocationManager

object LocationHelper {
    fun getLocation(context: Context): LocationData {
        return try {
            val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            val gpsLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            val networkLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)

            networkLocation?.let {
                LocationData(it.latitude.toString(), it.longitude.toString())
            }.run {
                gpsLocation?.let {
                    LocationData(it.latitude.toString(), it.longitude.toString())
                } ?: LocationData()
            }
        } catch (e: SecurityException) {
            LocationData()
        }
    }
}
