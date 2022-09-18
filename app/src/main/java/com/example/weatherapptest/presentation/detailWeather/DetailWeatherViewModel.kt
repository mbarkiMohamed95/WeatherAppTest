package com.example.weatherapptest.presentation.detailWeather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.tools.data.DataState
import com.example.weatherapptest.presentation.detailWeather.action.DetailWeatherActions
import com.example.weatherapptest.usesCase.loadDetailWeather.manager.DetailWeatherUsesCase
import com.example.weatherapptest.usesCase.loadDetailWeather.model.DetailWeatherUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailWeatherViewModel @Inject constructor(private val detailWeatherUsesCase: DetailWeatherUsesCase) :
    ViewModel() {
    private val _dataState: MutableLiveData<DataState<DetailWeatherUiModel>> =
        MutableLiveData(
            DataState.Idle
        )

    val dataState: LiveData<DataState<DetailWeatherUiModel>> get() = _dataState



    fun handleAction(action: DetailWeatherActions) {
        viewModelScope.launch {
            when (action) {
                is DetailWeatherActions.LoadDetail->{
                    loadDetailWeatherView(action.cityName)
                }
            }
        }
    }


    private suspend fun loadDetailWeatherView(cityName:String){
        detailWeatherUsesCase.loadDetailWeather(cityName).collect{
            _dataState.value=it
        }
    }


}