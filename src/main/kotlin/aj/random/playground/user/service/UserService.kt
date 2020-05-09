package aj.random.playground.user.service

import aj.random.playground.common.ErrorBody
import aj.random.playground.common.ErrorCode
import aj.random.playground.common.ErrorMessage
import aj.random.playground.common.Resource
import aj.random.playground.user.model.User
import aj.random.playground.user.repo.UserRepo
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepo: UserRepo) {

    suspend fun getUser(userId: String): Resource<User> {
        userRepo.getUser(userId)
        return when (val user = userRepo.getUser(userId)) {
            null -> Resource.error(
                    httpStatus = HttpStatus.BAD_REQUEST,
                    errorBody = ErrorBody(errorCode = ErrorCode.INVALID_USER_ID, errorMessage = ErrorMessage.invalidUserId))
            else -> Resource.success(data = user)
        }
    }
}