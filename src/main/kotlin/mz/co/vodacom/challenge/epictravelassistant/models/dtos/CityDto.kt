package mz.co.vodacom.challenge.epictravelassistant.models.dtos


data class CityDto(
    val id: String,
    val name: String,
    val country: String,
    val population: Int,
    val gdpPerCapita: Int,
    val weather: Weather,
    val exchangeRates: List<ExchangeRate>
)

data class Weather(
    val temperature: Int,
    val description: String,
    val forecastDate: String
)

data class ExchangeRate(
    val baseCurrency: String,
    val targetCurrency: String,
    val rate: Double,
    val retrievalDate: String
)
