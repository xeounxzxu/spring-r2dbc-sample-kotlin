package com.example.webflux.repository

import com.example.webflux.domain.Item
import com.example.webflux.repository.projection.OnlyItemName
import org.reactivestreams.Publisher
import org.springframework.data.r2dbc.mapping.OutboundRow
import org.springframework.data.r2dbc.mapping.event.AfterSaveCallback
import org.springframework.data.relational.core.mapping.event.AfterDeleteCallback
import org.springframework.data.relational.core.mapping.event.AfterDeleteEvent
import org.springframework.data.relational.core.sql.SqlIdentifier
import org.springframework.data.repository.kotlin.CoroutineSortingRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface ItemRepository : CoroutineSortingRepository<Item, Long> {

    suspend fun findByName(name: String): Item?

    suspend fun findItemByName(name: String): OnlyItemName?

    @Deprecated("not working to projections")
    suspend fun <T> findByName(name: String, type: Class<T>): T?

    @Deprecated("not working to projections")
    suspend fun <T> findItemByName(name: String, type: Class<T>): T?
}
