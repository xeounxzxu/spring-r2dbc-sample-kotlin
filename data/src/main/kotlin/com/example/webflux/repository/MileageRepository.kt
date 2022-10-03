package com.example.webflux.repository

import com.example.webflux.domain.Mileage
import org.springframework.data.repository.kotlin.CoroutineSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface MileageRepository : CoroutineSortingRepository<Mileage, Long> {

    suspend fun findByUserId(userId : Long) : Mileage?
}