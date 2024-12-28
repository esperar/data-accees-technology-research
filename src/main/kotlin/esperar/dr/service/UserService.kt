package esperar.dr.service

import esperar.dr.protocol.UserProtocol
import esperar.dr.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun selectUserById(userId: Long) = userRepository.selectUserById(userId)

    fun insertUser(request: UserProtocol.InsertUserRequest) = userRepository.insertUser(request)

    fun deleteUserById(userId: Long) = userRepository.deleteUserById(userId)

    fun updateUserGirlfriend(userId: Long, girlfriendId: Long) = userRepository.updateUserGirlfriend(userId, girlfriendId)
}