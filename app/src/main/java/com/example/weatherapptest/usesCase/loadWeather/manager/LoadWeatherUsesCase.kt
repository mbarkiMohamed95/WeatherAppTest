package com.example.weatherapptest.usesCase.loadWeather.manager

import com.example.domain.tools.data.DataState
import com.example.weatherapptest.usesCase.loadWeather.model.WeatherUiModel
import com.example.weatherapptest.usesCase.loadWeather.model.WeatherUsesCaseModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import javax.security.auth.callback.Callback

interface LoadWeatherUsesCase {
  suspend  fun loadWeathers(coroutineScope: CoroutineScope)
  suspend  fun loadWeathersByCityName(cityName:String):Flow<DataState<List<WeatherUiModel>>>
  suspend fun loadWeatherFromLocalAsFlow():Flow<DataState<List<WeatherUiModel>>>
  fun checkLocationPermissions(): Boolean
  suspend fun saveWeatherCity()
}