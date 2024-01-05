package com.example.webflux.callback

import com.example.webflux.domain.Mileage
import com.example.webflux.domain.MileageHistory2
import com.example.webflux.repository.MileageHistoryRepository
import kotlinx.coroutines.reactor.mono
import org.reactivestreams.Publisher
import org.slf4j.LoggerFactory
import org.springframework.core.annotation.Order
import org.springframework.data.r2dbc.mapping.OutboundRow
import org.springframework.data.r2dbc.mapping.event.AfterSaveCallback
import org.springframework.data.relational.core.sql.SqlIdentifier
import org.springframework.stereotype.Component

@Order(100)
@Component
class MileageCallBack(
    private val mileageHistoryRepository: MileageHistoryRepository
) : AfterSaveCallback<Mileage> {

    private val logger = LoggerFactory.getLogger(this::class.java)

    /**
     * after method
     */
    override fun onAfterSave(entity: Mileage, outboundRow: OutboundRow, table: SqlIdentifier): Publisher<Mileage> =
        mono {

            logger.info("working callback")

            if (entity.point == 2000L) {
                throw RuntimeException("fucking...!!")
            }

            mileageHistoryRepository.save(
                MileageHistory2.of(
                    refId = checkNotNull(entity.id),
                    userId = entity.userId,
                    point = entity.point,
                    createdAt = checkNotNull(entity.createdAt),
                    updatedAt = checkNotNull(entity.updatedAt),
                    isUpdated = entity.createdAt != entity.updatedAt
                )
            )


            if (entity.point == 3000L) {
                throw RuntimeException("fucking...!! 2")
            }

            entity
        }
}
