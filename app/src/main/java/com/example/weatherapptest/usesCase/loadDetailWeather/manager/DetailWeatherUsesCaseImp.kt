package com.example.weatherapptest.usesCase.loadDetailWeather.manager

import com.example.domain.repository.weather.manager.WeatherRepository
import com.example.domain.repository.weather.model.WeatherRepositoryModel
import com.example.domain.tools.data.DataState
import com.example.weatherapptest.usesCase.loadDetailWeather.model.DetailWeatherUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DetailWeatherUsesCaseImp @Inject constructor(private val repository: WeatherRepository) :
    DetailWeatherUsesCase {
    override suspend fun loadDetailWeather(cityName: String): Flow<DataState<DetailWeatherUiModel>> = flow {
        emit(DataState.Success(createDetailModel(repository.loadWeatherByNameCityFromLocal(cityName))))
    }

    private fun createDetailModel(weatherRepositoryModel: WeatherRepositoryModel): DetailWeatherUiModel =
        weatherRepositoryModel.run {
            DetailWeatherUiModel(
                name,
                weatherLocal[0].icon,
                mainRepModel.temp,
                weatherLocal[0].main,
                weatherLocal[0].description,
                dt,
                mainRepModel.pressure,
                mainRepModel.humidity,
                visibility,
                wind.deg,
                wind.speed
            )
        }
}
