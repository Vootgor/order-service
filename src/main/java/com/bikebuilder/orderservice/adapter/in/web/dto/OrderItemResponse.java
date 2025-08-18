package com.bikebuilder.orderservice.adapter.in.web.dto;

import com.bikebuilder.orderservice.domain.model.OrderItem;
import java.math.BigDecimal;
import java.util.UUID;

public record OrderItemResponse(
    UUID id,
    UUID productId,
    String title,
    BigDecimal price,
    Integer quantity
) {

    public static OrderItemResponse from(OrderItem item) {
        return new OrderItemResponse(
            item.getId(),
            item.getProductId(),
            item.getTitle(),
            item.getPrice(),
            item.getQuantity()
        );
    }
}
