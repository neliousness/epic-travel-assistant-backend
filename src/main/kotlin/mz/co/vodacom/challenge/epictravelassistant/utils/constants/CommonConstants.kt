package mz.co.vodacom.challenge.epictravelassistant.utils.constants

class CommonConstants {

    companion object {
        val  INITIAL_COUNTRIES = listOf("London", "Tokyo", "Maputo", "New York", "Cairo", "Paris")

        const val COUNTRIES_BASE_URL = "https://api.api-ninjas.com/v1/country?name="
        const val GEOLOCATION_BASE_URL = "https://api.api-ninjas.com/v1/geocoding?city="
        const val CITY_BASE_URL = "https://api.api-ninjas.com/v1/city?name="
        const val PLACEHOLDER_BASE_URL = "https://google.com/"
        const val WEATHER_BASE_URL = "https://api.openweathermap.org/data/2.5/weather"
        const val EXCHANGERATE_BASE_URL = "https://v6.exchangerate-api.com/v6/{API}/latest/"
        //const val COUNTRIES_BASE_URL = "https://api.worldbank.org/v2"
    }
}