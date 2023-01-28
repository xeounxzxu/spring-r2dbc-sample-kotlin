package com.example.webflux.core.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestMapping


@Aspect
@Component
class RequestTraceAspect {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @Around("@annotation(com.example.webflux.core.aop.RequestTraceLogger)")
    fun loggerRequest(joinPoint: ProceedingJoinPoint): Any = joinPoint.let {

        val targetClass = joinPoint.target.javaClass

        val data = getRequestUrl(joinPoint, targetClass)

        logger.info(data.toString())

        it.proceed()
    }

    private fun <T> getRequestUrl(joinPoint: ProceedingJoinPoint, targetClass: Class<T>): RequestMapping {
        return targetClass.getAnnotation(RequestMapping::class.java)
    }

}
