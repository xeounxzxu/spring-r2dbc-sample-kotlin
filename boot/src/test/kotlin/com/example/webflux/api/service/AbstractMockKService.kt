package com.example.webflux.api.service

import io.mockk.MockKAnnotations
import org.junit.jupiter.api.BeforeEach

abstract class AbstractMockKService {

    @BeforeEach
    fun init() {
        MockKAnnotations.init(this)
    }
}