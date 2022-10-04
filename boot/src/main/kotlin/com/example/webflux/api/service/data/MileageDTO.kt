package com.example.webflux.api.service.data

import com.example.webflux.domain.Mileage

/**
 * create dto
 */
data class SaveMileageDTO constructor(
    val userId: Long,
    val point: Long = 0L
) {

    fun toEntity(): Mileage = Mileage(userId = this.userId, point = this.point)
}

/**
 * update dto
 */
data class UpdateMileageDTO constructor(
    val point: Long = 0L
) {

    fun toEntity(entity: Mileage): Mileage = entity.copy(point = point)
}