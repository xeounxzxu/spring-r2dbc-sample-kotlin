package com.example.kotlinwebflux.config

import com.zaxxer.hikari.HikariDataSource
import org.h2.tools.Server
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.sql.SQLException


@Configuration
class H2Configuration {

    @Bean
    @ConfigurationProperties("datasource.h2")
    @Throws(SQLException::class)
    fun dataSource(): HikariDataSource? {
        Server.createTcpServer("-tcp", "-tcpAllowOthers", "-ifNotExists", "-tcpPort", 9095.toString() + "").start()
        return HikariDataSource()
    }
}