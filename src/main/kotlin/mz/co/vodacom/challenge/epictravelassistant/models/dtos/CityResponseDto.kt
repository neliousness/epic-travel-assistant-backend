package mz.co.vodacom.challenge.epictravelassistant.models.dtos


data class CityResponseDto(
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val country: String,
    val population: Int,
    val is_capital: Boolean,
)

