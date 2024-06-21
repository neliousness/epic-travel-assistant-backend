package mz.co.vodacom.challenge.epictravelassistant.controller

import mz.co.vodacom.challenge.epictravelassistant.configs.providers.UserAuthProvider
import mz.co.vodacom.challenge.epictravelassistant.models.dtos.CredentialsDto
import mz.co.vodacom.challenge.epictravelassistant.models.dtos.UserDto
import mz.co.vodacom.challenge.epictravelassistant.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("api/v1/user")
class UserController(val userService: UserService, val userAuthProvider: UserAuthProvider) {

    /**
     * Registers a user making with their email and password
     */
    @PostMapping("/register")
    fun register(@RequestBody userDto: UserDto): ResponseEntity<UserDto> {

        val registeredUserDto = userService.register(userDto)

        registeredUserDto.token = userAuthProvider.createToken(userDto.email)

        return ResponseEntity.created(URI.create("/")).body(registeredUserDto)
    }


    /**
     * Signs a user in using their credentials
     */
    @PostMapping("/login")
    fun login(@RequestBody credentialsDto: CredentialsDto): ResponseEntity<UserDto> {

        val userDto = userService.signIn(credentialsDto)

        userDto.token = userAuthProvider.createToken(userDto.email)

        return ResponseEntity.ok(userDto)
    }

    @PostMapping("/logout")
    fun logout(@RequestBody credentialsDto: CredentialsDto): ResponseEntity<UserDto> {

        val userDto = userService.signIn(credentialsDto)

        userDto.token = userAuthProvider.createToken(userDto.email)

        return ResponseEntity.ok(userDto)
    }
}