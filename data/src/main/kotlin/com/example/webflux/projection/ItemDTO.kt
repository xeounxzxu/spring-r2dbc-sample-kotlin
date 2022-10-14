package com.example.webflux.projection

import com.example.webflux.constants.ItemType

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
