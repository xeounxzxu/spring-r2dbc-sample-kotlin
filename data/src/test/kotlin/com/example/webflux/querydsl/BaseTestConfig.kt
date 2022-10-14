package com.example.webflux.querydsl

import com.example.webflux.Main
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.test.context.TestConstructor
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.util.stream.Collectors
import java.util.stream.Stream

@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = [Main::class])
abstract class TestBase {

    @Autowired
    private val repositories: List<ReactiveCrudRepository<*, *>>? = null

    @AfterEach
    fun clearRepositories() {
        block(Flux.concat(
            repositories!!.stream()
                .map { obj: ReactiveCrudRepository<*, *> -> obj.deleteAll() }
                .collect(Collectors.toList()))
            .collectList())
    }

    private fun <T> block(mono: Mono<T>): T? {
        return mono.block(Duration.ofSeconds(10))
    }

    fun <T> block(flux: Flux<T>): List<T>? {
        return block(flux.collectList())
    }

    protected fun given(vararg ts: Mono<*>?): Mono<Void> {
        return Flux.concat(Stream.of(*ts).collect(Collectors.toList())).last().then()
    }
}
