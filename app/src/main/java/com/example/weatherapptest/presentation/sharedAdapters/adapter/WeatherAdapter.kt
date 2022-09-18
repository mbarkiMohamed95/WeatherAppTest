package com.example.weatherapptest.presentation.sharedAdapters.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherapptest.databinding.CityItemLayoutBinding
import com.example.weatherapptest.tools.ui.convertTimestamp
import com.example.weatherapptest.tools.ui.loadImage
import com.example.weatherapptest.usesCase.loadWeather.model.WeatherUiModel
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.IOException
import java.io.InputStream
import javax.inject.Inject


class WeatherAdapter @Inject constructor(@ApplicationContext private val application: Context) :
    RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {
    private var weatherList: List<WeatherUiModel> = emptyList()
    private var weatherAdapterInteraction:WeatherAdapterInteraction?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            CityItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(weatherList[position])

    override fun getItemCount(): Int = weatherList.size

    inner class ViewHolder(private val binding: CityItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(weather: WeatherUiModel) {
            binding.apply {
                textName.text=weather.cityName
                textMain.text=weather.state
                textLastUpdated.text=convertTimestamp(weather.lastUpdate)
                textTemps.text=weather.temps
                loadImage("${weather.icon}.png", application )?.let {
                    Glide.with(application).load(it).into(imageIconCityItem)
                }
                mainContainer.setOnClickListener{
                    weatherAdapterInteraction?.onItemClicked(weather.cityName)
                }
            }
        }
    }

    fun setInteraction(weatherAdapterInteraction:WeatherAdapterInteraction){
        this.weatherAdapterInteraction=weatherAdapterInteraction
    }

    fun setWeathers(weatherList: List<WeatherUiModel>) {
        this.weatherList = weatherList
        notifyDataSetChanged()
    }

}