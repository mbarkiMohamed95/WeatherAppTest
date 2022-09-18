package com.example.domain.networking.weather.model

import com.google.gson.annotations.SerializedName


data class Clouds (

	@SerializedName("all") val all : Int
)