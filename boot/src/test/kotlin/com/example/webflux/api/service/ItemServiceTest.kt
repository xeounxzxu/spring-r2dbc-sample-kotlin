package com.example.webflux.api.service

import com.example.webflux.api.service.data.ItemDTO
import com.example.webflux.domain.Item
import com.example.webflux.querydsl.ItemQuerydslRepository
import com.example.webflux.repository.ItemRepository
import com.example.webflux.util.MockUtil.readJsonFileToClass
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class ItemServiceTest : AbstractMockKService() {

    @InjectMockKs
    private lateinit var itemService: ItemService

    @MockK
    private lateinit var itemRepository: ItemRepository

    @MockK
    private lateinit var iteQuerydslR2dbcRepository: ItemQuerydslRepository

    @Test
    fun `created item logic test case`() = runTest {

        val mock = readJsonFileToClass("json/item/item-savedata1.json", Item::class.java)!!

        val dto = ItemDTO(
            name = mock.name!!,
            count = mock.count,
            limitCount = mock.limitCount
        )

        coEvery {
            itemRepository.save(any())
        } returns mock

        val entity = itemService.created(dto)

        coVerify { itemRepository.save(any()) }

        confirmVerified(itemRepository)

        assertEquals(mock.id, entity.id)
        assertEquals(mock.name, entity.name)
        assertEquals(mock.type, entity.type)
        assertEquals(mock.count, entity.count)
        assertEquals(mock.createdAt, entity.createdAt)
    }

    // @Test
    // fun `all select from items`() {
    //
    //     val value = readJsonFileToClass("json/item/item-querydsl-getAllBy.json", ItemInfo::class.java)!!
    //
    //     val mock = Flux.create { it ->
    //         it.next(value)
    //         it.complete()
    //     }
    //
    //     given(iteQuerydslR2dbcRepository.getAllBy(eq(ItemInfo::class.java)))
    //         .willReturn(mock)
    //
    //     val entities: Flux<ItemInfo> = itemService.getAll()
    //
    //     then(iteQuerydslR2dbcRepository)
    //         .should()
    //         .getAllBy(eq(ItemInfo::class.java))
    // }
}