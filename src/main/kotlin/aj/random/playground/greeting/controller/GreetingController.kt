package aj.random.playground.greeting.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/greeting")
class GreetingController {

    @GetMapping("")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) = "Hello $name"

}