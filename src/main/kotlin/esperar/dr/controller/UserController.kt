package esperar.dr.controller

import esperar.dr.protocol.UserProtocol
import esperar.dr.service.UserService
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class UserController(
    private val userService: UserService
) {

    companion object {
        const val INSERT_PATH = "/user/insert"
        const val UPDATE_GIRLFRIEND_PATH = "/user/update-girlfriend"
        const val USER_DEFAULT_ID = "/user/{id}"
    }

    @RequestMapping(INSERT_PATH, method = [RequestMethod.POST])
    @ResponseStatus(value = HttpStatus.CREATED)
    fun insertUser(@RequestBody request: UserProtocol.InsertUserRequest): Long {
        val result = transaction {
            userService.insertUser(request)
        }
        return result
    }

    @RequestMapping(UPDATE_GIRLFRIEND_PATH, method = [RequestMethod.PUT])
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun updateUserGirlfriend(@RequestParam userId: Long, @RequestParam girlfriendId: Long) {
        transaction {
            userService.updateUserGirlfriend(userId, girlfriendId)
        }
    }

    @RequestMapping(USER_DEFAULT_ID, method = [RequestMethod.GET])
    @ResponseStatus(value = HttpStatus.OK)
    fun selectUserById(@PathVariable id: Long) = userService.selectUserById(id)

    @RequestMapping(USER_DEFAULT_ID, method = [RequestMethod.DELETE])
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun deleteUserById(@PathVariable id: Long) {
        transaction {
            userService.deleteUserById(id)
        }
    }

}