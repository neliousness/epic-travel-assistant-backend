package mz.co.vodacom.challenge.epictravelassistant.services

import mz.co.vodacom.challenge.epictravelassistant.exceptions.ServiceException
import mz.co.vodacom.challenge.epictravelassistant.models.dtos.CredentialsDto
import mz.co.vodacom.challenge.epictravelassistant.models.dtos.UserDto
import mz.co.vodacom.challenge.epictravelassistant.repositories.UserRepository
import mz.co.vodacom.challenge.epictravelassistant.utils.constants.CommonConstants.Companion.EMPTY
import mz.co.vodacom.challenge.epictravelassistant.utils.extensions.toDto
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.nio.CharBuffer

@Service
class UserService(private val userRepository: UserRepository, private val passwordEncoder: PasswordEncoder) {
    fun register(userDto: UserDto): UserDto {
        val user = userRepository.findUserByEmail(userDto.email ?: EMPTY)
        if (user.isPresent) {
            throw ServiceException("Email already exists", HttpStatus.BAD_REQUEST)
        }

        val newUser = userDto.toUser()
        newUser.password = passwordEncoder
            .encode(CharBuffer.wrap(newUser.password?.toCharArray()))
        val savedUser = userRepository.save(newUser)

        return savedUser.toDto()
    }

    fun signIn(credentialsDto: CredentialsDto): UserDto {
        val user = userRepository.findUserByEmail(credentialsDto.email).orElseThrow { ServiceException("User not found", HttpStatus.NOT_FOUND) }

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password), user.password.toString())) {
            return user.toDto()
        }
        throw ServiceException("Invalid password", HttpStatus.BAD_REQUEST)
    }


    fun findByEmailToDto(email: String): UserDto? = userRepository.findUserByEmail(email).orElseThrow { ServiceException("User not found", HttpStatus.NOT_FOUND) }.toDto()
}