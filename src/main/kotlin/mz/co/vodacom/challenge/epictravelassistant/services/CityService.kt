package mz.co.vodacom.challenge.epictravelassistant.services

import mz.co.vodacom.challenge.epictravelassistant.models.dtos.ExchangeRateResponseDto
import mz.co.vodacom.challenge.epictravelassistant.services.api.ApiServiceGenerator
import mz.co.vodacom.challenge.epictravelassistant.services.api.CityApi
import mz.co.vodacom.challenge.epictravelassistant.services.api.CountryApi
import mz.co.vodacom.challenge.epictravelassistant.models.dtos.CityResponseDto
import mz.co.vodacom.challenge.epictravelassistant.models.dtos.CountryResponseDto
import mz.co.vodacom.challenge.epictravelassistant.services.api.ExchangeRateApi
import mz.co.vodacom.challenge.epictravelassistant.services.api.WeatherApi
import mz.co.vodacom.challenge.epictravelassistant.services.api.weather.models.WeatherResponseDto
import mz.co.vodacom.challenge.epictravelassistant.utils.constants.CommonConstants.Companion.CITY_BASE_URL
import mz.co.vodacom.challenge.epictravelassistant.utils.constants.CommonConstants.Companion.COUNTRIES_BASE_URL
import mz.co.vodacom.challenge.epictravelassistant.utils.constants.CommonConstants.Companion.EXCHANGERATE_BASE_URL
import mz.co.vodacom.challenge.epictravelassistant.utils.constants.CommonConstants.Companion.WEATHER_BASE_URL
import mz.co.vodacom.challenge.epictravelassistant.utils.log.LogUtils
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import retrofit2.Call
import retrofit2.Response

@Service
class CityService(
    val apiServiceGenerator: ApiServiceGenerator,
) {

    @Value("\${api.weather}")
    private lateinit var weatherAPI: String

    @Value("\${api.exchangerate}")
    private lateinit var exchangeRateApi: String

    @Value("\${api.country}")
    private lateinit var countryApi: String

    fun getCity(name: String? = ""): List<CityResponseDto>? {
        val service: CityApi = apiServiceGenerator.createService(CityApi::class.java)
        val url = "${CITY_BASE_URL}$name"
        val callAsync: Call<List<CityResponseDto>> = service.fetchCity(url, countryApi)
        val response: Response<List<CityResponseDto>> = callAsync.execute()
        return if (response.isSuccessful) {
            LogUtils.log(this, response.body().toString())
            response.body()
        } else {
            null
        }
    }

    fun getCountry(name: String? = ""): List<CountryResponseDto>? {
        val service: CountryApi = apiServiceGenerator.createService(CountryApi::class.java)
        val url = "${COUNTRIES_BASE_URL}$name"
        val callAsync: Call<List<CountryResponseDto>> = service.fetchCountry(url, countryApi)
        val response: Response<List<CountryResponseDto>> = callAsync.execute()
        return if (response.isSuccessful) {
            LogUtils.log(this, response.body().toString())
            response.body()
        } else {
            null
        }
    }


    fun getCityWeather(lat: Double? = 0.0, lon: Double? = 0.0): WeatherResponseDto? {
        val service: WeatherApi = apiServiceGenerator.createService(WeatherApi::class.java)
        val callAsync: Call<WeatherResponseDto> = service.fetchWeather(WEATHER_BASE_URL, lat = lon, lon = lat, api = weatherAPI)
        val response: Response<WeatherResponseDto> = callAsync.execute()
        return if (response.isSuccessful) {
            LogUtils.log(this, response.body().toString())
            response.body()
        } else {
            null
        }

    }

    fun getCityExchangeRates(currency: String? = ""): ExchangeRateResponseDto? {
        val service: ExchangeRateApi = apiServiceGenerator.createService(ExchangeRateApi::class.java)
        val url = "${EXCHANGERATE_BASE_URL}$currency".replace("{API}", exchangeRateApi)
        val callAsync: Call<ExchangeRateResponseDto> = service.fetchExchange(url)
        val response: Response<ExchangeRateResponseDto> = callAsync.execute()
        return if (response.isSuccessful) {
            LogUtils.log(this, response.body().toString())
            response.body()
        } else {
            null
        }
    }

    fun searchByName(name: String): Any? {
        val city = getCity(name)?.getOrNull(0)
        val country = getCountry(city?.country)
        val weather = getCityWeather(lat = city?.latitude, lon = city?.longitude)
        val exchange = getCityExchangeRates(country?.get(0)?.currency?.code)
        return listOf(country, weather, exchange)
    }
}