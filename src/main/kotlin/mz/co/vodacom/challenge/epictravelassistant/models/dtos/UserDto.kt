package mz.co.vodacom.challenge.epictravelassistant.models.dtos

import mz.co.vodacom.challenge.epictravelassistant.models.db.User
import java.util.UUID

data class UserDto(val email: String?, val password: String?) {
   fun toUser() = User(email = email, password = password, id = UUID.randomUUID().toString())
}
