package com.example.webflux.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

sealed interface BaseDataSourceProperties {

    fun driver(): String
    fun host(): String
    fun port(): Int
    fun database(): String
    fun username(): String
    fun password(): String
}

@ConstructorBinding
@ConfigurationProperties(prefix = "read.datasource")
data class ReadDataSourceProperties constructor(
    private val driver: String,
    private val host: String,
    private val port: String,
    private val database: String,
    private val username: String,
    private val password: String,
) : BaseDataSourceProperties {

    companion object {
        const val KEY = "read"
    }

    override fun driver(): String = this.driver

    override fun host(): String = this.host

    override fun port(): Int = this.port.toInt()

    override fun database(): String = this.database

    override fun username(): String = this.username

    override fun password(): String = this.password
}

@ConstructorBinding
@ConfigurationProperties(prefix = "write.datasource")
data class WriteDataSourceProperties constructor(
    private val driver: String,
    private val host: String,
    private val port: String,
    private val database: String,
    private val username: String,
    private val password: String,
) : BaseDataSourceProperties {

    companion object {
        const val KEY = "write"
    }

    override fun driver(): String = this.driver

    override fun host(): String = this.host

    override fun port(): Int = this.port.toInt()

    override fun database(): String = this.database

    override fun username(): String = this.username

    override fun password(): String = this.password
}
