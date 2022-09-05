package com.example.kotlinwebflux.repository

import com.example.kotlinwebflux.domain.Item
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface ItemRepository : R2dbcRepository<Item, Long> {

    @Query("select * from item where name = :name")
    fun findByName(name: String): Mono<Item>
}