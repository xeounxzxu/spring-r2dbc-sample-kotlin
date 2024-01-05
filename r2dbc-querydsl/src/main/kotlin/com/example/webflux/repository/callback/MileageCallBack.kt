package com.example.webflux.repository.callback

import com.example.webflux.domain.Mileage
import com.example.webflux.domain.MileageHistory2
import com.example.webflux.repository.MileageHistoryRepository
import kotlinx.coroutines.reactor.mono
import org.reactivestreams.Publisher
import org.springframework.data.r2dbc.mapping.OutboundRow
import org.springframework.data.r2dbc.mapping.event.AfterSaveCallback
import org.springframework.data.r2dbc.mapping.event.BeforeSaveCallback
import org.springframework.data.relational.core.mapping.event.AfterDeleteCallback
import org.springframework.data.relational.core.sql.SqlIdentifier
import org.springframework.stereotype.Component

/**
 * Mileage Callback
 */
@Component
class MileageCallBack(
//    private val mileageHistoryRepository: MileageHistoryRepository
) : AfterSaveCallback<Mileage>, BeforeSaveCallback<Mileage>, AfterDeleteCallback<Mileage> {

    /**
     * before method
     */
    override fun onBeforeSave(entity: Mileage, row: OutboundRow, table: SqlIdentifier): Publisher<Mileage> =
        mono {
            entity
        }

    /**
     * after method
     */
    override fun onAfterSave(entity: Mileage, outboundRow: OutboundRow, table: SqlIdentifier): Publisher<Mileage> =
        mono {

//            mileageHistoryRepository.save(
//                MileageHistory2.of(
//                    refId = checkNotNull(entity.id),
//                    userId = entity.userId,
//                    point = entity.point,
//                    createdAt = checkNotNull(entity.createdAt),
//                    updatedAt = checkNotNull(entity.updatedAt),
//                    isUpdated = entity.createdAt != entity.updatedAt
//                )
//            )

            entity
        }

    override fun onAfterDelete(aggregate: Mileage): Mileage {
        return aggregate
    }
}
