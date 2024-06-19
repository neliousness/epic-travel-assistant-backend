package mz.co.vodacom.challenge.epictravelassistant.services.api

import mz.co.vodacom.challenge.epictravelassistant.models.dtos.CountryResponseDto
import org.springframework.stereotype.Service
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Url


@Service
interface CountryApi {
    @GET
    fun fetchCountry(@Url url: String, @Header("X-Api-Key") api: String): Call<List<CountryResponseDto>>
}