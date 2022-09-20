package com.example.webflux.boot.api.service.data

import com.example.webflux.data.domain.Item
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
) {

    // normal state entity type
    fun toCreatedStateEntity() = Item(
        name = name,
        count = count
    )
}