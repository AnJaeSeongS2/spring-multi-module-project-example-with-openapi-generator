package com.sonan.example.shop.server;

import com.sonan.example.model.Coffee;
import com.sonan.example.model.Juice;
import com.sonan.example.model.RootResponse;
import com.sonan.example.shop.server.coffee.CoffeeService;
import com.sonan.example.shop.server.juice.JuiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class BeverageController {
    private final CoffeeService coffeeService;
    private final JuiceService juiceService;

    @Autowired
    private BeverageController(CoffeeService coffeeService, JuiceService juiceService) {
        this.coffeeService = coffeeService;
        this.juiceService = juiceService;
    }

    @GetMapping("/")
    Mono<RootResponse> getRoot() {
        return Mono.zip(coffeeService.get(), juiceService.get()).flatMap(data ->
            Mono.just(new RootResponse().coffee(data.getT1()).juice(data.getT2()))
        );
    }

    @GetMapping("/coffee")
    Mono<Coffee> getCoffee() {
        return coffeeService.get();
    }

    @GetMapping("/juice")
    Mono<Juice> getJuice() {
        return juiceService.get();
    }
}
