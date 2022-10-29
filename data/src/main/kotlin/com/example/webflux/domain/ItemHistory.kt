package com.example.webflux.domain

import com.example.webflux.constants.ItemType
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table
data class ItemHistory constructor(
    @Id
    val id: Long? = null,
    val name: String? = null,
    val type: ItemType? = null,
    val count: Int = 0,
    var limitCount: Int = 0,
    val itemId: Long,
    @CreatedDate
    val createdAt: LocalDateTime
)