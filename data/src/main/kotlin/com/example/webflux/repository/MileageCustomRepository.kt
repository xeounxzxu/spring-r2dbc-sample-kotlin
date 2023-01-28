package com.example.webflux.repository

import com.example.webflux.domain.Mileage
import org.slf4j.LoggerFactory
import org.springframework.data.r2dbc.core.R2dbcEntityOperations
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface MileageCustomRepository {

    @Transactional
    fun saveInBatch(mileages: List<Mileage>): Mono<Int>
}

open class MileageCustomRepositoryImpl constructor(
    private val r2dbcEntityOperations: R2dbcEntityOperations
) : MileageCustomRepository {

    private val logger = LoggerFactory.getLogger(this::class.java)

    private val sql = """
        insert into mileage (user_id, point, created_at, updated_at)
        values (?,?,?,?)
    """.trimIndent()

    override fun saveInBatch(mileages: List<Mileage>): Mono<Int> = if (mileages.isEmpty()) {
        Mono.empty()
    } else {

        Flux.fromIterable(mileages)
            .flatMap { m ->
                r2dbcEntityOperations.databaseClient.sql(sql)
                    .bind(0, m.userId)
                    .bind(1, m.point)
                    .bind(2, m.createdAt.toString())
                    .bind(3, m.updatedAt.toString())
                    .fetch()
                    .rowsUpdated()
            }
            .reduce { a: Int, b: Int ->
                a + b
            }
    }

}

