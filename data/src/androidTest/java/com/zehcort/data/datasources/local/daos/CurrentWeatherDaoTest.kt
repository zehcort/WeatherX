package com.zehcort.data.datasources.local.daos

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.zehcort.data.datasources.local.CurrentWeatherDatabase
import com.zehcort.data.entities.local.CurrentWeather
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class CurrentWeatherDaoTest {
    private lateinit var database: CurrentWeatherDatabase

    @Before
    fun createDb() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            CurrentWeatherDatabase::class.java
        ).build()
    }

    @After
    fun closeDb() = database.close()

    @Test
    fun saveRecord() = runBlocking {
        val currentWeather = CurrentWeather(
            id = 0,
            weatherCategory = "test_weather_category",
            weatherDescription = "test_weather_description",
            icon = "test_icon",
            temperature = 0F,
            feelsLike = 0F,
            tempMin = 0F,
            tempMax = 0F,
            pressure = 0,
            humidity = 0,
            cloudiness = 0,
            countryCode = "test_country_code",
            cityName = "test_city"
        )

        database.currentWeatherDao().saveRecord(currentWeather)

        val loaded = database.currentWeatherDao().getLastRecord()

        if (loaded != null) {
            assert(loaded.weatherDescription == currentWeather.weatherDescription)
            assert(loaded.weatherDescription == currentWeather.weatherDescription)
            assert(loaded.icon == currentWeather.icon)
            assert(loaded.temperature == currentWeather.temperature)
            assert(loaded.feelsLike == currentWeather.feelsLike)
            assert(loaded.tempMin == currentWeather.tempMin)
            assert(loaded.tempMax == currentWeather.tempMax)
            assert(loaded.pressure == currentWeather.pressure)
            assert(loaded.humidity == currentWeather.humidity)
            assert(loaded.cloudiness == currentWeather.cloudiness)
            assert(loaded.countryCode == currentWeather.countryCode)
            assert(loaded.cityName == currentWeather.cityName)
        }
    }
}