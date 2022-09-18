package com.example.domain.local.localManager

import com.example.domain.local.entitys.WeatherLocalModel
import com.example.domain.repository.weather.model.WeatherRepositoryModel
import com.example.domain.tools.data.DataState
import kotlinx.coroutines.flow.Flow

interface LocalWeatherManager {
    suspend fun saveWeather(weatherLocalModel: WeatherLocalModel)
    suspend fun saveListWeather(weatherLocalModel: List<WeatherLocalModel>)
    suspend fun getAllWeathersAsFlow(): Flow<List<WeatherLocalModel>>
    suspend fun getAllWeathers(): List<WeatherLocalModel>
    suspend fun loadWeatherByNameCityFromLocal(cityName: String): WeatherLocalModel

}