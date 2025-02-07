package com.linecorp.sample.juice.api.server

import com.sonan.example.model.Juice
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.function.server.*
import reactor.kotlin.core.publisher.toMono

@SpringBootApplication
class JuiceApplication {
    @Bean
    fun handler() = RouterFunctions.nest(RequestPredicates.path("/"), router {
        GET("") {
            ServerResponse.ok().body(Juice().name("juice").toMono())
        }
    })
}

fun main(args: Array<String>) {
    runApplication<JuiceApplication>(*args)
}
