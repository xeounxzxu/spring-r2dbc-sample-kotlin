package com.example.webflux.repository.projection

import com.example.webflux.domain.constants.ItemType

data class ItemInfo constructor(
    val id: Long?,
    val name: String?,
    val type: ItemType?,
    val count: Int?,
    val limitCount: Int?,
    val createdAt: Long?,
)

interface OnlyItemName {
    fun getName(): String
}
