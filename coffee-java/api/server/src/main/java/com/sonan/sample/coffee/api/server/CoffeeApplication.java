package com.sonan.sample.coffee.api.server;

import com.sonan.example.model.Coffee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
public class CoffeeApplication {
    @Bean
    public RouterFunction<ServerResponse> handler() {
        return nest(
            path("/"),
            route().GET("", (req) -> ServerResponse.ok().body(Mono.just(new Coffee().name("coffee-java").countryOfOrigin("Jamaica-java")), Coffee.class)).build()
        );
    }

    public static void main(String[] args) {
        SpringApplication.run(CoffeeApplication.class, args);
    }
}

