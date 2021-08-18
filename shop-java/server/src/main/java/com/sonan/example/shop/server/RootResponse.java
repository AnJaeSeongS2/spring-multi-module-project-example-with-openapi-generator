package com.sonan.example.shop.server;

import com.linecorp.sample.juice.protocol.Juice;
import com.sonan.sample.coffee.protocol.Coffee;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class RootResponse {
    private final Coffee coffee;
    private final Juice juice;
}