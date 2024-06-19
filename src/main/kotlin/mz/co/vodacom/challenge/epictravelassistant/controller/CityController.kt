package mz.co.vodacom.challenge.epictravelassistant.controller

import mz.co.vodacom.challenge.epictravelassistant.services.CityService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/city")
class CityController(val cityService: CityService) {

    @GetMapping("/byName")
    fun searchByName(@RequestParam("city") cityName: String): ResponseEntity<Any?> = ResponseEntity
        .status(HttpStatus.OK)
        .body(cityService.searchByName(cityName))
}