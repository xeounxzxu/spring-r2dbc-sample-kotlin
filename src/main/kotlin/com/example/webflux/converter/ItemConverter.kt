package com.example.webflux.converter

import com.example.webflux.enums.ItemType
import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.WritingConverter

@WritingConverter
class ItemTypeWritingConverter : Converter<String, ItemType> {

    override fun convert(source: String): ItemType? = ItemType.valueOf(source)
}