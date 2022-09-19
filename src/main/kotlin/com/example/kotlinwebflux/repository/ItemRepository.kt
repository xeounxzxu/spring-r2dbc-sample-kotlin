package com.example.kotlinwebflux.repository

import com.example.kotlinwebflux.domain.Item
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository : CoroutineCrudRepository<Item, Long> {

    // fun findByName(name: String): Mono<Item>

    suspend fun <T> findByName(name: String, type: Class<T>): T?
}