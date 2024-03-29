package com.zehcort.weatherx.di

import com.zehcort.domain.repositories.WeatherRepository
import com.zehcort.domain.usecases.GetCurrentWeather
import com.zehcort.domain.usecases.GetForecast
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides
    @Singleton
    fun provideGetCurrentWeatherUseCase(repository: WeatherRepository): GetCurrentWeather {
        return GetCurrentWeather(repository = repository)
    }

    @Provides
    @Singleton
    fun provideGetForecastUseCase(repository: WeatherRepository): GetForecast {
        return GetForecast(repository = repository)
    }
}