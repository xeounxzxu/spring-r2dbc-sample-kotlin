package com.example.webflux.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate

@Table
data class Mileage constructor(
    @Id
    val id: Long?,
    val userId: Long,
    val point: Long,
    @CreatedDate
    val createdAt: LocalDate?,
    @LastModifiedDate
    val updatedAt: LocalDate?
) {

}