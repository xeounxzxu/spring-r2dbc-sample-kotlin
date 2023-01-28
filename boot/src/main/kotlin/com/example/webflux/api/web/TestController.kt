package com.example.webflux.api.web

import com.example.webflux.core.aop.RequestTraceLogger
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class TestController {

    @GetMapping
    @RequestTraceLogger
    suspend fun getTestString(): String = "test"
}
