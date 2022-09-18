package com.example.domain.networking.weather.manager

import com.example.domain.networking.weather.model.WeatherModel
import kotlinx.coroutines.flow.Flow

interface WeatherNetworkManager {
    suspend fun loadWeather(
        apiKey: String,
        latitude: Double? = null,
        longitude: Double? = null,
        language: String? = null,
        currentTime: Long? = null,
        cityName: String? = null

    ): Flow<WeatherModel?>
}