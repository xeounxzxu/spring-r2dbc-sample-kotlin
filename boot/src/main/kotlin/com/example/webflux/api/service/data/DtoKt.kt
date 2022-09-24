package com.example.webflux.api.service.data

import com.example.webflux.domain.Item
import org.springframework.beans.factory.annotation.Value

/**
 * Data Projection use to interface ...
 */
interface ItemInfo {

    /**
     * use to name ..
     */
    @Value("#{target.name}")
    fun getName(): String
}

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