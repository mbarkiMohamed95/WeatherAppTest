package com.example.domain.local.dao.weatherDao

import androidx.room.Dao
import androidx.room.Query
import com.example.domain.local.dao.baseDAO.BaseDao
import com.example.domain.local.entitys.WeatherLocalModel
import com.example.domain.repository.weather.model.WeatherRepositoryModel
import com.example.domain.tools.data.DataState
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao: BaseDao<WeatherLocalModel>{
    @Query("SELECT * FROM WeatherLocalModel")
    fun loadAllWeathersAsFlow():Flow<List<WeatherLocalModel>>

    @Query("SELECT * FROM WeatherLocalModel")
    fun loadAllWeathers():List<WeatherLocalModel>

    @Query("SELECT * FROM WeatherLocalModel WHERE name =:cityName")
     fun loadWeatherByNameCity(cityName: String): WeatherLocalModel

    @Query("DELETE FROM WeatherLocalModel")
     fun deleteAllWeather()

}