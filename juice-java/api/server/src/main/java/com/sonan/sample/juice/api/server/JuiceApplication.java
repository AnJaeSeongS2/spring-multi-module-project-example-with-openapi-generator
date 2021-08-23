package com.sonan.sample.juice.api.server;

import com.sonan.example.model.Juice;
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
public class JuiceApplication {

    @Bean
    public RouterFunction<ServerResponse> handler() {
        return nest(
            path("/"),
            route().GET("", (req) -> ServerResponse.ok().body(Mono.just(new Juice().name("juice-java")), Juice.class)).build()
        );
    }

    public static void main(String[] args) {
        SpringApplication.run(JuiceApplication.class, args);
    }
}
