package esperar.dr.table

import esperar.dr.model.User
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

object UserTable : Table("user") {
    val userId = long("user_id").autoIncrement()
    val username = varchar("username", 10)
    val address = varchar("address", 50)
    val email = varchar("email", 50)
    val girlfriend = long("girlfriend_id").nullable()
    val createdAt = datetime("created_at").clientDefault { LocalDateTime.now() }
    override val primaryKey = PrimaryKey(userId)
}

