package com.example.webflux.config

import org.slf4j.LoggerFactory
import org.springframework.r2dbc.connection.lookup.AbstractRoutingConnectionFactory
import org.springframework.transaction.reactive.TransactionSynchronizationManager
import reactor.core.publisher.Mono

class MultiRoutingConnectionFactory : AbstractRoutingConnectionFactory() {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun determineCurrentLookupKey(): Mono<Any> =
        TransactionSynchronizationManager.forCurrentTransaction().flatMap {


            logger.info("it.getCurrentTransactionName() : {}", it.currentTransactionName)
            logger.info("it.isActualTransactionActive() : {}", it.isActualTransactionActive)
            logger.info("it.isCurrentTransactionReadOnly() : {}", it.isCurrentTransactionReadOnly)

            val key =
                if (it.isActualTransactionActive) {
                    WriteDataSourceProperties.KEY
                } else {
                    ReadDataSourceProperties.KEY
                }

            Mono.just(key)
        }
}