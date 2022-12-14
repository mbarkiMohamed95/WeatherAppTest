package com.example.weatherapptest.tools.workmangers.update

import android.content.Context
import androidx.lifecycle.asFlow
import androidx.work.*
import com.example.weatherapptest.tools.appConst.AppConst.CITY_NAME_KEY
import com.example.weatherapptest.tools.appConst.AppConst.CITY_number
import com.example.weatherapptest.tools.appConst.AppConst.LATITUDE_KEY
import com.example.weatherapptest.tools.appConst.AppConst.LONGITUDE_KEY
import com.example.weatherapptest.tools.workmangers.update.model.UpdateWeatherWMModel
import com.example.weatherapptest.tools.workmangers.updateLocalweathers.UpdateWeathersWorkManager
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class SetUpUpdateWeatherManagerWorkerImp @Inject constructor(
    @ApplicationContext private val appContext: Context) : SetUpUploadManagerWorker {
    private val listActualWorks = arrayListOf<OneTimeWorkRequest>()
    override suspend fun setUpWorkerDownloadChain(
        listPlace: List<UpdateWeatherWMModel>,
        coroutineScope: CoroutineScope
    ) {
        coroutineScope.launch {
            listActualWorks.clear()
            if(listPlace.isNotEmpty()){
                listPlace.forEach {it->
                    val constraints =
                        Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
                    val data = Data.Builder()
                    data.putDouble(LATITUDE_KEY, it.lat ?: 0.0)
                    data.putInt(CITY_number,listPlace.size)
                    data.putDouble(LONGITUDE_KEY, it.long ?: 0.0)
                    data.putString(CITY_NAME_KEY, it.cityName ?: "")
                    val synchroWorker = OneTimeWorkRequestBuilder<UpdateWeathersWorkManager>()
                        .setConstraints(constraints)
                        .setInitialDelay(1, TimeUnit.SECONDS)
                        .setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 5, TimeUnit.SECONDS)
                        .setInputData(data.build())
                        .addTag("updateWeather")
                        .build()
                    listActualWorks.add(synchroWorker)
                }
                var workManager=WorkManager.getInstance(appContext)
                workManager.pruneWork()
                workManager.enqueue(listActualWorks)
            }
        }
    }
}
