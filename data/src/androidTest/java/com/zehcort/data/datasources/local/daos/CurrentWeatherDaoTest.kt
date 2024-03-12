package com.zehcort.data.datasources.local.daos

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.zehcort.data.datasources.local.CurrentWeatherDatabase
import com.zehcort.data.entities.local.CurrentWeather
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

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
    fun saveRecordAndGetLastRecord() = runBlocking {
        // GIVEN - Save a record

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

        // WHEN - Get the last record from the database

        val loaded = database.currentWeatherDao().getLastRecord()

        // THEN - The loaded data contains the expected values

        if (loaded != null) {
            assertThat(loaded.weatherCategory).isEqualTo(currentWeather.weatherCategory)
            assertThat(loaded.weatherDescription).isEqualTo(currentWeather.weatherDescription)
            assertThat(loaded.icon).isEqualTo(currentWeather.icon)
            assertThat(loaded.temperature).isEqualTo(currentWeather.temperature)
            assertThat(loaded.feelsLike).isEqualTo(currentWeather.feelsLike)
            assertThat(loaded.tempMin).isEqualTo(currentWeather.tempMin)
            assertThat(loaded.tempMax).isEqualTo(currentWeather.tempMax)
            assertThat(loaded.pressure).isEqualTo(currentWeather.pressure)
            assertThat(loaded.humidity).isEqualTo(currentWeather.humidity)
            assertThat(loaded.cloudiness).isEqualTo(currentWeather.cloudiness)
            assertThat(loaded.countryCode).isEqualTo(currentWeather.countryCode)
            assertThat(loaded.cityName).isEqualTo(currentWeather.cityName)
        }
    }
}