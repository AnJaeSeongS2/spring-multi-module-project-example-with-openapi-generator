package com.sonan.example.shop.server.coffee;

import com.sonan.sample.coffee.api.client.CoffeeApi;
import com.sonan.sample.coffee.protocol.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CoffeeService {
    private final CoffeeApi api;

    @Autowired
    private CoffeeService(CoffeeApi api) {
        this.api = api;
    }

    public Mono<Coffee> get() {
        return api.get();
    }
}
