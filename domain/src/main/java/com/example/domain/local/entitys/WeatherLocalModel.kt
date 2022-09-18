package com.example.domain.local.entitys

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class WeatherLocalModel(
    val cod: Int,
    val dt: Int,
    val coordLocal: CoordLocal,
    val weatherLocal: List<WeatherLocal>,
    val base: String,
    val mainLocal: MainLocal,
    val visibility: Int,
    val wind: WindLocal,
    val cloudsLocal: CloudsLocal,
    val sysLocal: SysLocal,
    val timezone: Int,
    @PrimaryKey val name: String
)