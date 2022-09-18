package com.example.domain.repository.weather.model

import com.google.gson.annotations.SerializedName

data class MainRepModel(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Int,
    val humidity: Int
)