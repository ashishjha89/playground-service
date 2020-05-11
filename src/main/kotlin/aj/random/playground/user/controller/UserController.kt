package aj.random.playground.user.controller

import aj.random.playground.common.ResourceStatus
import aj.random.playground.user.model.User
import aj.random.playground.user.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController(private val userService: UserService) {

    @GetMapping("")
    suspend fun user(@RequestParam(value = "id") id: String): ResponseEntity<*> {
        val userRes = userService.getUser(userId = id)
        return when (userRes.status) {
            ResourceStatus.SUCCESS -> ResponseEntity<User>(userRes.data, userRes.httpStatus)
            ResourceStatus.ERROR -> ResponseEntity(userRes.errorBody, userRes.httpStatus)
        }
    }

}