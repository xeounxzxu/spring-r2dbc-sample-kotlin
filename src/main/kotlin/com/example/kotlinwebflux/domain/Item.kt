package com.example.kotlinwebflux.domain

import com.example.kotlinwebflux.enums.ItemType
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "item")
data class Item constructor(
    @Id val id: Long?,
    val name: String,
    val type: ItemType?,
    val count: Int?,
    val createdAt: Long?,
) {

    // createdStateEntity
    constructor(name: String, type: ItemType = ItemType.WAIT, count: Int = 0) : this(
        id = null,
        name = name,
        type = type,
        count = count,
        createdAt = System.currentTimeMillis()
    )
}