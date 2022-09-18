package com.example.weatherapptest.di

import com.example.weatherapptest.tools.location.LocationManager
import com.example.weatherapptest.tools.location.LocationManagerInteraction
import com.example.weatherapptest.tools.workmangers.update.SetUpUpdateWeatherManagerWorkerImp
import com.example.weatherapptest.tools.workmangers.update.SetUpUploadManagerWorker
import com.example.weatherapptest.usesCase.loadDetailWeather.manager.DetailWeatherUsesCase
import com.example.weatherapptest.usesCase.loadDetailWeather.manager.DetailWeatherUsesCaseImp
import com.example.weatherapptest.usesCase.loadWeather.manager.LoadWeatherUsesCase
import com.example.weatherapptest.usesCase.loadWeather.manager.LoadWeatherUsesCaseImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UsesCaseModule {
    @Binds
    abstract fun provideLoadWeatherUsesCaseImp(loadWeatherUsesCaseImp: LoadWeatherUsesCaseImp): LoadWeatherUsesCase

    @Binds
    abstract fun provideSetUpUpdateWeatherManagerWorkerImp(setUpUpdateWeatherManagerWorkerImp: SetUpUpdateWeatherManagerWorkerImp): SetUpUploadManagerWorker

    @Binds
    abstract fun provideSetDetailWeatherUsesCaseImp(detailWeatherUsesCaseImp: DetailWeatherUsesCaseImp): DetailWeatherUsesCase
}