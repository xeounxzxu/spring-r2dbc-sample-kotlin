package com.example.webflux.util

import com.example.webflux.projection.OnlyItemName

data class OnlyItemNameImpl constructor(private val name: String) : OnlyItemName {
    override fun getName(): String = name
}