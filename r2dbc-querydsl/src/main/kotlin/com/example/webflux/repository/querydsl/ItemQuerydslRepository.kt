package com.example.webflux.repository.querydsl

import com.example.webflux.domain.Item
import com.example.webflux.domain.QItem.item
import com.example.webflux.domain.QItemHistory.itemHistory
import com.infobip.spring.data.r2dbc.QuerydslR2dbcRepository
import com.querydsl.core.types.Projections
import reactor.core.publisher.Flux

interface ItemQuerydslRepository : QuerydslR2dbcRepository<Item, Long> {

    fun <T> getAllBy(type: Class<T>): Flux<T> = this.query {
        it.select(
            Projections.fields(
                type,
                item
            )
        )
            .from(item)
            .orderBy(item.id.asc())
    }.all()

    /**
     * todo : not working dynamic select
     * issue tag : #71
     */
    fun <T> getAllItemAndItemHistoryBy(type: Class<T>): Flux<T> = this.query {
        it.select(Projections.fields(type, item, itemHistory))
            .from(item)
            .leftJoin(itemHistory)
            .on(item.id.eq(itemHistory.itemId))
            .orderBy(item.id.asc())
    }.all()
}
