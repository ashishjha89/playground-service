package aj.random.playground.user.repo

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class UserRepoTest {

    private val userRepo = UserRepo()

    @Test
    fun `assert user is returned if valid userId is passed`() = runBlockingTest {
        val result = userRepo.getUser(userId = "1")
        assertNotNull(result)
        assertEquals("1", result?.id)
    }

    @Test
    fun `assert null is returned if missing userId is passed`() = runBlockingTest {
        val result = userRepo.getUser(userId = "missingId")
        assertNull(result)
    }
}