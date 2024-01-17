package com.example.webflux

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication


@SpringBootApplication
@ConfigurationPropertiesScan
class CallbackBootApplication

fun main(args: Array<String>) {
    runApplication<CallbackBootApplication>(*args)
}
