package com.example.webflux.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table(name = "mileage_history_2")
class MileageHistory2(
    @Id
    var id: Long? = null,
    @Column("ref_id")
    val refId: Long,
    @Column("user_id")
    val userId: Long,
    val point: Long,
    @Column("created_at")
    val createdAt: LocalDateTime? = null,
    @Column("updated_at")
    val updatedAt: LocalDateTime? = null,
    @Column("updated_yn")
    val isUpdated: Boolean
) {
    constructor(
        refId: Long,
        userId: Long,
        point: Long,
        createdAt: LocalDateTime,
        updatedAt: LocalDateTime,
        isUpdated: Boolean
    ) : this(
        id = null,
        refId = refId,
        userId = userId,
        point = point,
        createdAt = createdAt,
        updatedAt = updatedAt,
        isUpdated = isUpdated
    )

    companion object {
        fun of(
            refId: Long,
            userId: Long,
            point: Long,
            createdAt: LocalDateTime,
            updatedAt: LocalDateTime,
            isUpdated: Boolean
        ) = MileageHistory2(
            refId = refId,
            userId = userId,
            point = point,
            createdAt = createdAt,
            updatedAt = updatedAt,
            isUpdated = isUpdated
        )
    }
}

