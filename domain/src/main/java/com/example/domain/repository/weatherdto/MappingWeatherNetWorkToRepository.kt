package com.example.domain.repository.weatherdto


import com.example.domain.base.DomainDTOMappingService
import com.example.domain.networking.weather.model.*
import com.example.domain.repository.weather.model.*
import javax.inject.Inject

class MappingWeatherNetWorkToRepository @Inject constructor() :
    DomainDTOMappingService<WeatherModel, WeatherRepositoryModel> {
    override fun mapDomainToDTO(domain: WeatherModel): WeatherRepositoryModel = domain.run {
        WeatherRepositoryModel(
            dt,
            mapCoordNetworkCoordRepModel(coord),
            weather.map { mapWeatherNetworkToWeatherRepModel(it) },
            base,
            mapMainNetworkToMainRepModel(main),
            visibility,
            mapWindNetworkToWindRepModel(wind),
            mapCloudsNetworkToCloudsRepModel(clouds),
            mapSysNetworkToSysRepModel(sys),
            timezone,
            name,
            cod
        )
    }

    private fun mapCoordNetworkCoordRepModel(coord: Coord): CoordRepModel =
        coord.run {
            CoordRepModel(
                lon, lat
            )
        }

    private fun mapWeatherNetworkToWeatherRepModel(weather: Weather): WeatherRepModel =
        weather.run {
            WeatherRepModel(
                id, main, description, icon
            )

        }

    private fun mapMainNetworkToMainRepModel(main: Main): MainRepModel = main.run {
        MainRepModel(
            temp, feels_like, temp_min, temp_max, pressure, humidity
        )
    }

    private fun mapWindNetworkToWindRepModel(wind: Wind): WindRepModel = wind.run {
        WindRepModel(speed, deg)
    }

    private fun mapCloudsNetworkToCloudsRepModel(clouds: Clouds): CloudsRepModel =
        clouds.run {
            CloudsRepModel(all)
        }

    private fun mapSysNetworkToSysRepModel(sys: Sys): SysRepModel =
        sys.run {
            SysRepModel(type, id, country, sunrise, sunset)
        }

}
