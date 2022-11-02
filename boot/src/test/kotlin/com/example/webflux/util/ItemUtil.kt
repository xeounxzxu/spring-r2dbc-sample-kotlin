package com.example.webflux.util

import com.example.webflux.api.service.data.ItemDTO
import com.example.webflux.domain.Item

object ItemUtil {

    fun newItemDTO(item: Item): ItemDTO = ItemDTO(
        name = item.name!!,
        count = item.count,
        limitCount = item.limitCount
    )
}