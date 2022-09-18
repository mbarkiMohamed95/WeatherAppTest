package com.example.weatherapptest.presentation.home.action

sealed class HomeAction(){
    object LoadWeather:HomeAction()
    object UpdateWeather:HomeAction()
}
