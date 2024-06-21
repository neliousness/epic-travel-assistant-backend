package mz.co.vodacom.challenge.epictravelassistant.utils.extensions

import mz.co.vodacom.challenge.epictravelassistant.models.db.User
import mz.co.vodacom.challenge.epictravelassistant.models.dtos.UserDto

fun User.toDto(): UserDto = UserDto(email = this.email, id = this.id, password = this.password, name = this.name, surname = this.surname)

