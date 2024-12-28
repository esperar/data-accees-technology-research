package esperar.dr.repository

import esperar.dr.model.User
import esperar.dr.protocol.UserProtocol
import esperar.dr.table.UserTable
import esperar.dr.table.UserTable.userId
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.update
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional(transactionManager = "transactionManager")
class UserRepository {

    fun selectUserById(userId: Long): User? =
        UserTable.select(UserTable.userId eq userId)
        .map { UserTable.toModel(it) }
        .singleOrNull()

    fun insertUser(request: UserProtocol.InsertUserRequest): Long =
        UserTable.insert {
            it[username] = request.username
            it[address] = request.address
            it[email] = request.email
            it[girlfriend] = request.girlfriend
        }[userId]

    fun deleteUserById(userId: Long): Int =
        UserTable.deleteWhere {
            UserTable.userId eq userId
        }

    fun updateUserGirlfriend(userId: Long, girlfriendId: Long): Int =
        UserTable.update ({UserTable.userId eq userId}) {
            it[girlfriend] = girlfriendId
        }

}

fun UserTable.toModel(row: ResultRow): User {
    return User(
        userId = row[userId],
        username = row[username],
        address = row[address],
        email = row[email],
        girlfriend = row[girlfriend],
        createdAt = row[createdAt]
    )
}