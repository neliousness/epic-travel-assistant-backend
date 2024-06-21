package mz.co.vodacom.challenge.epictravelassistant.controller.handlers

import mz.co.vodacom.challenge.epictravelassistant.models.dtos.ErrorDto
import mz.co.vodacom.challenge.epictravelassistant.exceptions.ServiceException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody

@ControllerAdvice
class ApiExceptionHandler {

    @ExceptionHandler(ServiceException::class)
    @ResponseBody
    fun handleException(ex: ServiceException): ResponseEntity<ErrorDto> {
        val errorDto = ErrorDto(
            message = ex.message ?: "An unexpected error occurred"
        )
        return ResponseEntity.status(ex.status).body(errorDto)
    }
}