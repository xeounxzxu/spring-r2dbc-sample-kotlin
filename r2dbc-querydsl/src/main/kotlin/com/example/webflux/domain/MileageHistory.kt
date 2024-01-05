package com.example.webflux.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table
data class MileageHistory constructor(
    @Id
    val id: Long? = null,
    @Column("user_id")
    val userId: Long,
    @Column("product_id")
    val productId: Long,
    @Column("changed_point")
    val changedPoint: Long = 0L,
    @Column("balance_point")
    val balancePoint: Long,
    @CreatedDate
    @Column("created_at")
    val createdAt: LocalDateTime? = null
) {
}