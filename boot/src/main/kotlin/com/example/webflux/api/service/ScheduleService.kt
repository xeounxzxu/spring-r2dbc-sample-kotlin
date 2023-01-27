package com.example.webflux.api.service

import com.example.webflux.domain.Mileage
import com.example.webflux.repository.MileageRepository
import io.r2dbc.spi.ConnectionFactory
import org.slf4j.LoggerFactory
import org.springframework.data.r2dbc.core.R2dbcEntityOperations
import org.springframework.stereotype.Service
import org.springframework.transaction.ReactiveTransactionManager
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.time.LocalDateTime
import javax.annotation.PostConstruct


@Service
class ScheduleService constructor(
    private val mileageRepository: MileageRepository,
    private val reactiveTransactionManager: ReactiveTransactionManager,
    private val connectionFactory: ConnectionFactory,
    private val r2dbcEntityOperations: R2dbcEntityOperations
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @PostConstruct
    fun progress() {

        Flux.interval(Duration.ofSeconds(3)).flatMap {

            val list = mutableListOf<Mileage>()

            for (i in 1..100) {
                list.add(
                    Mileage(
                        null, i.toLong(), i.toLong(), LocalDateTime.now(), LocalDateTime.now()
                    )
                )
            }

            Mono.just(list)
        }.flatMap {
            mileageRepository.saveInBatch(it)
        }.subscribe()
    }

}
