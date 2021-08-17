package com.sonan.sample.coffee.api.client;

import com.sonan.sample.coffee.protocol.Coffee;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Recipe of expose specific implementation.
 * Pros. Most of deserialization libraries supports.
 *       And Don't need any verbose configuration.
 * Cons. This exposes concrete response class to outside.
 */
public interface CoffeeApi {
    @GET("/")
    Call<Coffee> getCoffee();
}
