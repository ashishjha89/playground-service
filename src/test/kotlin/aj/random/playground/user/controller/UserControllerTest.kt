package aj.random.playground.user.controller

import aj.random.playground.common.ErrorBody
import aj.random.playground.common.ErrorCode
import aj.random.playground.common.ErrorMessage
import aj.random.playground.common.Resource
import aj.random.playground.user.model.User
import aj.random.playground.user.service.UserService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.mock
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.http.HttpStatus

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class UserControllerTest {

    @Mock
    private lateinit var userService: UserService

    @InjectMocks
    private lateinit var userController: UserController

    @Test
    fun `assert user is sent in response if service returns success(user)`() = runBlockingTest {
        val user = mock(User::class.java)
        val userRes = Resource.success(data = user)
        given(userService.getUser(userId = "1")).willReturn(userRes as Resource<User>?)
        val responseEntity = userController.user(id = "1")
        assertEquals(userRes.data, responseEntity.body)
        assertEquals(userRes.httpStatus, responseEntity.statusCode)
    }

    @Test
    fun `assert error is sent in response if service returns error(user)`() = runBlockingTest {
        val userRes = Resource.error<User>(
                httpStatus = HttpStatus.BAD_REQUEST,
                errorBody = ErrorBody(errorCode = ErrorCode.INVALID_USER_ID, errorMessage = ErrorMessage.invalidUserId))
        given(userService.getUser(userId = "missingId")).willReturn(userRes as Resource<User>?)
        val responseEntity = userController.user(id = "missingId")
        assertEquals(userRes.errorBody, responseEntity.body)
        assertEquals(userRes.httpStatus, responseEntity.statusCode)
    }
}