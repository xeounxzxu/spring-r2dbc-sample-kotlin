package com.example.kotlinwebflux.repository

import com.example.kotlinwebflux.domain.Item
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface ItemRepository : R2dbcRepository<Item, Long> {

    fun findByName(name: String): Mono<Item>

    fun <T> findByName(name: String, type: Class<T>): Mono<T>
}