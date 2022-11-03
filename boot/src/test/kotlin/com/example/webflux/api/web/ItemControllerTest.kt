package com.example.webflux.api.web

import com.example.webflux.api.service.ItemService
import com.example.webflux.domain.Item
import com.example.webflux.projection.ItemInfo
import com.example.webflux.repository.ItemRepository
import com.example.webflux.util.ItemUtil
import com.example.webflux.util.MockUtil.readJsonFileToClass
import com.ninjasquad.springmockk.MockkBean
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody
import reactor.core.publisher.Flux

@ExtendWith(SpringExtension::class)
@WebFluxTest(ItemController::class)
internal class ItemControllerTest {

    @Autowired
    private lateinit var webTestClient: WebTestClient

    @MockkBean
    private lateinit var itemService: ItemService

    @BeforeEach
    fun init() {
        MockKAnnotations.init(this)
    }

    @Test
    @Order(1)
    fun `Save Item Data`() {

        val mock = readJsonFileToClass("json/item/item-savedata1.json", Item::class.java)!!

        val dto = ItemUtil.newItemDTO(mock)

        coEvery {
            itemService.created(any())
        } returns mock

        val action = webTestClient.post().uri("/items")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(dto)
            .exchange()

        coVerify {
            itemService.created(any())
        }

        confirmVerified(itemService)

        action.expectStatus()
            .isCreated()
            .expectBody(Item::class.java)
            .value {
                it.equals(mock)
            }
    }

    @Test
    @Order(2)
    fun `Get All Item`() {

        val value = readJsonFileToClass("json/item/item-querydsl-getAllBy.json", ItemInfo::class.java)!!

        val mock: Flux<ItemInfo> = ItemUtil.newFlux(value)

        every {
            itemService.getAll()
        } returns mock

        val action = webTestClient.get()
            .uri("/items")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()

        verify {
            itemService.getAll()
        }

        confirmVerified(itemService)

        action.expectStatus()
            .isOk()
            .expectBody()
            .jsonPath("$[0].id").isEqualTo(value.id.toString())
            .jsonPath("$[0].name").isEqualTo(value.name.toString())
            .jsonPath("$[0].type").isEqualTo(value.type?.name.toString())
            .jsonPath("$[0].count").isEqualTo(value.count.toString())
            .jsonPath("$[0].limitCount").isEqualTo(value.limitCount.toString())
            .jsonPath("$[0].createdAt").isEqualTo(value.createdAt.toString())
    }
}
