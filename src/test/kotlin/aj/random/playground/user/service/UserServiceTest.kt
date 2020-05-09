package aj.random.playground.user.service

import aj.random.playground.common.ResourceStatus
import aj.random.playground.user.model.User
import aj.random.playground.user.repo.UserRepo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.http.HttpStatus

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class UserServiceTest {

    @Mock
    private lateinit var userRepo: UserRepo

    @InjectMocks
    private lateinit var userService: UserService

    @Test
    fun `assert success(user) is returned if repo returns a user`() = runBlockingTest {
        val user = mock(User::class.java)
        given(userRepo.getUser(userId = "1")).willReturn(user)
        val result = userService.getUser(userId = "1")
        assertEquals(HttpStatus.OK, result.httpStatus)
        assertEquals(ResourceStatus.SUCCESS, result.status)
        assertEquals(user, result.data)
        assertNull(result.errorBody)
    }

    @Test
    fun `assert error(user) is returned if repo returns null`() = runBlockingTest {
        given(userRepo.getUser(userId = "missingId")).willReturn(null)
        val result = userService.getUser(userId = "missingId")
        assertEquals(HttpStatus.BAD_REQUEST, result.httpStatus)
        assertEquals(ResourceStatus.ERROR, result.status)
        assertNull(result.data)
        assertNotNull(result.errorBody)
    }
}