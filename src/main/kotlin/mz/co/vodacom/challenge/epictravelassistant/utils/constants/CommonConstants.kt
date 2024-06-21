package mz.co.vodacom.challenge.epictravelassistant.utils.constants

class CommonConstants {

    companion object {
        val  INITIAL_COUNTRIES = listOf("London", "Tokyo", "Maputo", "Bali", "Cairo", "Paris")

        const val PLACEHOLDER_BASE_URL = "https://google.com/"
        const val CITY_BASE_URL = "https://restcountries.com/v3.1/capital/"
        const val WEATHER_BASE_URL = "https://api.openweathermap.org/data/2.5/weather?"
        const val EXCHANGERATE_BASE_URL = "https://v6.exchangerate-api.com/v6/{API}/latest/"

        const val EMPTY = ""

        //region public endpoints
        const val LOGIN_ENDPOINT = "/api/v1/user/login"
        const val CITY_ENDPOINT = "/api/v1/city"
        const val REGISTER_ENDPOINT = "/api/v1/user/register"
        //endregion public endpoints
    }
}