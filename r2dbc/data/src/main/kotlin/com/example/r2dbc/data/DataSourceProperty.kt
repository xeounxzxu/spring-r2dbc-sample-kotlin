package com.example.r2dbc.data

import org.springframework.boot.context.properties.ConfigurationProperties

sealed interface BaseDataSourceProperties {
    fun driver(): String

    fun host(): String

    fun port(): Int

    fun database(): String

    fun username(): String

    fun password(): String
}

@ConfigurationProperties("read.datasource")
data class ReadDataSourceProperties(
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

@ConfigurationProperties(prefix = "write.datasource")
data class WriteDataSourceProperties(
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
