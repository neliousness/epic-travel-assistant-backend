package mz.co.vodacom.challenge.epictravelassistant.services.api

import mz.co.vodacom.challenge.epictravelassistant.services.api.weather.models.WeatherResponseDto
import org.springframework.stereotype.Service
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url


@Service
interface WeatherApi {
    @GET
    fun fetchWeather(@Url url: String, @Query("lat") lat: Double?, @Query("lon") lon: Double?, @Query("units") units: String, @Query("appid") api: String): Call<WeatherResponseDto>
}