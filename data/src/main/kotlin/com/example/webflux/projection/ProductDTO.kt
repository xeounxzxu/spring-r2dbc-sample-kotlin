package com.example.webflux.projection

interface ProductSalePointInfo {
    fun getId(): Long?
    fun getTitle(): String
    fun getSalePoint(): Long
}