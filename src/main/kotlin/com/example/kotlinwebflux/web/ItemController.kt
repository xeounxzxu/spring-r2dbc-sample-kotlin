package com.example.kotlinwebflux.web

import com.example.kotlinwebflux.domain.Item
import com.example.kotlinwebflux.service.ItemService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/items")
class ItemController
constructor(
    private val itemService: ItemService,
) {

    @GetMapping()
    fun getItems(): Flux<Item> = itemService.getItems()
}