package aj.random.playground

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.kotlin.coroutine.EnableCoroutine

@SpringBootApplication
@EnableCoroutine
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}