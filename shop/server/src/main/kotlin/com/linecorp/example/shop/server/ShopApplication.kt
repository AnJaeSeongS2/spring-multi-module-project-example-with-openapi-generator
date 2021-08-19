package com.linecorp.example.shop.server

import com.linecorp.example.shop.server.coffee.CoffeeService
import com.linecorp.example.shop.server.juice.JuiceService
import com.linecorp.sample.coffee.protocol.Coffee
import com.linecorp.sample.juice.protocol.Juice
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@SpringBootApplication
class ShopApplication

fun main(args: Array<String>) {
    runApplication<ShopApplication>(*args)
}

data class RootResponse(val coffee: Coffee, val juice: Juice)

@RestController
class BeverageController(
        private val coffeeService: CoffeeService,
        private val juiceService: JuiceService
) {
    @GetMapping("/")
    fun getRoot() = Mono.zip(coffeeService.get(), juiceService.get()).flatMap { data ->
        Mono.just(RootResponse(data.t1, data.t2))
    }

    @GetMapping("/coffee")
    fun getCoffee() = coffeeService.get()

    @GetMapping("/juice")
    fun getJuice() = juiceService.get()
}
