package com.example.r2dbc.callback

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication(
    scanBasePackages = [
        "com.example.r2dbc",
    ],
)
@ConfigurationPropertiesScan
class CallbackApplication

fun main(args: Array<String>) {
    runApplication<CallbackApplication>(*args)
}
