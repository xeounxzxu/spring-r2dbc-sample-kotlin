package com.example.webflux.domain

import com.example.webflux.constants.ItemType
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

/**
 * Product Entity
 */
@Table(name = "item")
data class Item constructor(
    @Id
    val id: Long?,
    val name: String?,
    val type: ItemType?,
    // default is 0
    val count: Int?,
    // this column is person limit sold count
    // it is not init data and changed nullable data
    @Column("limit_count")
    val limitCount: Int?,
    @Column("created_at")
    val createdAt: Long?,
) {

    // created new item(product) constructor
    constructor(
        name: String,
        type: ItemType = ItemType.WAIT,
        count: Int = 0,
        limitCount: Int = 0,
        createdAt: Long? = System.currentTimeMillis(),
    ) : this(
        id = null,
        name = name,
        type = type,
        count = count,
        limitCount = limitCount,
        createdAt = createdAt
    )
}