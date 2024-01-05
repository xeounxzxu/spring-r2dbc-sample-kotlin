package com.example.webflux.util

import com.example.webflux.api.service.data.ItemDTO
import com.example.webflux.domain.Item
import reactor.core.publisher.Flux

object ItemUtil {

    fun newItemDTO(item: Item): ItemDTO = ItemDTO(
        name = item.name!!,
        count = item.count,
        limitCount = item.limitCount
    )

    fun <T> newFlux(value: T): Flux<T> = value.let { v ->
        Flux.create {
            it.next(v)
            it.complete()
        }
    }
}
