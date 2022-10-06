package com.example.webflux.querydsl

import com.example.webflux.projection.OnlyItemName
import io.r2dbc.h2.H2ConnectionFactory
import io.r2dbc.h2.H2ConnectionOption
import io.r2dbc.spi.ConnectionFactory
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.core.io.ClassPathResource
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.r2dbc.connection.R2dbcTransactionManager
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

@TestConfiguration
@ComponentScan(
    basePackages = [
        "com.example.webflux.querydsl"
    ]
)
class QuerydslTestConfiguration : AbstractR2dbcConfiguration() {

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

@Disabled
@ExtendWith(value = [SpringExtension::class])
@ContextConfiguration(
    classes = [
        QuerydslTestConfiguration::class
    ]
)
class ItemQuerydslRepositoryTest {

    @Autowired
    private lateinit var itemQuerydslRepository: ItemQuerydslRepository

    @Test
    fun `전체 조회 Projections 테스트 케이스`() {

        val entities = itemQuerydslRepository.getAllBy(OnlyItemName::class.java)

        assertNotNull(entities)
    }
}