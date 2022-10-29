package com.example.webflux.querydsl

import com.example.webflux.config.AbstractQuerydslBaseTest
import com.example.webflux.config.QuerydslTestConfiguration
import com.example.webflux.domain.Item
import com.example.webflux.projection.ItemInfo
import com.example.webflux.util.MockUtil
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.springframework.test.context.ContextConfiguration
import reactor.core.publisher.Flux
import reactor.test.StepVerifier

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
    fun `find All not null checked`() {
        val entities: Flux<Item> = itemQuerydslRepository.findAll()
        assertNotNull(entities)
    }

    @Test
    @OptIn(ExperimentalCoroutinesApi::class)
    fun `Dynamic projections test case`() = runTest {

        val mock = MockUtil.readJsonFileToClass("json/item/item-querydsl-getAllBy.json", ItemInfo::class.java)

        val entities: Flux<ItemInfo> = itemQuerydslRepository.getAllBy(ItemInfo::class.java)

        assertNotNull(entities)

        StepVerifier.create<Any>(entities)
            .expectNext(mock)
            .verifyComplete()
    }
}