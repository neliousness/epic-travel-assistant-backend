package mz.co.vodacom.challenge.epictravelassistant.configs

import lombok.RequiredArgsConstructor
import mz.co.vodacom.challenge.epictravelassistant.configs.filters.JwtAuthFilter
import mz.co.vodacom.challenge.epictravelassistant.configs.providers.UserAuthProvider
import mz.co.vodacom.challenge.epictravelassistant.utils.constants.CommonConstants.Companion.CITY_ENDPOINT
import mz.co.vodacom.challenge.epictravelassistant.utils.constants.CommonConstants.Companion.LOGIN_ENDPOINT
import mz.co.vodacom.challenge.epictravelassistant.utils.constants.CommonConstants.Companion.REGISTER_ENDPOINT
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
class SecurityConfig(val userAuthenticationEntryPoint: UserAuthenticationEntryPoint, val userAuthProvider: UserAuthProvider) {


    /**
     * Disables CSRF, defines JWT filter, sets session management as stateless (to prevent holding session cookies), specifies public endpoints
     */
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.exceptionHandling().authenticationEntryPoint(userAuthenticationEntryPoint)
            .and()
            .addFilterBefore(JwtAuthFilter(userAuthProvider), BasicAuthenticationFilter::class.java) // Replace `null` with your custom filter if any
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeHttpRequests { requests ->
                requests
                    .requestMatchers(HttpMethod.POST, LOGIN_ENDPOINT, REGISTER_ENDPOINT, CITY_ENDPOINT).permitAll()
                    .anyRequest().authenticated()
            }
        return http.build()
    }
}
