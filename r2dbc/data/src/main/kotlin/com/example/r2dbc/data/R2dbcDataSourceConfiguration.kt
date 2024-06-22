package com.example.r2dbc.data

import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactory
import io.r2dbc.spi.ConnectionFactoryOptions
import io.r2dbc.spi.ConnectionFactoryOptions.CONNECT_TIMEOUT
import io.r2dbc.spi.ConnectionFactoryOptions.DATABASE
import io.r2dbc.spi.ConnectionFactoryOptions.DRIVER
import io.r2dbc.spi.ConnectionFactoryOptions.HOST
import io.r2dbc.spi.ConnectionFactoryOptions.PASSWORD
import io.r2dbc.spi.ConnectionFactoryOptions.PORT
import io.r2dbc.spi.ConnectionFactoryOptions.USER
import io.r2dbc.spi.Option
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing
import org.springframework.data.r2dbc.core.DefaultReactiveDataAccessStrategy
import org.springframework.data.r2dbc.core.R2dbcEntityOperations
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.data.r2dbc.dialect.DialectResolver
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.r2dbc.connection.R2dbcTransactionManager
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.transaction.ReactiveTransactionManager
import java.time.Duration

@Configuration
@EnableR2dbcAuditing
@EnableConfigurationProperties(
    value = [
        ReadDataSourceProperties::class,
        WriteDataSourceProperties::class,
    ],
)
@EnableR2dbcRepositories(
    includeFilters = [
        ComponentScan.Filter(
            type = FilterType.ANNOTATION,
            value = [R2dbcRepo::class],
        ),
    ],
    entityOperationsRef = "r2dbcEntityOperations",
)
class R2dbcDataSourceConfiguration(
    @Qualifier("read.datasource-com.example.r2dbc.data.ReadDataSourceProperties")
    private val readDataSourceProperties: BaseDataSourceProperties,
    @Qualifier("write.datasource-com.example.r2dbc.data.WriteDataSourceProperties")
    private val writeDataSourceProperties: BaseDataSourceProperties,
) : AbstractR2dbcConfiguration() {
    @Bean
    override fun connectionFactory(): ConnectionFactory =
        MultiRoutingConnectionFactory()
            .apply {
                val factories: HashMap<String, ConnectionFactory> =
                    hashMapOf(
                        WriteDataSourceProperties.KEY to writeConnectionFactory(),
                        ReadDataSourceProperties.KEY to readConnectionFactory(),
                    )

                this.setTargetConnectionFactories(factories)

                this.setDefaultTargetConnectionFactory(writeConnectionFactory())
            }

    @Bean(name = ["writeConnectionFactory"])
    fun writeConnectionFactory() = getConnectionFactory(properties = writeDataSourceProperties)

    @Bean(name = ["readConnectionFactory"])
    fun readConnectionFactory() = getConnectionFactory(properties = readDataSourceProperties)

    /**
     * get Connection factory
     */
    private fun getConnectionFactory(properties: BaseDataSourceProperties): ConnectionFactory =
        ConnectionFactoryOptions.builder()
            .option(DRIVER, properties.driver())
            .option(HOST, properties.host())
            .option(PORT, properties.port())
            .option(USER, properties.username())
            .option(PASSWORD, properties.password())
            .option(DATABASE, properties.database()) // optional, default null, null means not specifying the database
            .option(CONNECT_TIMEOUT, Duration.ofSeconds(3)) // optional, default null, null means no timeout
            .option(Option.valueOf("allowPublicKeyRetrieval"), "true")
            .option(Option.valueOf("useSSL"), "false")
            .option(Option.valueOf("rewriteBatchedStatements"), "true")
            .option(Option.valueOf("profileSQL"), "true")
            .build()
            .run {
                ConnectionFactories.get(this)
            }

    @Bean("reactiveTransactionManager")
    fun transactionManager(
        @Qualifier("connectionFactory")
        connectionFactory: ConnectionFactory,
    ): ReactiveTransactionManager = R2dbcTransactionManager(connectionFactory)

    @Bean
    fun r2dbcEntityOperations(connectionFactory: ConnectionFactory): R2dbcEntityOperations {
        val dialect = DialectResolver.getDialect(connectionFactory)

        val strategy = DefaultReactiveDataAccessStrategy(dialect)

        val databaseClient =
            DatabaseClient.builder()
                .connectionFactory(connectionFactory)
                .bindMarkers(dialect.bindMarkersFactory)
                .build()

        return R2dbcEntityTemplate(databaseClient, strategy)
    }
}
