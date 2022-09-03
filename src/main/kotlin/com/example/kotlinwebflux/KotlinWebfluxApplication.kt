package com.example.kotlinwebflux

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class KotlinWebfluxApplication

fun main(args: Array<String>) {
    runApplication<KotlinWebfluxApplication>(*args)
}
