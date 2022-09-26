package com.example.webflux.repository

import com.example.webflux.config.ItemRepositoryTestConfiguration
import com.example.webflux.config.QuerydslConfigTest
import com.example.webflux.projection.ItemInfoDTO
import com.example.webflux.querydsl.ItemQuerydslRepository
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(value = [SpringExtension::class])
@ContextConfiguration(
    classes = [ItemRepositoryTestConfiguration::class, QuerydslConfigTest::class]
)
class ItemQuerydslRepositoryTest {

    @Autowired
    private lateinit var itemQuerydslRepository: ItemQuerydslRepository

    @Test
    fun `전체 조회 Projections 테스트 케이스`() {

        val entities = itemQuerydslRepository.getAllBy(ItemInfoDTO::class.java)

        assertNotNull(entities)
    }
}