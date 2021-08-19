package com.linecorp.sample.coffee.api.client

import com.fasterxml.jackson.core.Version
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.jakewharton.retrofit2.adapter.reactor.ReactorCallAdapterFactory
import com.linecorp.sample.coffee.protocol.Coffee
import com.linecorp.sample.coffee.protocol.CoffeeResponse
import org.hibernate.validator.constraints.URL
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.validation.annotation.Validated
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.create
import javax.validation.constraints.NotBlank

@Configuration
@EnableConfigurationProperties(CoffeeApiClientProperties::class)
class CoffeeApiClientAutoConfiguration {
    @Bean
    fun coffeeApi(properties: CoffeeApiClientProperties) = Retrofit
            .Builder()
            .baseUrl(properties.baseUrl)
            .addConverterFactory(JacksonConverterFactory.create(jacksonObjectMapper().registerTypeModule<Coffee, CoffeeResponse>()))
            .addCallAdapterFactory(ReactorCallAdapterFactory.create())
            .build()
            .create<CoffeeApi>()
}

inline fun <reified INTERFACE, reified IMPLEMENTATION : INTERFACE> ObjectMapper.registerTypeModule(): ObjectMapper = registerModule(typeModule<INTERFACE, IMPLEMENTATION>())

inline fun <reified INTERFACE, reified IMPLEMENTATION : INTERFACE> typeModule() = SimpleModule("CoffeeResolver", Version.unknownVersion()).apply {
        setAbstractTypes(SimpleAbstractTypeResolver().addMapping(INTERFACE::class.java, IMPLEMENTATION::class.java))
}

@Validated
@ConstructorBinding
@ConfigurationProperties("coffee.api")
data class CoffeeApiClientProperties(
        @URL
        @NotBlank
        val baseUrl: String
)
