package com.example.webflux.web

import com.example.webflux.service.ItemService
import com.example.webflux.service.data.ItemInfo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/items")
class ItemController
constructor(
    private val itemService: ItemService,
) {

    // @PostMapping("")
    // fun created(@RequestBody dto: ItemDTO) = itemService.created(dto)
    //
    // @GetMapping()
    // fun getAll(): Flux<Item> = itemService.getAll()
    //
    // @GetMapping("/{id}")
    // fun get(@PathVariable id: Long): Mono<Item> = itemService.get(id)

    @GetMapping("/name")
    suspend fun get(name: String): ItemInfo? = itemService.get(name)
}