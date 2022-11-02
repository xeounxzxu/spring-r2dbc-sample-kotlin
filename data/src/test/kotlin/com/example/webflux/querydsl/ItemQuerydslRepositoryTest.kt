package com.example.webflux.querydsl

import com.example.webflux.config.AbstractQuerydslBaseTest
import com.example.webflux.config.QuerydslTestConfiguration
import com.example.webflux.domain.Item
import com.example.webflux.projection.ItemInfo
import com.example.webflux.projection.OnlyItemName
import com.example.webflux.util.MockUtil.readJsonFileToClass
import com.example.webflux.util.OnlyItemNameImpl
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
    @Order(2)
    fun `Dynamic projections test case`() {

        val mock = readJsonFileToClass("json/item/item-querydsl-getAllBy.json", ItemInfo::class.java)!!

        val entities: Flux<ItemInfo> = itemQuerydslRepository.getAllBy(ItemInfo::class.java)

        assertNotNull(entities)

        StepVerifier.create(entities)
            .expectSubscription()
            .thenConsumeWhile {
                it.id == mock.id &&
                    it.name == mock.name &&
                    it.type == mock.type &&
                    it.count == mock.count &&
                    it.limitCount == mock.limitCount &&
                    it.createdAt == mock.createdAt
            }
            .expectComplete()
            .verify()
    }

    @Test
    @Order(3)
    fun `find by name only query`() {

        val mock: OnlyItemName =
            readJsonFileToClass("json/item/item-querydsl-getAllBy.json", OnlyItemNameImpl::class.java)!!

        val entities: Flux<OnlyItemName> = itemQuerydslRepository.getAllBy(OnlyItemName::class.java)

        assertNotNull(entities)

        StepVerifier.create(entities)
            .expectSubscription()
            .thenConsumeWhile {
                it.getName() == mock.getName()
            }
            .expectComplete()
            .verify()
    }

    @Test
    @Order(4)
    fun `findAll item and history`() {

        val mock = readJsonFileToClass("json/item/item-querydsl-getAllBy.json", ItemInfo::class.java)!!

        val entities: Flux<ItemInfo> = itemQuerydslRepository.getAllItemAndItemHistoryBy(ItemInfo::class.java)

        assertNotNull(entities)

        StepVerifier.create(entities)
            .expectSubscription()
            .thenConsumeWhile {
                it.id == mock.id &&
                    it.name == mock.name &&
                    it.type == mock.type &&
                    it.count == mock.count &&
                    it.limitCount == mock.limitCount &&
                    it.createdAt == mock.createdAt
            }
            .expectComplete()
            .verify()
    }
}