package mz.co.vodacom.challenge.epictravelassistant.repositories

import mz.co.vodacom.challenge.epictravelassistant.models.db.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import java.util.*


interface UserRepository : MongoRepository<User, String> {
    @Query("{'email': ?0}")
    fun findUserByEmail(email: String): Optional<User>
}