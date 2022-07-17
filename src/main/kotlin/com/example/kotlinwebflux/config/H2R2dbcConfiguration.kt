package com.example.kotlinwebflux.config

import io.r2dbc.h2.H2ConnectionConfiguration
import io.r2dbc.h2.H2ConnectionFactory
import io.r2dbc.h2.H2ConnectionOption
import io.r2dbc.spi.ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer

@Configuration
@EnableRedisRepositories
class H2R2dbcConfiguration : AbstractR2dbcConfiguration() {

    override fun connectionFactory(): ConnectionFactory =
        H2ConnectionFactory(
            H2ConnectionConfiguration.builder()
                .inMemory("testdb")
                .property(H2ConnectionOption.DB_CLOSE_DELAY, "-1")
                .username("sa")
                .build()
        )

    @Bean
    fun setupH2DataBase(): ConnectionFactoryInitializer =
        ConnectionFactoryInitializer()
            .apply {
                this.setConnectionFactory(connectionFactory())
            }
}