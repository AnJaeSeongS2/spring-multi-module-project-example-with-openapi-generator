package com.linecorp.example.shop.server.coffee

import com.sonan.sample.coffee.api.client.CoffeeApi
import com.sonan.sample.coffee.protocol.Coffee
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CoffeeService(private val api: CoffeeApi) {
    fun get() = api.get()
}
