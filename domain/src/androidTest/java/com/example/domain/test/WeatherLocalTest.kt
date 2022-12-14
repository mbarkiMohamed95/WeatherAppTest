package com.example.domain.test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.example.domain.local.LocalDataBaseWeatherTest
import com.example.domain.local.entitys.*
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
@SmallTest
class WeatherLocalTest {


    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    lateinit var localDataBaseWeatherTest: LocalDataBaseWeatherTest


    @Test
    fun insertDataTest() = runBlockingTest {
        var testWeatherModel=        WeatherLocalModel(
            200, 1663589776, CoordLocal(9.0, 34.0),
            listOf(WeatherLocal(802, "clous", "test", "O1")), "stations",
            MainLocal(
                36.89,
                36.76,
                36.89,
                36.89,
                1012,
                27,
            ),
            10000,
            WindLocal(2.34, 223), CloudsLocal(99),
            SysLocal
                (
                1,
                1197,
                "TN",
                1663564191,
                1663608362
            ), 3600,
            "tunisia"
        )
        localDataBaseWeatherTest.insetWeather(testWeatherModel)
        delay(100)
        val allWeather = localDataBaseWeatherTest.getAllWeather()
        assertThat(allWeather).isNotNull()
    }

    @Test
    fun deletedataTest() = runBlockingTest {
        var testWeatherModel=        WeatherLocalModel(
            200, 1663589776, CoordLocal(9.0, 34.0),
            listOf(WeatherLocal(802, "clous", "test", "O1")), "stations",
            MainLocal(
                36.89,
                36.76,
                36.89,
                36.89,
                1012,
                27,
            ),
            10000,
            WindLocal(2.34, 223), CloudsLocal(99),
            SysLocal
                (
                1,
                1197,
                "TN",
                1663564191,
                1663608362
            ), 3600,
            "tunisia"
        )
        localDataBaseWeatherTest.insetWeather(testWeatherModel)
        delay(200)
        localDataBaseWeatherTest.deletAllWeather()
    }
}