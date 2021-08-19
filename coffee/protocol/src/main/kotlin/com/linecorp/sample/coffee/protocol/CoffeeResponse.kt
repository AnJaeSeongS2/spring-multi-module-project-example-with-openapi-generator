package com.linecorp.sample.coffee.protocol

/**
 * @author: jaeseong_an
 * @github: https://github.com/AnJaeSeongS2
 * @since: 2021-08-19
 */
data class CoffeeResponse(override val name: String, override val countryOfOrigin: String) : Coffee