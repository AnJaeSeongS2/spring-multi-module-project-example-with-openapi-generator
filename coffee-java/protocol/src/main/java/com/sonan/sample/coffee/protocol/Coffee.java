package com.sonan.sample.coffee.protocol;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Coffee {
    private final String name;
    private final String countryOfOrigin;
}
