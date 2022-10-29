package com.example.webflux.querydsl

import com.example.webflux.config.AbstractQuerydslBaseTest
import com.example.webflux.config.QuerydslTestConfiguration
import com.example.webflux.domain.Item
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.springframework.test.context.ContextConfiguration
import reactor.core.publisher.Flux

@ContextConfiguration(
    classes = [
        QuerydslTestConfiguration::class
    ]
)
class ItemQuerydslRepositoryTest constructor(
    private val itemQuerydslRepository: ItemQuerydslRepository
) : AbstractQuerydslBaseTest() {

    @Test
    @Order(1)
    fun `전체 조회 Projections 테스트 케이스`() {
        val entities: Flux<Item> = itemQuerydslRepository.findAll()
        assertNotNull(entities)
    }
}