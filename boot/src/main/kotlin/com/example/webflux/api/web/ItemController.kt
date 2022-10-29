package com.example.webflux.api.web

import com.example.webflux.api.service.ItemService
import com.example.webflux.api.service.data.ItemDTO
import com.example.webflux.domain.Item
import com.example.webflux.projection.ItemInfo
import com.example.webflux.projection.OnlyItemName
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/items")
class ItemController
constructor(
    private val itemService: ItemService,
) {

    @PostMapping("")
    suspend fun created(@RequestBody dto: ItemDTO) = itemService.created(dto)

    @GetMapping()
    fun getAll(): Flux<ItemInfo> = itemService.getAll()

    @GetMapping("/{id}")
    // todo: #DEV-001 ResponseEntity<ItemInfo> not working -> checked to webflux why not working...?
    suspend fun get(@PathVariable id: Long): Item? = itemService.get(id)

    @GetMapping("/name")
    // todo: #DEV-001 ResponseEntity<ItemInfo> not working -> checked to webflux why not working...?
    suspend fun get(name: String): OnlyItemName? = itemService.get(name)

    @GetMapping("/history")
    fun getAllItemAndHistory() = itemService.getAllItemAndItemHistory()
}