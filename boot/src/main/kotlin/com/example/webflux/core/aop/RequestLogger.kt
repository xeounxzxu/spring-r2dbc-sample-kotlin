package com.example.webflux.core.aop

/**
 * Request Log 를 위한 어노테이션
 *
 * @author newbalancer
 *
 * @see [com.example.webflux.core.aop.RequestAspect.kt]
 * @see [com.example.webflux.api.web.TestController]
 * @see [com.example.webflux.api.web.ItemController]
 * @see [com.example.webflux.api.web.MileageController]
 */
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
@Retention(value = AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class RequestLogger
