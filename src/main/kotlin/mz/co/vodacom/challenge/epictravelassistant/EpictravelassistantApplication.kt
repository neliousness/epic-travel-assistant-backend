package mz.co.vodacom.challenge.epictravelassistant

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
class EpictravelassistantApplication

fun main(args: Array<String>) {
    runApplication<EpictravelassistantApplication>(*args)
}
