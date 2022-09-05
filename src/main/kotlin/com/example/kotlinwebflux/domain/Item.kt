package com.example.kotlinwebflux.domain

import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.Table

// @Entity
@Table(name = "item")
data class Item constructor(
    @Id val id: Long? = null,
    @Column(nullable = false) val name: String? = null,
) {
}