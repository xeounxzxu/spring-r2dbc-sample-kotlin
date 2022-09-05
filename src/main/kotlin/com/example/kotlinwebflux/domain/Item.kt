package com.example.kotlinwebflux.domain

import javax.persistence.Id
import javax.persistence.Table

@Table(name = "item")
data class Item constructor(
    @Id val id: Long,
    val name: String,
) {
}