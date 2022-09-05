package com.example.kotlinwebflux.service

import com.example.kotlinwebflux.repository.ItemRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ItemService constructor(
    private val itemRepository: ItemRepository,
) {

    @Transactional(value = "writeTransactionManager", readOnly = true)
    fun getItems() = itemRepository.findAll()
}