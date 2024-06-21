package mz.co.vodacom.challenge.epictravelassistant.models.dtos

import mz.co.vodacom.challenge.epictravelassistant.models.db.User

data class UserDto(val email: String?, val password: String? = null, var token: String? = null, var id: String? = null, val name: String, val surname: String) {
    fun toUser() = User(email = email, password = password, name = name, surname = surname)
}
