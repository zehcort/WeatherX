package com.zehcort.data.datasources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zehcort.data.datasources.local.daos.CurrentWeatherDao
import com.zehcort.data.entities.local.CurrentWeather

@Database(entities = [CurrentWeather::class], version = 1)
abstract class CurrentWeatherDatabase : RoomDatabase() {
    abstract fun currentWeatherDao(): CurrentWeatherDao
}