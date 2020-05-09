package aj.random.playground.user

import aj.random.playground.common.ErrorBody
import aj.random.playground.user.model.User
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserIntegrationTest {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun `assert correct user is sent in response when valid userId is passed as query parameter`() {
        val result = restTemplate.getForEntity("/api/user?id=1", User::class.java)
        assertNotNull(result)
        assertEquals(HttpStatus.OK, result.statusCode)
    }

    @Test
    fun `assert error response is sent when missingId userId is passed as query parameter`() {
        val result = restTemplate.getForEntity("/api/user?id=missingId", ErrorBody::class.java)
        assertNotNull(result)
        assertEquals(HttpStatus.BAD_REQUEST, result.statusCode)
    }

}