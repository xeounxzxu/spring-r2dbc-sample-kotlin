package com.example.webflux.util

import com.example.webflux.domain.Item
import com.example.webflux.repository.projection.OnlyItemName

data class OnlyItemNameImpl constructor(private val name: String) : OnlyItemName {

    constructor(item : Item) : this (name= item.name.toString())

    override fun getName(): String = name
}
