package com.example.webflux.querydsl

// import com.example.webflux.domain.QItem.item
import com.example.webflux.domain.Item
import com.infobip.spring.data.r2dbc.EnableQuerydslR2dbcRepositories
import com.infobip.spring.data.r2dbc.QuerydslR2dbcRepository
import org.springframework.stereotype.Component

// import com.querydsl.core.types.Projections
// import kotlinx.coroutines.flow.Flow
// import kotlinx.coroutines.reactive.asFlow
// @Repository

@EnableQuerydslR2dbcRepositories
interface ItemQuerydslRepository : QuerydslR2dbcRepository<Item, Long> {

    // suspend fun <T> findAllToClass(type: Class<T>): Flow<T> {
    //     return this.query {
    //         it.select(
    //             Projections.fields(
    //                 // Class<T> Type Add
    //                 type,
    //                 item.id,
    //                 item.name,
    //                 item.type,
    //                 item.count,
    //                 item.limitCount,
    //                 item.createdAt
    //             )
    //         ).from(item)
    //     }
    //         .all()
    //         // flux change to flow
    //         .asFlow()
    // }
}
