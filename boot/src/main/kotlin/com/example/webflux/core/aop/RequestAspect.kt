package com.example.webflux.core.aop

import mu.KLogging
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

/**
 * Request 를 로그를 남기는 AOP
 *
 * @see [com.example.webflux.core.aop.RequestLogger.kt]
 * @see [com.example.webflux.api.web.TestController]
 * @see [com.example.webflux.api.web.ItemController]
 * @see [com.example.webflux.api.web.MileageController]
 *
 * @author newbalancer
 */
@Aspect
@Component
class RequestAspect {

    private val log = KLogging().logger

    @Around("@annotation(com.example.webflux.core.aop.RequestLogger)")
    fun loggerRequest(joinPoint: ProceedingJoinPoint): Any = joinPoint.let {
        log.info {
            "aop working"
        }
        it.proceed()
    }
}
