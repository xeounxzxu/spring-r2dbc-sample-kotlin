package com.example.webflux.domain.constants

/**
 * item's status type enum class
 *
 * @property name is item status
 * @property ordinal is item index
 *
 * @author newbalancer
 */
enum class ItemType {
    /**
     * Not show user type
     */
    SOLD_OUT,

    /**
     * Item count is discount
     */
    DISCOUNT,

    /**
     * User show item
     */
    SALE,

    /**
     * this not use item
     */
    WAIT,
}
