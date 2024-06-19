package mz.co.vodacom.challenge.epictravelassistant.utils.log


import mz.co.vodacom.challenge.epictravelassistant.repositories.ConfigurationRepository.Companion.showDebugLogs
import java.util.logging.Level
import java.util.logging.Logger

class LogUtils {

    companion object {
        @JvmStatic
        fun log(o: Any, message: String?, override: Boolean = false) {
            if (showDebugLogs() || override) {
                val logger1 = Logger.getLogger(o.javaClass.name)
                val formattedMessage = String.format(
                    "%s",
                    message
                )
                logger1.log(Level.INFO, formattedMessage)
            }
        }

        @JvmStatic
        fun logErr(o: Any, message: String?, override: Boolean = false) {
            if (showDebugLogs() || override) {
                val logger1 = Logger.getLogger(o.javaClass.name)
                val formattedMessage = String.format(
                    "%s",
                    message
                )
                logger1.log(Level.SEVERE, formattedMessage)
            }
        }

        @JvmStatic
        fun logDebug(o: Any, message: String?) {
            if (showDebugLogs()) {
                val logger1 = Logger.getLogger(o.javaClass.name)
                val formattedMessage = String.format(
                    "%s",
                    message
                )
                logger1.log(Level.INFO, formattedMessage)
            }
        }

        @JvmStatic
        fun logWarn(o: Any, message: String?, override: Boolean = false) {
            if (showDebugLogs() || override) {
                val logger1 = Logger.getLogger(o.javaClass.name)
                val formattedMessage = String.format(
                    "%s",
                    message
                )
                logger1.log(Level.WARNING, formattedMessage)
            }
        }
    }

}