package mz.co.vodacom.challenge.epictravelassistant.configs

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import mz.co.vodacom.challenge.epictravelassistant.models.dtos.ErrorDto
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component



@Component
class UserAuthenticationEntryPoint : AuthenticationEntryPoint{

    companion object {
        val OBJECT_MAPPER = ObjectMapper()
    }

    /**
     * Sets all request responses statuses that have not been authorized to access a speific resource as 401 (Unauthorized)
     */
    override fun commence(request: HttpServletRequest?, response: HttpServletResponse?, authException: AuthenticationException?) {
      response?.status = HttpServletResponse.SC_UNAUTHORIZED
        response?.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        OBJECT_MAPPER.writeValue(response?.outputStream, ErrorDto("Unauthorized path") )
    }

}
