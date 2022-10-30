package com.example.webflux.util

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.mockito.BDDMockito
import org.springframework.core.io.ClassPathResource
import java.io.File
import java.nio.file.Files

object MockUtil {

    fun <T : Any> readJsonFileToClass(jsonFileName: String, ofClass: Class<T>): T? {

        val resource: File = ClassPathResource(jsonFileName).file

        val text = String(Files.readAllBytes(resource.toPath()))

        val objectMapper = ObjectMapper()

        objectMapper.registerModule(KotlinModule())

        return objectMapper.readValue(text, ofClass)
    }

    fun <T> any(): T {
        BDDMockito.any<T>()
        return uninitialized()
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> uninitialized(): T = null as T
}