package com.example.domain.networking.weather.model

import com.google.gson.annotations.SerializedName


data class WeatherModel (
	@SerializedName("dt") val dt : Int,
	@SerializedName("coord") val coord : Coord,
	@SerializedName("weather") val weather : List<Weather>,
	@SerializedName("base") val base : String,
	@SerializedName("main") val main : Main,
	@SerializedName("visibility") val visibility : Int,
	@SerializedName("wind") val wind : Wind,
	@SerializedName("clouds") val clouds : Clouds,
	@SerializedName("sys") val sys : Sys,
	@SerializedName("timezone") val timezone : Int,
	@SerializedName("name") val name : String,
	@SerializedName("cod") val cod : Int
)