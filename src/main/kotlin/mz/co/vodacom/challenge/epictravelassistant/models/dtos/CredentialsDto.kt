package mz.co.vodacom.challenge.epictravelassistant.models.dtos

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
class CredentialsDto(val email : String, val password : CharArray )