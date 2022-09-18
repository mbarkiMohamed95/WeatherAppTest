package com.example.weatherapptest.di

import com.example.domain.base.DomainDTOMappingService
import com.example.domain.repository.weather.model.WeatherRepositoryModel
import com.example.weatherapptest.usesCase.loadWeather.dto.MappingWeatherRepositoryToUi
import com.example.weatherapptest.usesCase.loadWeather.model.WeatherUiModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class appDtoModule {
    @Binds
    abstract fun bindMappingWeatherRepositoryToUi(mappingWeatherRepositoryToUi: MappingWeatherRepositoryToUi): DomainDTOMappingService<WeatherRepositoryModel, WeatherUiModel>
}