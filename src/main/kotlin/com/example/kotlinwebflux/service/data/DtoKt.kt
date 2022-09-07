package com.example.kotlinwebflux.service.data

import org.springframework.beans.factory.annotation.Value

/**
 * Data Projection use to interface ...
 */
interface ItemInfo {

    /**
     * use to name ..
     */
    @Value("#{target.name}")
    fun getName(): String
}