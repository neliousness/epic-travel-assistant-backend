package mz.co.vodacom.challenge.epictravelassistant.configs

import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
class PasswordConfig {

    /**
     * Configures password encoder
     */
    @Bean
    fun getPassword() = BCryptPasswordEncoder()
}