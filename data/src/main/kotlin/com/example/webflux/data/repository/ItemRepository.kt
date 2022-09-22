package com.example.webflux.data.repository

import com.example.webflux.data.domain.Item
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository : CoroutineCrudRepository<Item, Long> {

    suspend fun findByName(name: String): Item?

    suspend fun <T> findByName(name: String, type: Class<T>): T?
}