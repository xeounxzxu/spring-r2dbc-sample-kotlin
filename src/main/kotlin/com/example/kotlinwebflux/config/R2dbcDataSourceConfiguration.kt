package com.example.kotlinwebflux.config

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
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.r2dbc.connection.R2dbcTransactionManager
import java.time.Duration

@Configuration
@EnableR2dbcRepositories(
    basePackages = [
        "com.example.kotlinwebflux.repository"
    ]
)
class R2dbcDataSourceConfiguration constructor(
    @Qualifier("read.datasource-com.example.kotlinwebflux.config.ReadDataSourceProperties")
    private val readDataSourceProperties: BaseDataSourceProperties,
    @Qualifier("write.datasource-com.example.kotlinwebflux.config.WriteDataSourceProperties")
    private val writeDataSourceProperties: BaseDataSourceProperties,
) : AbstractR2dbcConfiguration() {

    @Bean(name = ["connectionFactory"])
    override fun connectionFactory(): ConnectionFactory = MultiRoutingConnectionFactory().apply {

        val factories: HashMap<String, ConnectionFactory> = hashMapOf(
            WriteDataSourceProperties.KEY to writeConnectionFactory()
        )

        this.setTargetConnectionFactories(factories)

        this.setDefaultTargetConnectionFactory(writeConnectionFactory())
    }

    @Bean(name = ["writeConnectionFactory"])
    fun writeConnectionFactory() = getConnectionFactory(properties = writeDataSourceProperties)

    @Bean(name = ["writeTransactionManager"])
    fun writeTransactionManager(@Qualifier("writeConnectionFactory") connectionFactory: ConnectionFactory) =
        R2dbcTransactionManager(connectionFactory)

    @Bean(name = ["readConnectionFactory"])
    fun readConnectionFactory() = getConnectionFactory(properties = readDataSourceProperties)

    @Bean(name = ["readTransactionManager"])
    fun readTransactionManager(@Qualifier("readConnectionFactory") connectionFactory: ConnectionFactory) =
        R2dbcTransactionManager(connectionFactory)

    /**
     * get Connection factory
     */
    private fun getConnectionFactory(properties: BaseDataSourceProperties): ConnectionFactory {

        val options: ConnectionFactoryOptions = ConnectionFactoryOptions.builder()
            .option(DRIVER, properties.driver())
            .option(HOST, properties.host())
            .option(PORT, properties.port())
            .option(USER, properties.username())
            .option(PASSWORD, properties.password())
            .option(DATABASE, properties.database()) // optional, default null, null means not specifying the database
            .option(CONNECT_TIMEOUT, Duration.ofSeconds(3)) // optional, default null, null means no timeout
            .build()

        return ConnectionFactories.get(options)
    }
}


