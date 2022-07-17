package com.example.kotlinwebflux.config

import org.h2.tools.Server
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.ContextClosedEvent
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import java.sql.SQLException

@Configuration
class H2ServerConfiguration {

    private var webServer: Server? = null

    @Value("\${webclient.h2-console-port}")
    private var h2ConsolePort: String? = null

    @EventListener(ContextRefreshedEvent::class)
    @Throws(SQLException::class)
    fun dataSource() {
        webServer = Server.createWebServer("-webPort", h2ConsolePort).start()
    }

    @EventListener(ContextClosedEvent::class)
    fun stopDataSource() {
        webServer!!.stop()
    }
}