package com.example.webflux.api.service

import com.example.webflux.api.service.data.SaveMileageDTO
import com.example.webflux.api.service.data.UpdateMileageDTO
import com.example.webflux.domain.Mileage
import com.example.webflux.domain.update
import com.example.webflux.repository.MileageRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MileageService(
    private val mileageRepository: MileageRepository,
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @Transactional(value = "reactiveTransactionManager")
    suspend fun created(dto: SaveMileageDTO): Mileage = mileageRepository.save(dto.toEntity())

    @Transactional(value = "reactiveTransactionManager")
    suspend fun updated(userId: Long, dto: UpdateMileageDTO): Mileage {
        logger.info("working ..")
        return checkNotNull(mileageRepository.findByUserId(userId))
            .run {
                logger.info("working .. 2")

                this.update(point = dto.point)

                mileageRepository.save(
                    this
                )
            }
    }
}
