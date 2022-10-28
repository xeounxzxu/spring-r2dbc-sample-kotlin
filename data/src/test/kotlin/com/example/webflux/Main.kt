package com.example.webflux

import com.infobip.spring.data.r2dbc.EnableQuerydslR2dbcRepositories
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder

@EnableQuerydslR2dbcRepositories
@SpringBootApplication
class Main {

    fun main(args: Array<String>) {
        SpringApplicationBuilder(Main::class.java).run(*args)
    }
}
