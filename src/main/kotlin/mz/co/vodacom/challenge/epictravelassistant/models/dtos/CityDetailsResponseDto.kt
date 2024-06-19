package mz.co.vodacom.challenge.epictravelassistant.models.dtos

import mz.co.vodacom.challenge.epictravelassistant.services.api.weather.models.WeatherResponseDto


data class CityDetailsResponseDto(
    val id: String?,
    val name: String?,
    val country: String?,
    val population: Int?,
    val gdpPerCapita: Int?,
    val weather: Weather?,
    val exchangeRates: List<ExchangeRate>?
) {
    companion object {
        fun toData(city: CityResponseDto?, country: List<CountryResponseDto>?, weather: WeatherResponseDto?, exchange: ExchangeRateResponseDto?): CityDetailsResponseDto? {

            val country = country?.get(0)
            return CityDetailsResponseDto(
                id = city?.name,
                name = city?.name,
                country = country?.name,
                population = country?.population,
                gdpPerCapita = country?.gdp_per_capita?.toInt(),
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
