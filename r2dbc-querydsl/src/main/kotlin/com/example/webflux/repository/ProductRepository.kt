package com.example.webflux.repository

import com.example.webflux.domain.Product
import com.example.webflux.repository.projection.ProductSalePointInfo
import org.springframework.data.repository.kotlin.CoroutineSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : CoroutineSortingRepository<Product, Long> {

    // suspend fun <T> findProductById(id: Long, type: Class<T>): T?
    suspend fun findProductById(id: Long): ProductSalePointInfo?
}
