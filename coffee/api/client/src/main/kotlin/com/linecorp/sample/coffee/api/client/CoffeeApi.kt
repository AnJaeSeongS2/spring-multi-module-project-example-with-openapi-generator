package com.linecorp.sample.coffee.api.client

import com.linecorp.sample.coffee.protocol.Coffee
import reactor.core.publisher.Mono
import retrofit2.http.GET

/**
 * Recipe of expose specific implementation.
 * Pros. Most of deserialization libraries supports.
 *       And Don't need any verbose configuration.
 * Cons. This exposes concrete response class to outside.
 */
interface CoffeeApi {
    @GET("/")
    fun get(): Mono<Coffee>
}
