package esperar.dr.protocol

class UserProtocol {

    data class InsertUserRequest(
        val username: String,
        val address: String,
        val email: String,
        val girlfriend: Long?
    )

}