package com.example.webflux.config.extend

import io.r2dbc.spi.ConnectionFactory
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.reflect.MethodSignature

enum class MultiRoutingType {
    READ,
    WRITE
}

annotation class MultiRouting constructor(
    val type: MultiRoutingType,
) {

}

// @Aspect
// @Component
class MultiRoutingAspect constructor(
    private val connectionFactory: ConnectionFactory,
) {

    @Around("@annotation(com.example.webflux.config.extend.MultiRouting)")
    fun multiRouting(joinPoint: ProceedingJoinPoint): Any {

        val annotation = (joinPoint.signature as MethodSignature).method.getAnnotation(MultiRouting::class.java)

        // // database type
        // val databaseType = annotation.type.name
        //
        // val factory = (connectionFactory as MultiRoutingConnectionFactory)

        return joinPoint.proceed()
    }
}