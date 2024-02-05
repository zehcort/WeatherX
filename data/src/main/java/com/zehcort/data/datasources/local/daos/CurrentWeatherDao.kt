package com.zehcort.data.datasources.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.zehcort.data.entities.local.CurrentWeather

@Dao
interface CurrentWeatherDao {
    @Insert
    fun saveRecord(currentWeather: CurrentWeather)

    @Query("SELECT * FROM currentweather ORDER BY id DESC LIMIT 1")
    fun getLastRecord(): CurrentWeather?
}