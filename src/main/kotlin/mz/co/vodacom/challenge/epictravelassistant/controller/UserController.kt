package mz.co.vodacom.challenge.epictravelassistant.controller

import mz.co.vodacom.challenge.epictravelassistant.models.dtos.UserDto
import mz.co.vodacom.challenge.epictravelassistant.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/user")
class UserController( val userService: UserService) {

    /**
     * Registers a user making with their email and password
     */
    @PostMapping("/register")
    fun register(@RequestBody userDto : UserDto): ResponseEntity<Any> = ResponseEntity
        .status(HttpStatus.CREATED)
        .body(userService.register(userDto))


    /**
     * Signs a user in using their credentials
     */
    @PostMapping("/signIn")
    fun signIn(@RequestBody userDto : UserDto): ResponseEntity<Any> = ResponseEntity
        .status(HttpStatus.OK)
        .body(userService.signIn(userDto))
}