package com.linecorp.sample.coffee.protocol

data class CoffeeResponse(override val name: String, override val countryOfOrigin: String) : Coffee