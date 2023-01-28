package com.example.webflux.core.aop

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
@Retention(value = AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class RequestTraceLogger
