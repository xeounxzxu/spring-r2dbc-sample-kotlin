package com.example.webflux.dto

import com.example.webflux.constants.ItemType

data class ItemInfoDTO constructor(
    val id: Long?,
    val name: String?,
    val type: ItemType?,
    val count: Int?,
    val limitCount: Int?,
    val createdAt: Long?,
)