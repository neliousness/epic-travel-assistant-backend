package mz.co.vodacom.challenge.epictravelassistant.models.dtos

import mz.co.vodacom.challenge.epictravelassistant.services.api.weather.models.WeatherResponseDto


data class CityDetailsResponseDto(
    val id: String?,
    val name: String?,
    val country: String?,
    val population: Int?,
    val gdpPerCapita: Int?,
    val weather: Weather?,
    val lat: Double,
    val lon: Double,
    val exchangeRates: List<ExchangeRate>?
) {
    companion object {
        fun toData(city: CityResponseDto?,  weather: WeatherResponseDto?, exchange: ExchangeRateResponseDto?): CityDetailsResponseDto? {
            return CityDetailsResponseDto(
                id = city?.capital?.get(0) ?: "N/A",
                name = city?.capital?.get(0) ?: "N/A",
                country = city?.name?.common,
                population = city?.population?.toInt(),
                gdpPerCapita = 0,
                lat = weather?.coord?.lat ?: 0.0,
                lon = weather?.coord?.lon ?: 0.0,
                weather = Weather(temperature = weather?.main?.temp?.toInt(), description = weather?.weather?.get(0)?.description),
                exchangeRates = exchange?.conversion_rates?.map { entry -> ExchangeRate(baseCurrency = exchange.base_code, targetCurrency = entry.key, rate = entry.value, retrievalDate = exchange.time_last_update_utc)  }?.toList()
            )
        }
    }

}

data class Weather(
    val temperature: Int?,
    val description: String?,
)

data class ExchangeRate(
    val baseCurrency: String?,
    val targetCurrency: String?,
    val rate: Double?,
    val retrievalDate: String?
)
