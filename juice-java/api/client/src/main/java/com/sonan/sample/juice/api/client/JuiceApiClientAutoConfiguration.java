package com.sonan.sample.juice.api.client;

import com.jakewharton.retrofit2.adapter.reactor.ReactorCallAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
@EnableConfigurationProperties(JuiceApiClientProperties.class)
public class JuiceApiClientAutoConfiguration {

    @Bean
    JuiceApi juiceApi(JuiceApiClientProperties properties) {
        return new Retrofit.Builder()
            .client(new OkHttpClient()
                .newBuilder()
                .addInterceptor( chain -> {
                        Request request = chain.request()
                            .newBuilder()
                            .addHeader("User-Agent", properties.getUserAgent())
                            .build();
                        return chain.proceed(request);
                })
                .build()
            )
            .baseUrl(properties.getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(ReactorCallAdapterFactory.create())
            .build()
            .create(JuiceApi.class);
    }
}