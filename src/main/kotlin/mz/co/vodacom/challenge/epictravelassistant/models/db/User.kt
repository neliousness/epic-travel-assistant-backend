package mz.co.vodacom.challenge.epictravelassistant.models.db

import mz.co.vodacom.challenge.epictravelassistant.utils.ModelUtils
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document("users")
class User(@Id val id: String, val email: String, val password: String) {
    override fun toString() = ModelUtils.toObjectJson(this)
}