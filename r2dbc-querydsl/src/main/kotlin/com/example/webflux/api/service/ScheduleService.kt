package com.example.webflux.api.service

import com.example.webflux.domain.Mileage
import com.example.webflux.repository.MileageRepository
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.time.LocalDateTime

@Service
class ScheduleService constructor(
    private val mileageRepository: MileageRepository,
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

//    @Scheduled(cron = "0/10 * * * * ?")
    fun progress() {

        logger.info("start progress is working")

        val list = mutableListOf<Mileage>()

        for (i in 1..100) {

            val idx = System.currentTimeMillis()

            list.add(
                Mileage(
                    null, idx, idx, LocalDateTime.now(), LocalDateTime.now()
                )
            )
        }

        Mono.just(list).flatMap { it ->
            mileageRepository.saveInBatch(it)
        }.subscribe()
    }

}
