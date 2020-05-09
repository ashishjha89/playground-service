package aj.random.playground.user.repo

import aj.random.playground.user.model.User
import aj.random.playground.user.repo.constants.userList
import kotlinx.coroutines.delay
import org.springframework.stereotype.Repository

@Repository
class UserRepo {

    suspend fun getUser(userId: String): User? {
        delay(100) // imitate IO operation
        return userList.firstOrNull { it.id == userId }
    }
}