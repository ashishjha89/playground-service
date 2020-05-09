package aj.random.playground.greeting

import aj.random.playground.greeting.controller.GreetingController
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HelloControllerUnitTest {

    @InjectMocks
    lateinit var greetingController: GreetingController

    @Test
    fun `assert greeting is Hello Name`() {
        val result = greetingController.greeting(name = "Ashish")
        assertNotNull(result)
        assertEquals("Hello Ashish", result)
    }

}