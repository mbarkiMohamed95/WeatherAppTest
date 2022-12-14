package com.example.weatherapptest.tools.workmangers.updateLocalweathers

import android.annotation.SuppressLint
import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.domain.repository.weather.manager.WeatherRepository
import com.example.weatherapptest.BuildConfig
import com.example.weatherapptest.tools.appConst.AppConst.CITY_NAME_KEY
import com.example.weatherapptest.tools.appConst.AppConst.CITY_number
import com.example.weatherapptest.tools.appConst.AppConst.LATITUDE_KEY
import com.example.weatherapptest.tools.appConst.AppConst.LONGITUDE_KEY
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.launchIn
import java.util.*

@HiltWorker
class UpdateWeathersWorkManager @AssistedInject constructor(
    @Assisted var ctx: Context,
    @Assisted var params: WorkerParameters,
    private val repository: WeatherRepository
) : CoroutineWorker(ctx, params) {

    @SuppressLint("RestrictedApi")
    override suspend fun doWork(): Result = coroutineScope {
        var lat = if (inputData.getDouble(LATITUDE_KEY, 0.0) == 0.0) null else inputData.getDouble(
            LATITUDE_KEY,
            0.0
        )
        var cityNumber =
            if (inputData.getInt(CITY_number, 0) == 0) null else inputData.getInt(CITY_number, 0)
        var long =
            if (inputData.getDouble(LONGITUDE_KEY, 0.0) == 0.0) null else inputData.getDouble(
                LONGITUDE_KEY,
                0.0
            )
        var cityName =
            if (inputData.getString(CITY_NAME_KEY).isNullOrEmpty()) null else inputData.getString(
                CITY_NAME_KEY
            )
        repository.loadWeather(
            BuildConfig.apikey,
            cityNumber=cityNumber,
            latitude = lat,
            longitude = long,
            language = Locale.getDefault().language,
            currentTime = System.currentTimeMillis() / 1000,
            cityName = cityName
        ).launchIn(this)
        Result.success()
    }
}