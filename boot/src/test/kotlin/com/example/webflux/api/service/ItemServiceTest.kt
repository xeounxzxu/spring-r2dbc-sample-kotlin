package com.example.webflux.api.service

import com.example.webflux.api.service.data.ItemDTO
import com.example.webflux.domain.Item
import com.example.webflux.querydsl.ItemQuerydslRepository
import com.example.webflux.repository.ItemRepository
import com.example.webflux.util.MockUtil
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.then
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class ItemServiceTest {

    @InjectMocks
    private lateinit var itemService: ItemService

    @Mock
    private lateinit var itemRepository: ItemRepository

    @Mock
    private lateinit var iteQuerydslR2dbcRepository: ItemQuerydslRepository

    @Test
    fun `created item logic test case`() = runTest {

        val mock =
            MockUtil.readJsonFileToClass("json/item/item-savedata1.json", Item::class.java)!!

        val dto = ItemDTO(
            name = mock.name!!,
            count = mock.count,
            limitCount = mock.limitCount
        )

        given(itemRepository.save(MockUtil.any()))
            .willReturn(mock)

        val entity: Item = itemService.created(dto)

        then(itemRepository).should().save(MockUtil.any())

        assertEquals(mock.id, entity.id)
        assertEquals(mock.name, entity.name)
        assertEquals(mock.type, entity.type)
        assertEquals(mock.count, entity.count)
        assertEquals(mock.createdAt, entity.createdAt)

    }
}