package com.example.webflux.repository

import com.example.webflux.config.R2dbcTestConfiguration
import com.example.webflux.domain.Product
import com.example.webflux.projection.ProductSalePointInfo
import com.example.webflux.util.MockUtil
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@ContextConfiguration(
    classes = [
        R2dbcTestConfiguration::class
    ]
)
internal class ProductRepositoryTest {

    @Autowired
    private lateinit var productRepository: ProductRepository

    @Test
    @Order(1)
    @OptIn(ExperimentalCoroutinesApi::class)
    fun `저장 테스트 케이스`() = runTest {

        val mock: Product =
            MockUtil.readJsonFileToClass("json/product/save_.json", Product::class.java)!!

        val entity = productRepository.save(mock)

        assertNotNull(entity.id)
        assertEquals(mock.title, entity.title)
        assertEquals(mock.salePoint, entity.salePoint)
        assertNotNull(entity.createdAt)
        assertNotNull(entity.updatedAt)
    }

    @Test
    @Order(2)
    @OptIn(ExperimentalCoroutinesApi::class)
    fun `상품 조회 테스트 케이스 1`() = runTest {

        val mockId = 1L

        val mock: Product =
            MockUtil.readJsonFileToClass("json/product/save_.json", Product::class.java)!!

        // todo : changed class file ...
        val entity: ProductSalePointInfo = productRepository.findProductById(mockId)!!

        assertNotNull(entity.getId())
        assertEquals(mock.title, entity.getTitle())
        assertEquals(mock.salePoint, entity.getSalePoint())
    }
}