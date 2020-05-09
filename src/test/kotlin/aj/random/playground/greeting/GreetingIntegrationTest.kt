package aj.random.playground.greeting

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
class GreetingIntegrationTest {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun `greeting returns 'Hello World' when no query parameter is passed`() {
        val result = restTemplate.getForEntity("/api/greeting", String::class.java)
        assertNotNull(result)
        assertEquals(HttpStatus.OK, result.statusCode)
        assertEquals("Hello World", result.body)
    }

    @Test
    fun `greeting returns 'Hello Name' when name is passed as query parameter`() {
        val result = restTemplate.getForEntity("/api/greeting?name=Ashish", String::class.java)
        assertNotNull(result)
        assertEquals(HttpStatus.OK, result.statusCode)
        assertEquals("Hello Ashish", result.body)
    }

}