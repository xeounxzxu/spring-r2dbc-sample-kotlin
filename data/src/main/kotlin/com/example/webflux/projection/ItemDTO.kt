package com.example.webflux.projection

import com.example.webflux.constants.ItemType
import org.springframework.beans.factory.annotation.Value

data class ItemInfo constructor(
    val id: Long?,
    val name: String?,
    val type: ItemType?,
    val count: Int?,
    val limitCount: Int?,
    val createdAt: Long?,
)

/**
 * Data Projection use to interface ...
 */
interface OnlyItemName {

    /**
     * use to name ..
     */
    @Value("#{target.name}")
    fun getName(): String
}
