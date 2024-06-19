package mz.co.vodacom.challenge.epictravelassistant.services

import mz.co.vodacom.challenge.epictravelassistant.models.dtos.UserDto
import mz.co.vodacom.challenge.epictravelassistant.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun register(userDto: UserDto) : String  = "created"
}