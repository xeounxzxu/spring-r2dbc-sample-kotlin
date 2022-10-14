package com.example.webflux.querydsl

import com.example.webflux.domain.Item
import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.test.StepVerifier
import java.util.function.Predicate

class ItemQuerydslRepositoryTest(private val repository: ItemQuerydslRepository) : TestBase() {

    @Test
    fun `전체 조회 Projections 테스트 케이스`() {

        val item1 = Item("test1")
        val item2 = Item("test2")
        val item3 = Item("test3")

        val given: Flux<Item> = repository.saveAll(
            listOf(item1, item2, item3)
        )

        val actual: Flux<Item> = given.thenMany(repository.findAll())

        StepVerifier.create(actual)
            .expectNextMatches(itemEntity(item1.name!!))
            .expectNextMatches(itemEntity(item2.name!!))
            .expectNextMatches(itemEntity(item3.name!!))
            .verifyComplete()
    }

    private fun itemEntity(fooBarValue: String): Predicate<Item> {
        return Predicate<Item> { entity: Item ->
            then(entity).isEqualTo(Item(entity.name!!))
            true
        }
    }
}