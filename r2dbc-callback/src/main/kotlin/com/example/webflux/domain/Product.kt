package com.example.webflux.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table
data class Product constructor(
    @Id
    val id: Long? = null,
    val title: String,
    @Column("sale_point")
    val salePoint: Long,
    @CreatedDate
    @Column("created_at")
    val createdAt: LocalDateTime? = null,
    @LastModifiedDate
    @Column("updated_at")
    val updatedAt: LocalDateTime? = null
) {
}