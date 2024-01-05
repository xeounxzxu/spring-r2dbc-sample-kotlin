package com.example.webflux.repository.projection

interface ProductSalePointInfo {
    fun getId(): Long?
    fun getTitle(): String
    fun getSalePoint(): Long
}
