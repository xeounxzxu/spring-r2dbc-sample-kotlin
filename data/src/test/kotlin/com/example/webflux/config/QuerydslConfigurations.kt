package com.example.webflux.config

import com.example.webflux.Main
import com.querydsl.sql.MySQLTemplates
import com.querydsl.sql.SQLTemplates
import io.r2dbc.h2.H2ConnectionFactory
import io.r2dbc.h2.H2ConnectionOption
import io.r2dbc.spi.ConnectionFactory
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.core.io.ClassPathResource
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.r2dbc.connection.R2dbcTransactionManager
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator
import org.springframework.test.context.TestConstructor
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.util.stream.Collectors
import java.util.stream.Stream

@TestConfiguration
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
                this.addPopulators(ResourceDatabasePopulator(ClassPathResource("sql/common/drop.sql")))
                this.addPopulators(ResourceDatabasePopulator(ClassPathResource("sql/item/schema.sql")))
                this.addPopulators(ResourceDatabasePopulator(ClassPathResource("sql/item/item-data1.sql")))
                this.addPopulators(ResourceDatabasePopulator(ClassPathResource("sql/mileage/schema.sql")))
                this.addPopulators(ResourceDatabasePopulator(ClassPathResource("sql/product/schema.sql")))
            }

            this.setDatabasePopulator(populator)
        }

    @Bean
    fun sqlTemplates(): SQLTemplates {
        return MySQLTemplates()
    }
}

/**
 * Querydsl Base Testing...
 */
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = [Main::class])
abstract class AbstractQuerydslBaseTest {

    @Autowired
    private val repositories: List<ReactiveCrudRepository<*, *>>? = null

    @AfterEach
    fun clearRepositories() {
        block(Flux.concat(
            repositories!!.stream()
                .map { obj: ReactiveCrudRepository<*, *> -> obj.deleteAll() }
                .collect(Collectors.toList()))
            .collectList())
    }

    private fun <T> block(mono: Mono<T>): T? {
        return mono.block(Duration.ofSeconds(10))
    }

    fun <T> block(flux: Flux<T>): List<T>? {
        return block(flux.collectList())
    }

    protected fun given(vararg ts: Mono<*>?): Mono<Void> {
        return Flux.concat(Stream.of(*ts).collect(Collectors.toList())).last().then()
    }
}
