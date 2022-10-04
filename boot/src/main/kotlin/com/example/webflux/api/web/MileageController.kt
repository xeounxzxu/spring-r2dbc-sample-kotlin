package com.example.webflux.api.web

import com.example.webflux.api.service.MileageService
import com.example.webflux.api.service.data.SaveMileageDTO
import com.example.webflux.api.service.data.UpdateMileageDTO
import com.example.webflux.domain.Mileage
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/mileage")
class MileageController constructor(
    private val mileageService: MileageService
) {

    @PostMapping
    suspend fun created(@RequestBody dto: SaveMileageDTO): Mileage = mileageService.created(dto)

    @PatchMapping("/user/{id}")
    suspend fun updated(@PathVariable id: Long, @RequestBody dto: UpdateMileageDTO) =
        mileageService.updated(userId = id, dto = dto)
}