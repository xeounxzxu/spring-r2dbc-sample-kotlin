package com.example.webflux.repository

import com.example.webflux.domain.Item
import com.example.webflux.projection.OnlyItemName
import org.springframework.data.repository.kotlin.CoroutineSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository : CoroutineSortingRepository<Item, Long> {

    suspend fun findByName(name: String): Item?

    suspend fun findItemByName(name: String): OnlyItemName?

    @Deprecated("not working to projections")
    suspend fun <T> findByName(name: String, type: Class<T>): T?

    @Deprecated("not working to projections")
    suspend fun <T> findItemByName(name: String, type: Class<T>): T?
}