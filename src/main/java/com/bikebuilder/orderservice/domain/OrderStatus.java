package com.bikebuilder.orderservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Предоставляет статус для заказа
 */
@Getter
@AllArgsConstructor
public enum OrderStatus {
    CREATED("Создан"),
    PAID("Оплачен"),
    SHIPPED("Отправлен"),
    COMPLETED("Выполнен"),
    CANCELLED("Отменён");

    private final String description;
}
