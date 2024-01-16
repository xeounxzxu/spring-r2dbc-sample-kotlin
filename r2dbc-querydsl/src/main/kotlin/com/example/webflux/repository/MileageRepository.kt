package com.example.webflux.repository

import com.example.webflux.config.R2dbcRepo
import com.example.webflux.domain.Mileage
import org.springframework.data.repository.kotlin.CoroutineSortingRepository

@R2dbcRepo
interface MileageRepository : CoroutineSortingRepository<Mileage, Long> {

    suspend fun findByUserId(userId: Long): Mileage?
}



