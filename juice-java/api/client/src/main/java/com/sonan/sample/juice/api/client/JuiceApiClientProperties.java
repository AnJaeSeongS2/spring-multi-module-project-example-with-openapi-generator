package com.sonan.sample.juice.api.client;

import lombok.Data;
import lombok.Getter;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

/**
 * @author: jaeseong_an
 * @github: https://github.com/AnJaeSeongS2
 * @since: 2021-08-19
 */

@Validated
@ConstructorBinding
@ConfigurationProperties("juice.api")
@Data
@Getter
public class JuiceApiClientProperties {

    @URL
    @NotBlank
    private final String baseUrl;

    @NotBlank
    private final String userAgent;
}
