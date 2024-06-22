package com.example.r2dbc.callback.item

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ItemService(
    private val itemRepository: ItemRepository,
) {
    @Transactional("reactiveTransactionManager")
    suspend fun getOne(id: Long): ItemEntity? {
        return itemRepository.findById(id)
    }
}
