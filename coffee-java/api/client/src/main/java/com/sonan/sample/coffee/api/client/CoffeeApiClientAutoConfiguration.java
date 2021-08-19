package com.sonan.sample.coffee.api.client;

import com.jakewharton.retrofit2.adapter.reactor.ReactorCallAdapterFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
@EnableConfigurationProperties(CoffeeApiClientProperties.class)
public class CoffeeApiClientAutoConfiguration {

    @Bean
    CoffeeApi coffeeApi(CoffeeApiClientProperties properties) {
        return new Retrofit
            .Builder()
            .baseUrl(properties.getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(ReactorCallAdapterFactory.create())
            .build()
            .create(CoffeeApi.class);
    }
}
