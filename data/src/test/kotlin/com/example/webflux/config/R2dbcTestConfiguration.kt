package com.example.webflux.config

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.FilterType
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@TestConfiguration
@EnableR2dbcAuditing
@ComponentScan(
    basePackages = ["com.example.webflux.repository"],
    excludeFilters = [ComponentScan.Filter(
        type = FilterType.ASSIGNABLE_TYPE,
        classes = []
    )]
)
@EnableR2dbcRepositories(
    basePackages = [
        "com.example.webflux.repository",
    ]
)
class R2dbcTestConfiguration : AbstractR2dbRepositoryConfiguration() {

}