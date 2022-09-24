package com.example.webflux.api.service

import com.example.webflux.api.service.data.ItemDTO
import com.example.webflux.api.service.data.ItemInfo
import com.example.webflux.domain.Item
import com.example.webflux.repository.ItemRepository
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ItemService constructor(
    private val itemRepository: ItemRepository,
) {

    @Transactional(value = "transactionManager")
    suspend fun created(dto: ItemDTO): Item = itemRepository.save(dto.toNew())

    @Transactional(value = "transactionManager", readOnly = true)
    suspend fun getAll(): Flow<Item> = itemRepository.findAll()

    @Transactional(value = "transactionManager", readOnly = true)
    suspend fun get(id: Long): Item? = itemRepository.findById(id)

    // todo: Multi DataSource Type Change AOP
    // this change to by datasource ...
    // @MultiRouting(MultiRoutingType.WRITE)
    @Transactional(value = "transactionManager", readOnly = true)
    suspend fun get(name: String): ItemInfo? = itemRepository.findByName(name, ItemInfo::class.java)
}