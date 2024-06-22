package com.example.r2dbc.callback.item

import com.example.r2dbc.data.R2dbcRepo
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.data.repository.kotlin.CoroutineSortingRepository

@R2dbcRepo
interface ItemRepository :
    CoroutineCrudRepository<ItemEntity, Long>,
    CoroutineSortingRepository<ItemEntity, Long>
