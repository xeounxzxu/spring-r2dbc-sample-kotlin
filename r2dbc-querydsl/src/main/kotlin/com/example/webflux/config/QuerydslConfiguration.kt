package com.example.webflux.config

import com.querydsl.sql.MySQLTemplates
import com.querydsl.sql.SQLTemplates
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class QuerydslConfiguration {

    @Bean
    fun sqlTemplates(): SQLTemplates {
        return MySQLTemplates()
    }
}
