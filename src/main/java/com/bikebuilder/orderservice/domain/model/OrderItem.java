package com.bikebuilder.orderservice.domain.model;

import com.bikebuilder.orderservice.application.port.in.command.OrderCreateCommand.OrderItemData;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.With;

@Getter
@Builder
@AllArgsConstructor
@With
@ToString
public class OrderItem {

    private UUID id;
    private UUID productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    public static OrderItem parseItemData(OrderItemData data) {
        return OrderItem.builder()
            .productId(data.productId())
            .name(data.name())
            .price(data.price())
            .quantity(data.quantity())
            .build();
    }
}
