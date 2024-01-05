package com.example.webflux.api.service

import com.example.webflux.api.service.data.SaveMileageDTO
import com.example.webflux.api.service.data.UpdateMileageDTO
import com.example.webflux.domain.Mileage
import com.example.webflux.repository.MileageRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MileageService constructor(
    private val mileageRepository: MileageRepository,
) {

    @Transactional(value = "reactiveTransactionManager")
    suspend fun created(dto: SaveMileageDTO): Mileage = mileageRepository.save(dto.toEntity())

    @Transactional(value = "reactiveTransactionManager")
    suspend fun updated(userId: Long, dto: UpdateMileageDTO): Mileage = mileageRepository.findByUserId(userId)
        .run {
            checkNotNull(this)
            mileageRepository.save(dto.toEntity(this))
        }
}
