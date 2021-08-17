package com.sonan.sample.coffee.api.client;

import lombok.Data;
import lombok.Getter;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

/**
 * @author: Jaeseong An
 * @since: JEUS 21.0.0.0
 * Created Date: 2021-08-17
 */

@Validated
@ConstructorBinding
@ConfigurationProperties("coffee.api")
@Data
@Getter
public class CoffeeApiClientProperties {
    @URL
    @NotBlank
    private final String baseUrl;
}
