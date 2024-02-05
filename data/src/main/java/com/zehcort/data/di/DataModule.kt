package com.zehcort.data.di

import android.content.Context
import androidx.room.Room
import com.squareup.moshi.Moshi
import com.zehcort.data.datasources.local.CurrentWeatherDatabase
import com.zehcort.data.datasources.local.daos.CurrentWeatherDao
import com.zehcort.data.datasources.remote.api.ow.Constants
import com.zehcort.data.datasources.remote.api.ow.WeatherApi
import com.zehcort.data.repositories.WeatherRepositoryImpl
import com.zehcort.domain.repositories.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    @Provides
    @Singleton
    fun provideRetrofitInstance(
        moshi: Moshi
    ): Retrofit = Retrofit.Builder().baseUrl(Constants.OW_BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi)).build()

    @Provides
    @Singleton
    fun provideOwWeatherApi(retrofit: Retrofit): WeatherApi = retrofit.create(WeatherApi::class.java)

    @Provides
    @Singleton
    fun provideWeatherRepository(weatherApi: WeatherApi, currentWeatherDao: CurrentWeatherDao): WeatherRepository =
        WeatherRepositoryImpl(weatherApi, currentWeatherDao)

    @Provides
    @Singleton
    fun provideCurrentWeatherDatabase(@ApplicationContext applicationContext: Context): CurrentWeatherDatabase =
        Room.databaseBuilder(
            applicationContext,
            CurrentWeatherDatabase::class.java, "current-weather-database"
        ).build()

    @Singleton
    @Provides
    fun provideCurrentWeatherDao(
        database: CurrentWeatherDatabase
    ): CurrentWeatherDao = database.currentWeatherDao()
}