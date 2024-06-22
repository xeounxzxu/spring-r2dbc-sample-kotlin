package com.example.r2dbc.data

import org.slf4j.LoggerFactory
import org.springframework.r2dbc.connection.lookup.AbstractRoutingConnectionFactory
import org.springframework.transaction.reactive.TransactionSynchronizationManager
import reactor.core.publisher.Mono

private val logger = LoggerFactory.getLogger(MultiRoutingConnectionFactory::class.java)

class MultiRoutingConnectionFactory : AbstractRoutingConnectionFactory() {
    override fun determineCurrentLookupKey(): Mono<Any> {
        val transaction = TransactionSynchronizationManager.forCurrentTransaction()

        return transaction.flatMap {
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
}
