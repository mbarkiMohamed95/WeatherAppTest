package com.example.weatherapptest.presentation.search.action

import java.io.File

sealed class SearchViewActions{
    data class LoadSearchedCityWeather(val cityName:String=""):SearchViewActions()
    object SavePlace:SearchViewActions()

}
