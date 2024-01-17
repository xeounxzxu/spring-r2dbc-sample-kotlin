package com.example.webflux.api.service

import io.mockk.MockKAnnotations
import org.junit.jupiter.api.BeforeEach

abstract class AbstractMockKService {

    @BeforeEach
    open fun init() {
        MockKAnnotations.init(this)
    }
}
