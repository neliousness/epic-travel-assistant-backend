package mz.co.vodacom.challenge.epictravelassistant.repositories

import org.springframework.stereotype.Component

@Component
class ConfigurationRepository {

    /**
     * Locally defines app specific configurations
     */
    companion object {
        @JvmStatic
        fun showDebugLogs() = true
    }

}