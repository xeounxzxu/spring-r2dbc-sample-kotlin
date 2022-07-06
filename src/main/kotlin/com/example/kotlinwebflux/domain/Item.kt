package com.example.kotlinwebflux.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Item constructor(
    @Id private var id: Long? = null, @Column(nullable = false) private var name: String? = null
) {}