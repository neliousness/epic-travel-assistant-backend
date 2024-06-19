package mz.co.vodacom.challenge.epictravelassistant.services.api


import mz.co.vodacom.challenge.epictravelassistant.utils.constants.CommonConstants.Companion.PLACEHOLDER_BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.springframework.stereotype.Service
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Service
class ApiServiceGenerator {

    private val builder = Retrofit.Builder()
        .baseUrl(PLACEHOLDER_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())

    private var retrofit = builder.build()

    private val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()

    private val logging = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.NONE)

    fun <T> createService(serviceClass: Class<T>): T {
        if (!httpClient.interceptors().contains(logging)) {
            httpClient.addInterceptor(logging)
            builder.client(httpClient.build())
            retrofit = builder.build()
        }
        return retrofit.create(serviceClass)
    }

}