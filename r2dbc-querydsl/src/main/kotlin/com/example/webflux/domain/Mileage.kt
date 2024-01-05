package com.example.webflux.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table
data class Mileage(
    @Id
    val id: Long? = null,
    @Column("user_id")
    val userId: Long,
    val point: Long,
    @CreatedDate
    @Column("created_at")
    val createdAt: LocalDateTime? = null,
    @LastModifiedDate
    @Column("updated_at")
    val updatedAt: LocalDateTime? = null
)
