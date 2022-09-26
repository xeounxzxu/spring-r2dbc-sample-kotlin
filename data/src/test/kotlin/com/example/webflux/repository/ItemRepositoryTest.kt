package com.example.webflux.repository

import com.example.webflux.config.ItemRepositoryTestConfiguration
import com.example.webflux.domain.Item
import com.example.webflux.util.MockUtil
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(value = [SpringExtension::class])
@ContextConfiguration(
    classes = [ItemRepositoryTestConfiguration::class]
)
private class ItemRepositoryTest {

    @Autowired
    private lateinit var itemRepository: ItemRepository

    @Test
    fun `아이템 저장`() = runTest {

        val mock =
            MockUtil.readJsonFileToClass("json/item/item-savedata1.json", Item::class.java)!!

        val entity = itemRepository.save(mock)

        assertNotNull(entity.id)
        assertEquals(mock.name, entity.name)
        assertEquals(mock.type, entity.type)
        assertEquals(mock.count, entity.count)
        assertEquals(mock.createdAt, entity.createdAt)
    }

    @Test
    fun `이름별 조회 테스트 케이스`() = runTest {

        val mock =
            MockUtil.readJsonFileToClass("json/item/item-data1.json", Item::class.java)!!

        val entity = itemRepository.findByName(mock.name!!)!!

        assertEquals(mock.id!!, entity.id)
        assertEquals(mock.name, entity.name)
        assertEquals(mock.type, entity.type)
        assertEquals(mock.count, entity.count)
        assertEquals(mock.createdAt, entity.createdAt)
    }
}