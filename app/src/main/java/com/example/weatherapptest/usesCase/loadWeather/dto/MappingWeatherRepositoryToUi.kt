package com.example.weatherapptest.usesCase.loadWeather.dto


import com.example.domain.base.DomainDTOMappingService
import com.example.domain.local.entitys.*
import com.example.domain.repository.weather.model.*
import com.example.weatherapptest.usesCase.loadWeather.model.WeatherUiModel
import javax.inject.Inject

class MappingWeatherRepositoryToUi @Inject constructor() :
    DomainDTOMappingService<WeatherRepositoryModel,WeatherUiModel > {

    override fun mapDomainToDTO(domain: WeatherRepositoryModel): WeatherUiModel = domain.run{
        WeatherUiModel(name,weatherLocal[0].main,dt,"${mainRepModel.temp_min} ~ ${mainRepModel.temp_max}",weatherLocal[0].icon)
    }

}
