package mz.co.vodacom.challenge.epictravelassistant.configs.filters

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import lombok.RequiredArgsConstructor
import mz.co.vodacom.challenge.epictravelassistant.configs.providers.UserAuthProvider
import org.springframework.http.HttpHeaders
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter

@RequiredArgsConstructor
class JwtAuthFilter(private val userAuthProvider: UserAuthProvider) : OncePerRequestFilter() {

    /**
     * Checks for and validates JWT tokens
     */
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {

        val header = request.getHeader(HttpHeaders.AUTHORIZATION)

        if (header != null) {
            val elements = header.split(" ")

            if (elements.size == 2 && "Bearer".equals(elements.get(0))) {
                try {
                    SecurityContextHolder.getContext().authentication = userAuthProvider.validateToken(elements.get(1))
                } catch (e: RuntimeException) {
                    SecurityContextHolder.clearContext()
                    throw e
                }
            }
        }
        filterChain.doFilter(request, response)
    }


}
