package com.example.webflux.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table
class Mileage(
    @Id
    var id: Long? = null,
    @Column("user_id")
    val userId: Long,
    var point: Long,
    @CreatedDate
    @Column("created_at")
    var createdAt: LocalDateTime= LocalDateTime.now(),
    @LastModifiedDate
    @Column("updated_at")
    var updatedAt: LocalDateTime = LocalDateTime.now(),
)

fun Mileage.update(point: Long) {
    this.point = point
}
