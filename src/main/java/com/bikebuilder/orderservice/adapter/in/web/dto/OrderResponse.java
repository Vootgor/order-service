package com.bikebuilder.orderservice.adapter.in.web.dto;

import com.bikebuilder.orderservice.domain.enums.OrderStatus;
import com.bikebuilder.orderservice.domain.model.Order;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record OrderResponse(
    UUID id,
    UUID userId,
    OrderStatus orderStatus,
    Instant created,
    List<OrderItemResponse> items
) {

    public static OrderResponse fromOrder(Order order) {
        List<OrderItemResponse> items = order.getItems().stream()
            .map(OrderItemResponse::from)
            .toList();

        return new OrderResponse(
            order.getId(),
            order.getUserId(),
            order.getStatus(),
            order.getCreated(),
            items
        );
    }

}
