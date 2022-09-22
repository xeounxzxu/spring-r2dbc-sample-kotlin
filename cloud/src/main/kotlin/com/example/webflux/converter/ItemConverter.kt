package com.example.webflux.converter

import com.example.webflux.constants.ItemType
import org.springframework.data.convert.WritingConverter
import org.springframework.data.r2dbc.convert.EnumWriteSupport

@WritingConverter
class ItemTypeConverter : EnumWriteSupport<ItemType>() {
    override fun convert(enumInstance: ItemType): ItemType {
        return super.convert(enumInstance)
    }
}
