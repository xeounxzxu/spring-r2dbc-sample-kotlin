package com.example.webflux.querydsl

import com.example.webflux.domain.Item
import com.infobip.spring.data.r2dbc.QuerydslR2dbcRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemQuerydslRepository : QuerydslR2dbcRepository<Item, Long> {
}