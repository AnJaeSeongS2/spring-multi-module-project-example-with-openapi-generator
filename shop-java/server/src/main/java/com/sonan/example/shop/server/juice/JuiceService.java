package com.sonan.example.shop.server.juice;

import com.sonan.example.model.Juice;
import com.sonan.sample.juice.api.client.JuiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class JuiceService {
    private final JuiceApi api;

    @Autowired
    private JuiceService(JuiceApi api) {
        this.api = api;
    }

    public Mono<Juice> get() {
        return api.get();
    }
}
