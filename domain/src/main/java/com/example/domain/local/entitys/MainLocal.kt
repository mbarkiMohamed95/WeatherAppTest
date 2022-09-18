package com.example.domain.local.entitys

import com.google.gson.annotations.SerializedName

data class MainLocal(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Int,
    val humidity: Int
)