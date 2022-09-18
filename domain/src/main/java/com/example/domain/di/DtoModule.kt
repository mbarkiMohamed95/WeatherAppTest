package com.example.domain.di

import com.example.domain.base.DomainDTOMappingService
import com.example.domain.local.entitys.WeatherLocalModel
import com.example.domain.networking.weather.model.WeatherModel
import com.example.domain.repository.weather.model.WeatherRepositoryModel
import com.example.domain.repository.weatherdto.MappingWeatherLocalToRepository
import com.example.domain.repository.weatherdto.MappingWeatherNetWorkToRepository
import com.example.domain.repository.weatherdto.MappingWeatherRemoteToLocal
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DtoModule {
    @Singleton
    @Binds
    abstract fun provideMappingLocalToRepository(mappingWeatherLocalToRepository: MappingWeatherLocalToRepository): DomainDTOMappingService<WeatherLocalModel, WeatherRepositoryModel>

    @Singleton
    @Binds
    abstract fun provideMappingRemoteToLocal(mappingWeatherRemoteToLocal: MappingWeatherRemoteToLocal): DomainDTOMappingService<WeatherModel, WeatherLocalModel>


    @Singleton
    @Binds
    abstract fun provideMappingWeatherNetWorkToRepository(mappingWeatherNetWorkToRepository: MappingWeatherNetWorkToRepository): DomainDTOMappingService<WeatherModel, WeatherRepositoryModel>


}