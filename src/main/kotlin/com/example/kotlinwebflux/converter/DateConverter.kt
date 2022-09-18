package com.example.kotlinwebflux.converter

import io.r2dbc.spi.Row
import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.ReadingConverter
import java.time.LocalDate

/**
 * long value to LocalDate
 *
 * Date Read Converter Class
 */
@ReadingConverter
class ReadingDateConverter : Converter<Row, LocalDate> {

    override fun convert(source: Row): LocalDate? {
        val createdAt = source.get("created_at", Long::class.java)
        return null
    }
}