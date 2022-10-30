package com.example.webflux.util

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.core.io.ClassPathResource
import java.io.File
import java.nio.file.Files

object MockUtil {

    fun <T : Any> readJsonFileToClass(jsonFileName: String, ofClass: Class<T>): T? {

        val resource: File = ClassPathResource(jsonFileName).file

        val text = String(Files.readAllBytes(resource.toPath()))

        val objectMapper = ObjectMapper()

        objectMapper.registerModule(KotlinModule())

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

        return objectMapper.readValue(text, ofClass)
    }
}