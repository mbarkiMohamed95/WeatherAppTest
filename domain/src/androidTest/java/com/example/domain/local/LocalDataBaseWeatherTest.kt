package com.example.domain.local

import com.example.domain.local.dao.weatherDao.WeatherDao
import com.example.domain.local.entitys.WeatherLocalModel

class LocalDataBaseWeatherTest (private val dao: WeatherDao) {
    suspend fun insetWeather(weatherLocalModel: WeatherLocalModel){
        dao.insert(weatherLocalModel)
    }
    fun getAllWeather():List<WeatherLocalModel> = dao.loadAllWeathers()

    fun deletAllWeather() {
        dao.deleteAllWeather()
    }
}