package esperar.dr.model

import java.time.LocalDateTime

data class User(
    val userId: Long,
    val username: String,
    val address: String,
    val email: String,
    val girlfriend: Long?,
    val createdAt: LocalDateTime
)
