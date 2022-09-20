package com.example.webflux.service

import com.example.webflux.config.extend.MultiRouting
import com.example.webflux.config.extend.MultiRoutingType
import com.example.webflux.domain.Item
import com.example.webflux.repository.ItemRepository
import com.example.webflux.service.data.ItemDTO
import com.example.webflux.service.data.ItemInfo
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ItemService constructor(
    private val itemRepository: ItemRepository,
) {

    @Transactional(value = "writeTransactionManager")
    suspend fun created(dto: ItemDTO): Item = itemRepository.save(dto.toCreatedStateEntity())

    @Transactional(value = "writeTransactionManager", readOnly = true)
    suspend fun getAll(): Flow<Item> = itemRepository.findAll()

    @Transactional(value = "writeTransactionManager", readOnly = true)
    suspend fun get(id: Long): Item? = itemRepository.findById(id)

    // todo: Multi DataSource Type Change AOP
    // this change to by datasource ...
    @MultiRouting(MultiRoutingType.WRITE)
    @Transactional(value = "writeTransactionManager", readOnly = true)
    suspend fun get(name: String): ItemInfo? = itemRepository.findByName(name, ItemInfo::class.java)
}