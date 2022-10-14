package com.example.webflux.api.service.data

import com.example.webflux.domain.Item
import com.example.webflux.util.MockUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ItemDTOTest {

    @Test
    fun `new item data settup dto`() {

        val mock =
            MockUtil.readJsonFileToClass("json/item/item-savedata1.json", Item::class.java)!!

        val dto = ItemDTO(
            name = mock.name.toString(),
            count = mock.count!!,
            limitCount = mock.limitCount!!
        )

        val entity = dto.toNew()

        assertEquals(mock.name, entity.name)
        assertEquals(mock.type, entity.type)
        assertEquals(mock.count, entity.count)
    }
}
