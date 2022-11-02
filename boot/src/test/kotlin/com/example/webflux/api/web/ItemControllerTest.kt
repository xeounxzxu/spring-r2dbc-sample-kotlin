package com.example.webflux.api.web

import com.example.webflux.api.service.ItemService
import com.example.webflux.domain.Item
import com.example.webflux.repository.ItemRepository
import com.example.webflux.util.ItemUtil
import com.example.webflux.util.MockUtil.readJsonFileToClass
import com.ninjasquad.springmockk.MockkBean
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient

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

        action.expectStatus().isOk()
            .expectBody(Item::class.java)
            .value {
                it.equals(mock)
            }
    }
}
