package com.example.weatherapptest.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.tools.data.DataState
import com.example.weatherapptest.presentation.home.action.HomeAction
import com.example.weatherapptest.usesCase.loadWeather.manager.LoadWeatherUsesCase
import com.example.weatherapptest.usesCase.loadWeather.model.WeatherUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val loadWeatherUsesCase: LoadWeatherUsesCase) :
    ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<WeatherUiModel>>> =
        MutableLiveData(
            DataState.Idle
        )

    val dataState: LiveData<DataState<List<WeatherUiModel>>> get() = _dataState



     fun handleAction(action: HomeAction) {
         viewModelScope.launch {
             when (action) {
                 is HomeAction.LoadWeather -> {
                     loadWeatherFromLocalAsFlow()
                 }
                 is HomeAction.UpdateWeather -> {
                     loadWeather()
                 }

             }
         }
    }

    private suspend fun loadWeather() {
        loadWeatherUsesCase.loadWeathers(viewModelScope)
    }

    private suspend fun loadWeatherFromLocalAsFlow() {
        loadWeatherUsesCase.loadWeatherFromLocalAsFlow().collect {
            _dataState.value = it
        }
    }
}