package com.example.webflux.repository

import com.example.webflux.domain.Item
import org.springframework.data.repository.kotlin.CoroutineSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository : CoroutineSortingRepository<Item, Long>{

    suspend fun findByName(name: String): Item?

    suspend fun <T> findByName(name: String, type: Class<T>): T?
}