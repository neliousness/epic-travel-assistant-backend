package mz.co.vodacom.challenge.epictravelassistant.configs.providers

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import jakarta.annotation.PostConstruct
import lombok.RequiredArgsConstructor
import mz.co.vodacom.challenge.epictravelassistant.services.UserService
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.util.*

@RequiredArgsConstructor
@Component
class UserAuthProvider(val userService: UserService) {

    @Value("\${secret.jwt.token.secret-key:secret-value}")
    private lateinit var secretKey: String


    @PostConstruct
    protected fun init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.toByteArray())
    }

    /**
     * Creates a JWT token that is valid for 1hr
     */
    fun createToken(email: String?): String {
        val validity = Date(Date().time + 3_600_000)
        return JWT.create()
            .withIssuer(email)
            .withIssuedAt(Date())
            .withExpiresAt(validity)
            .sign(Algorithm.HMAC256(secretKey))
    }

    fun validateToken(token : String?) : Authentication {
        val verifier : JWTVerifier = JWT.require(Algorithm.HMAC256(secretKey)).build()

        val decoded = verifier.verify(token)

        val userDto = userService.findByEmailToDto(decoded.issuer)

        return  UsernamePasswordAuthenticationToken(userDto, null, Collections.emptyList())
    }

}
