package com.example.webflux.api.service

import com.example.webflux.api.service.data.ItemDTO
import com.example.webflux.api.service.data.ItemInfo
import com.example.webflux.domain.Item
import com.example.webflux.dto.ItemInfoDTO
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
    fun getAll(): Flux<ItemInfoDTO> = itemQuerydslRepository.getAllBy(ItemInfoDTO::class.java)

    @Transactional(value = "reactiveTransactionManager", readOnly = true)
    suspend fun get(id: Long): Item? = itemRepository.findById(id)

    @Transactional(value = "reactiveTransactionManager", readOnly = true)
    suspend fun get(name: String): ItemInfo? = itemRepository.findByName(name, ItemInfo::class.java)
}