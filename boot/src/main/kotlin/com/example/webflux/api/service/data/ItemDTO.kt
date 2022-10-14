package com.example.webflux.api.service.data

import com.example.webflux.domain.Item

/**
 * Item Save Entity DTO
 */
data class ItemDTO constructor(
    val name: String,
    val count: Int = 0,
    val limitCount: Int = 0,
) {

    // new item data
    fun toNew() = Item(
        name = name,
        count = count,
        limitCount = limitCount
    )
}