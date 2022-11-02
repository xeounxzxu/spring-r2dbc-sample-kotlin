package com.example.webflux.repository

import com.example.webflux.config.R2dbcTestConfiguration
import com.example.webflux.domain.Item
import com.example.webflux.util.MockUtil.readJsonFileToClass
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(value = [SpringExtension::class])
@ContextConfiguration(
    classes = [R2dbcTestConfiguration::class]
)
internal class ItemRepositoryTest {

    @Autowired
    private lateinit var itemRepository: ItemRepository

    @Test
    fun `Item Save Test Case`() {

        val mock =
            readJsonFileToClass("json/item/item-savedata1.json", Item::class.java)!!

        val entity = runBlocking {
            itemRepository.save(mock)
        }

        assertNotNull(entity.id)
        assertEquals(mock.name, entity.name)
        assertEquals(mock.type, entity.type)
        assertEquals(mock.count, entity.count)
        assertEquals(mock.createdAt, entity.createdAt)
    }

    @Test
    fun `Find Name Test Case By Item`() {

        val mock = readJsonFileToClass("json/item/item-data1.json", Item::class.java)!!

        val entity = runBlocking {
            itemRepository.findByName(mock.name!!)!!
        }

        assertEquals(mock.id!!, entity.id)
        assertEquals(mock.name, entity.name)
        assertEquals(mock.type, entity.type)
        assertEquals(mock.count, entity.count)
        assertEquals(mock.createdAt, entity.createdAt)
    }

    @Test
    fun `find_id test case`() {

        val mock = readJsonFileToClass("json/item/item-data1.json", Item::class.java)!!

        val entity = runBlocking {
            itemRepository.findById(mock.id!!)!!
        }

        assertEquals(mock.id!!, entity.id)
        assertEquals(mock.name, entity.name)
        assertEquals(mock.type, entity.type)
        assertEquals(mock.count, entity.count)
        assertEquals(mock.createdAt, entity.createdAt)
    }

    @Test
    fun `Find Name Test Case By ItemNameOnly`() {

        val mock = readJsonFileToClass("json/item/item-data1.json", Item::class.java)!!

        val entity = runBlocking {
            itemRepository.findItemByName(mock.name.toString())
        }!!

        assertEquals(mock.name, entity.getName())
    }
}