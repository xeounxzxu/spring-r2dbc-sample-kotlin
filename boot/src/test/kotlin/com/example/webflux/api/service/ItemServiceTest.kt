package com.example.webflux.api.service

import com.example.webflux.domain.Item
import com.example.webflux.projection.ItemInfo
import com.example.webflux.querydsl.ItemQuerydslRepository
import com.example.webflux.repository.ItemRepository
import com.example.webflux.util.ItemUtil.newItemDTO
import com.example.webflux.util.MockUtil.readJsonFileToClass
import com.example.webflux.util.OnlyItemNameImpl
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import reactor.core.publisher.Flux
import reactor.test.StepVerifier

@ExtendWith(MockitoExtension::class)
internal class ItemServiceTest : AbstractMockKService() {

    @InjectMockKs
    private lateinit var itemService: ItemService

    @MockK
    private lateinit var itemRepository: ItemRepository

    @MockK
    private lateinit var iteQuerydslR2dbcRepository: ItemQuerydslRepository

    @BeforeEach
    override fun init() {
        /**
         * custom init logic
         */
        super.init()
    }

    @Test
    fun `created item logic test case`() {

        val mock = readJsonFileToClass("json/item/item-savedata1.json", Item::class.java)!!

        val dto = newItemDTO(mock)

        coEvery {
            itemRepository.save(any())
        } answers {
            mock
        }

        val entity = runBlocking {
            itemService.created(dto)
        }

        coVerify {
            itemRepository.save(any())
        }

        confirmVerified(itemRepository)

        assertEquals(mock.id, entity.id)
        assertEquals(mock.name, entity.name)
        assertEquals(mock.type, entity.type)
        assertEquals(mock.count, entity.count)
        assertEquals(mock.createdAt, entity.createdAt)
    }

    @Test
    fun `all select from items`() {

        val value = readJsonFileToClass("json/item/item-querydsl-getAllBy.json", ItemInfo::class.java)!!

        val mock = Flux.create {
            it.next(value)
            it.complete()
        }

        every {
            iteQuerydslR2dbcRepository.getAllBy(ItemInfo::class.java)
        } answers {
            mock
        }

        val entities: Flux<ItemInfo> = itemService.getAll()

        verify {
            iteQuerydslR2dbcRepository.getAllBy(ItemInfo::class.java)
        }

        confirmVerified(iteQuerydslR2dbcRepository)

        StepVerifier.create(entities)
            .expectSubscription()
            .thenConsumeWhile {
                it.id == value.id &&
                    it.name == value.name &&
                    it.type == value.type &&
                    it.count == value.count &&
                    it.limitCount == value.limitCount &&
                    it.createdAt == value.createdAt
            }
            .expectComplete()
            .verify()
    }

    @Test
    fun `select id method`() {

        val mock = readJsonFileToClass("json/item/item-data1.json", Item::class.java)!!

        coEvery {
            itemRepository.findById(any() as Long)
        } answers {
            mock
        }

        val entity = runBlocking {
            itemService.get(1L)!!
        }

        coVerify {
            itemRepository.findById(any() as Long)
        }

        confirmVerified(itemRepository)

        assertEquals(mock.id, entity.id)
        assertEquals(mock.name, entity.name)
        assertEquals(mock.type, entity.type)
        assertEquals(mock.count, entity.count)
        assertEquals(mock.createdAt, entity.createdAt)
    }

    @Test
    fun `select id test case`() {

        val mock = readJsonFileToClass("json/item/item-data1.json", Item::class.java)!!

        coEvery {
            itemRepository.findById(any())
        } answers {
            mock
        }

        val entity = runBlocking {
            itemService.get(mock.id!!)
        }!!

        coVerify {
            itemRepository.findById(any())
        }

        confirmVerified(itemRepository)


        assertEquals(mock.id, entity.id)
        assertEquals(mock.name, entity.name)
        assertEquals(mock.type, entity.type)
        assertEquals(mock.count, entity.count)
        assertEquals(mock.createdAt, entity.createdAt)
    }

    @Test
    fun `Select Name Test Case`() {

        val mock = OnlyItemNameImpl(readJsonFileToClass("json/item/item-data1.json", Item::class.java)!!)

        coEvery {
            itemRepository.findItemByName(any())
        } answers {
            mock
        }

        val entity = runBlocking {
            itemService.get(mock.getName())
        }!!

        coVerify {
            itemRepository.findItemByName(any())
        }

        confirmVerified(itemRepository)

        assertEquals(mock.getName(), entity.getName())
    }
}
