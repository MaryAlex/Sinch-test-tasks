package problem3.plugins

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.request.receive
import io.ktor.response.respondText
import io.ktor.routing.post
import io.ktor.routing.routing
import problem3.service.calculatePolishNotation

fun Application.configureRouting() {
    routing {
        post("/polish-notation") {
            call.respondText(calculatePolishNotation(call.receive()))
        }
    }
}

