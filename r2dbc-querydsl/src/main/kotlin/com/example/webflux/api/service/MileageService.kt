package com.example.webflux.api.service

import com.example.webflux.api.service.data.SaveMileageDTO
import com.example.webflux.api.service.data.UpdateMileageDTO
import com.example.webflux.domain.Mileage
import com.example.webflux.domain.update
import com.example.webflux.repository.MileageRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MileageService(
    private val mileageRepository: MileageRepository,
) {

    @Transactional(value = "reactiveTransactionManager")
    suspend fun created(dto: SaveMileageDTO): Mileage = mileageRepository.save(dto.toEntity())

    @Transactional(value = "reactiveTransactionManager")
    suspend fun updated(userId: Long, dto: UpdateMileageDTO): Mileage =
        checkNotNull(mileageRepository.findByUserId(userId))
        .run {

            this.update(point = dto.point)

            mileageRepository.save(
                this
            )
        }
}
