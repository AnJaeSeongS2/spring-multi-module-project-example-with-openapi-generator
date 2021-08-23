package com.sonan.sample.juice.api.client;

import com.sonan.example.model.Juice;
import reactor.core.publisher.Mono;
import retrofit2.http.GET;

/**
 * Recipe of registering implementation mapping into converter side.
 * Please check [JuiceApiClientAutoConfiguration] also.
 *
 * Pros. Can hide this implementation class from out side of ths module.
 * Cons. Dependent on deserialization feature. jackson supports this, but others may not.
 */

public interface JuiceApi {

    @GET("/")
    Mono<Juice> get();
}