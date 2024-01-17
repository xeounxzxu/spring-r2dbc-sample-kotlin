package com.example.webflux

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication


@SpringBootApplication
@ConfigurationPropertiesScan
class BootApplication

fun main(args: Array<String>) {
    runApplication<BootApplication>(*args)
}
