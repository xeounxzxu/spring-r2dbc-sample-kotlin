package com.example.webflux.repository

import com.example.webflux.config.R2dbcRepo
import com.example.webflux.domain.MileageHistory2
import org.springframework.data.repository.kotlin.CoroutineSortingRepository

@R2dbcRepo
interface MileageHistoryRepository : CoroutineSortingRepository<MileageHistory2, Long> {
}
