package com.example.webflux.api.web

import com.example.webflux.core.aop.RequestLogger
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class TestController {

    @GetMapping
    @RequestLogger
    suspend fun getTestString(): String = "test"
}
