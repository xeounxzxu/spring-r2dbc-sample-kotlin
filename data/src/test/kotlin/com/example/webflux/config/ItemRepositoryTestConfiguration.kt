package com.example.webflux.config

import io.r2dbc.h2.H2ConnectionFactory
import io.r2dbc.h2.H2ConnectionOption
import io.r2dbc.spi.ConnectionFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.FilterType
import org.springframework.core.io.ClassPathResource
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.r2dbc.connection.R2dbcTransactionManager
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator

@TestConfiguration
@ComponentScan(
    basePackages = ["com.example.webflux.repository"],
    excludeFilters = [ComponentScan.Filter(
        type = FilterType.ASSIGNABLE_TYPE,
        classes = []
    )]
)
@EnableR2dbcRepositories(
    basePackages = ["com.example.webflux.repository"]
)
class ItemRepositoryTestConfiguration constructor(
    // private val defaultR2dbcCustomConversions: R2dbcCustomConversions
) : AbstractR2dbcConfiguration() {

    // override fun r2dbcCustomConversions() = defaultR2dbcCustomConversions

    @Bean(name = ["connectionFactory"])
    override fun connectionFactory(): ConnectionFactory = H2ConnectionFactory.inMemory(
        "testdb",
        "sa",
        "",
        mapOf(
            H2ConnectionOption.ACCESS_MODE_DATA to "MySQL"
        )
    )

    @Bean(name = ["transactionManager"])
    fun transactionManager(@Qualifier("connectionFactory") connectionFactory: ConnectionFactory) =
        R2dbcTransactionManager(connectionFactory)

    @Bean
    fun initializer(@Qualifier("connectionFactory") connectionFactory: ConnectionFactory): ConnectionFactoryInitializer =
        ConnectionFactoryInitializer().apply {

            this.setConnectionFactory(connectionFactory)

            val populator = CompositeDatabasePopulator().apply {
                this.addPopulators(ResourceDatabasePopulator(ClassPathResource("sql/item/schema.sql")))
                this.addPopulators(ResourceDatabasePopulator(ClassPathResource("sql/item/item-data1.sql")))
            }

            this.setDatabasePopulator(populator)
        }
}