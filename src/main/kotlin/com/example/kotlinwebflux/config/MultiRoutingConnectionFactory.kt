package com.example.kotlinwebflux.config

import org.springframework.r2dbc.connection.lookup.AbstractRoutingConnectionFactory
import org.springframework.transaction.reactive.TransactionSynchronizationManager
import reactor.core.publisher.Mono

class MultiRoutingConnectionFactory : AbstractRoutingConnectionFactory() {

    override fun determineCurrentLookupKey(): Mono<Any> =
        TransactionSynchronizationManager.forCurrentTransaction().map {

            val key =
                // if (it.isActualTransactionActive && it.currentTransactionName!!.contains(WriteDataSourceProperties.BASE_PACKAGE)) {
                if (it.isActualTransactionActive) {
                    WriteDataSourceProperties.KEY
                } else {
                    ReadDataSourceProperties.KEY
                }

            key
        }
}