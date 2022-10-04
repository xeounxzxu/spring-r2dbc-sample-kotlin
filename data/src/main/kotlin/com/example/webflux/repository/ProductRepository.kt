package com.example.webflux.repository

import com.example.webflux.domain.Product
import org.springframework.data.repository.kotlin.CoroutineSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : CoroutineSortingRepository<Product, Long> {
}