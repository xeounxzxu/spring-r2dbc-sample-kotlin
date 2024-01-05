package com.example.webflux.repository

import com.example.webflux.domain.MileageHistory2
import org.springframework.data.repository.kotlin.CoroutineSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface MileageHistoryRepository : CoroutineSortingRepository<MileageHistory2, Long> {
}
