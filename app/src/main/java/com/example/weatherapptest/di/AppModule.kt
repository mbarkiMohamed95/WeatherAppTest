package com.example.weatherapptest.di

import com.example.weatherapptest.tools.location.LocationManager
import com.example.weatherapptest.tools.location.LocationManagerInteraction
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Singleton
    @Binds
    abstract fun provideLocationManager(locationManager: LocationManager): LocationManagerInteraction

}