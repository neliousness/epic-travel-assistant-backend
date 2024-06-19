package mz.co.vodacom.challenge.epictravelassistant.utils

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature


class ModelUtils {

    companion object {

        fun toObjectJson(value: Any): String {
            val mapper = ObjectMapper()
            var jsonString = ""
            try {
                mapper.enable(SerializationFeature.INDENT_OUTPUT)
                jsonString = mapper.writeValueAsString(value)
            } catch (e: JsonProcessingException) {
                e.printStackTrace()
            }
            return jsonString
        }
    }


}