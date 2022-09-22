package com.example.webflux.repository

import com.example.webflux.domain.Item
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository : CoroutineCrudRepository<Item, Long> {

<<<<<<< HEAD:data/src/main/kotlin/com/example/webflux/data/repository/ItemRepository.kt
    suspend fun findByName(name: String): Item?
=======
    fun findByName(name: String): Item?
>>>>>>> origin/multi:data/src/main/kotlin/com/example/webflux/repository/ItemRepository.kt

    suspend fun <T> findByName(name: String, type: Class<T>): T?
}