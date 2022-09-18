package com.example.weatherapptest.usesCase.loadDetailWeather.manager

import com.example.domain.tools.data.DataState
import com.example.weatherapptest.usesCase.loadDetailWeather.model.DetailWeatherUiModel
import kotlinx.coroutines.flow.Flow

interface DetailWeatherUsesCase {
    suspend fun loadDetailWeather(cityName:String): Flow<DataState<DetailWeatherUiModel>>
}