package mz.co.vodacom.challenge.epictravelassistant.services.api

import mz.co.vodacom.challenge.epictravelassistant.models.dtos.ExchangeRateResponseDto
import org.springframework.stereotype.Service
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url


@Service
interface ExchangeRateApi {
    @GET
    fun fetchExchange(@Url url: String): Call<ExchangeRateResponseDto>
}