package com.example.webflux.callback

import com.example.webflux.domain.Mileage
import org.reactivestreams.Publisher
import org.springframework.data.r2dbc.mapping.OutboundRow
import org.springframework.data.r2dbc.mapping.event.AfterSaveCallback
import org.springframework.data.r2dbc.mapping.event.BeforeSaveCallback
import org.springframework.data.relational.core.sql.SqlIdentifier
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

/**
 * Mileage Callback
 */
@Component
class MileageCallBack : AfterSaveCallback<Mileage>, BeforeSaveCallback<Mileage> {

    /**
     * before method
     */
    override fun onBeforeSave(entity: Mileage, row: OutboundRow, table: SqlIdentifier): Publisher<Mileage> {

        return Mono.just(entity)
    }

    /**
     * after method
     */
    override fun onAfterSave(entity: Mileage, outboundRow: OutboundRow, table: SqlIdentifier): Publisher<Mileage> {

        return Mono.just(entity)
    }
}