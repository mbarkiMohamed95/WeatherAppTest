package com.example.domain.di

import com.example.domain.networking.weather.manager.WeatherNetworkManager
import com.example.domain.networking.weather.manager.WeatherNetworkManagerImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkingModule {

    @Binds
    abstract fun bindLoadWeatherNetworkManager(loadWeatherNetworkManagerImp: WeatherNetworkManagerImp): WeatherNetworkManager

}