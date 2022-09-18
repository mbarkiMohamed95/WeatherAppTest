package com.example.domain.di

import com.example.domain.repository.weather.manager.WeatherRepository
import com.example.domain.repository.weather.manager.WeatherRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindWeatherRepository (WeatherRepository:WeatherRepositoryImp): WeatherRepository
}