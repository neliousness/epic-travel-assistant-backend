package mz.co.vodacom.challenge.epictravelassistant.services.api

import mz.co.vodacom.challenge.epictravelassistant.models.dtos.CityResponseDto
import org.springframework.stereotype.Service
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url


@Service
interface CityApi {
    @GET
    fun fetchCity(@Url url: String): Call<List<CityResponseDto>>
}