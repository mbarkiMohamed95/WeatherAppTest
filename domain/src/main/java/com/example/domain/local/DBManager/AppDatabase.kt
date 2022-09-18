package com.example.domain.local.DBManager

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.domain.local.dao.weatherDao.WeatherDao
import com.example.domain.local.entitys.WeatherLocalModel
import com.example.domain.local.typeCoverter.WeatherTypeConverter

@Database(
    entities = [WeatherLocalModel::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(WeatherTypeConverter::class)

abstract class AppDatabase: RoomDatabase() {
  abstract fun weatherDao(): WeatherDao
    companion object {
        val DATABASE_NAME: String = "WeatherDataBase"
    }
}