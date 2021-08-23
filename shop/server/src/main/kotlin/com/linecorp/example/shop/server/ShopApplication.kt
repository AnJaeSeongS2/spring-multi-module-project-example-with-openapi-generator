package com.linecorp.example.shop.server

import com.linecorp.example.shop.server.coffee.CoffeeService
import com.linecorp.example.shop.server.juice.JuiceService
import com.sonan.example.model.Coffee
import com.sonan.example.model.Juice
import com.sonan.example.model.RootResponse
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import reactor.util.function.Tuple2

@SpringBootApplication
class ShopApplication

fun main(args: Array<String>) {
    runApplication<ShopApplication>(*args)
}

@RestController
class BeverageController(
        private val coffeeService: CoffeeService,
        private val juiceService: JuiceService
) {
    @GetMapping("/")
    fun getRoot() = Mono.zip(coffeeService.get(), juiceService.get()).flatMap { data: Tuple2<Coffee, Juice> ->
        Mono.just(RootResponse().coffee(data.t1).juice(data.t2))
    }

    @GetMapping("/coffee")
    fun getCoffee() = coffeeService.get()

    @GetMapping("/juice")
    fun getJuice() = juiceService.get()
}
