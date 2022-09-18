package com.example.weatherapptest.presentation.detailWeather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.domain.tools.data.DataState
import com.example.weatherapptest.R
import com.example.weatherapptest.databinding.FragmentDetailWeatherBinding
import com.example.weatherapptest.presentation.detailWeather.action.DetailWeatherActions
import com.example.weatherapptest.tools.ui.convertTimestamp
import com.example.weatherapptest.tools.ui.loadImage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_detail_weather.*
import kotlinx.android.synthetic.main.fragment_detail_weather.view.*
import java.util.*


@AndroidEntryPoint
class DetailWeatherFragment : Fragment() {
    private var _binding: FragmentDetailWeatherBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DetailWeatherViewModel by viewModels()
    private var cityName: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cityName = arguments?.getString("CityName")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailWeatherBinding.inflate(inflater, container, false)
        lifecycleScope.launchWhenStarted {
            cityName?.let {
                viewModel.handleAction(DetailWeatherActions.LoadDetail(it))
                observeDeatilWeathers()
            }
        }
        binding.backBtn.setOnClickListener {
            findNavController().navigateUp()
        }
        return binding.root
    }

    private fun observeDeatilWeathers() {
        viewModel.dataState.observe(viewLifecycleOwner) {
            when (it) {
                is DataState.Success -> {
                    var res = it.data
                    res.apply {
                        updateBackGround(main)

                        loadImage("${icon}.png", requireContext())?.let {
                            Glide.with(requireContext()).load(it).into(binding.imageIcon)
                        }
                        binding.textTemperature.text = "${temp.toInt()} C°"
                        binding.textMainWeather.text = main
                        binding.textLastUpdate.text = "${convertTimestamp(lastUpdate)} at $cityName"
                        binding.textPressure.text = "$pressure mb"
                        binding.textHumidity.text = "$humidity %"
                        binding.textRain.text = description
                        binding.textVisibility.text = "${visibility / 1000} km"
                        binding.textWindDir.text = "${getCardinalDirection(windDeg)}"
                        binding.textWindSpeed.text = windSpeed.toString()
                    }

                }
            }
        }
    }

    private fun getCardinalDirection(angle: Int): String {
        var directions = listOf("↑ N", "↗ NE", "→ E", "↘ SE", "↓ S", "↙ SW", "← W", "↖ NW")
        return directions[(Math.round(angle / 45.0) % 8).toInt()];
    }

    private fun updateBackGround(main: String) {
        val c: Calendar = Calendar.getInstance()
        val timeOfDay: Int = c.get(Calendar.HOUR_OF_DAY)
        if (timeOfDay >= 6 && timeOfDay < 18) {
            if (main.contains("cloud")) {
                binding.swipeRefreshLayout.background =
                    ContextCompat.getDrawable(requireContext(), R.drawable.cloud_day_bg)

            } else {
                binding.swipeRefreshLayout.background =
                    ContextCompat.getDrawable(requireContext(), R.drawable.clear_day_bg)

            }
        } else {
            if (main.contains("cloud")) {
                binding.swipeRefreshLayout.background =
                    ContextCompat.getDrawable(requireContext(), R.drawable.cloud_night_bg)
            } else {
                binding.swipeRefreshLayout.background =
                    ContextCompat.getDrawable(requireContext(), R.drawable.clear_night_bg)

            }

        }
    }
}