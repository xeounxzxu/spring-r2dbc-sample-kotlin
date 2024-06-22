package com.example.r2dbc.callback.item

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(name = "item")
class ItemEntity(
    @Id
    val id: Long,
    val name: String,
)
