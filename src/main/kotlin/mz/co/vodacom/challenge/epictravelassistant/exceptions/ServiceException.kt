package mz.co.vodacom.challenge.epictravelassistant.exceptions

import org.springframework.http.HttpStatus

class ServiceException(message: String, val status: HttpStatus) : RuntimeException(message)