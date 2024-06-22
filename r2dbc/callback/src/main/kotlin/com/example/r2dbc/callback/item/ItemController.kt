package com.example.r2dbc.callback.item

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/items")
class ItemController(
    private val service: ItemService,
) {
    @GetMapping("/{id}")
    suspend fun getOne(
        @PathVariable id: Long,
    ): ItemEntity {
        return checkNotNull(service.getOne(id))
    }
}
