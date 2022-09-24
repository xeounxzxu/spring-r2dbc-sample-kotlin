package com.example.webflux.api.service.data

import com.example.webflux.domain.Item
import com.example.webflux.util.MockUtil
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ItemDTOTest {

    @Test
    fun `new item data settup dto`() {

        val mock =
            MockUtil.readJsonFileToClass("json/item/item-savedata1.json", Item::class.java)!!

        val dto = ItemDTO(
            name = mock.name.toString(),
            count = mock.count,
            limitCount = mock.limitCount
        )

        val entity = dto.toNew()

        Assertions.assertEquals(mock.name, entity.name)
        Assertions.assertEquals(mock.type, entity.type)
        Assertions.assertEquals(mock.count, entity.count)
    }
}