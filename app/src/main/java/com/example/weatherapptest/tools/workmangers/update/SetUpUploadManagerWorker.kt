package com.example.weatherapptest.tools.workmangers.update

import androidx.work.WorkInfo
import com.example.weatherapptest.tools.workmangers.update.model.UpdateWeatherWMModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

interface SetUpUploadManagerWorker {
    suspend fun setUpWorkerDownloadChain(
        listPlace: List<UpdateWeatherWMModel>,
        coroutineScope: CoroutineScope
    )
}