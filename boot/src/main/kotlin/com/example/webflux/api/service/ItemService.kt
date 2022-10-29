package com.example.webflux.api.service

import com.example.webflux.api.service.data.ItemDTO
import com.example.webflux.domain.Item
import com.example.webflux.projection.ItemInfo
import com.example.webflux.projection.OnlyItemName
import com.example.webflux.querydsl.ItemQuerydslRepository
import com.example.webflux.repository.ItemRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux

@Service
class ItemService constructor(
    private val itemRepository: ItemRepository,
    private val itemQuerydslRepository: ItemQuerydslRepository,
) {

    @Transactional(value = "reactiveTransactionManager")
    suspend fun created(dto: ItemDTO): Item = itemRepository.save(dto.toNew())

    // todo : flux changed to flow
    @Transactional(value = "reactiveTransactionManager", readOnly = true)
    fun getAll(): Flux<ItemInfo> = itemQuerydslRepository.getAllBy(ItemInfo::class.java)

    @Transactional(value = "reactiveTransactionManager", readOnly = true)
    suspend fun get(id: Long): Item? = itemRepository.findById(id)

    // todo : checked : why dynamic projections not working...?
    @Transactional(value = "reactiveTransactionManager", readOnly = true)
    suspend fun get(name: String): OnlyItemName? = itemRepository.findItemByName(name)

    @Transactional(readOnly = true)
    fun getAllItemAndItemHistory(): Flux<ItemInfo> =
        itemQuerydslRepository.getAllItemAndItemHistoryBy(ItemInfo::class.java)
}