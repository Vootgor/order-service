package com.bikebuilder.orderservice.domain.model;

import com.bikebuilder.orderservice.application.port.in.command.OrderCreateCommand;
import com.bikebuilder.orderservice.domain.enums.OrderStatus;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.With;

@Getter
@AllArgsConstructor
@ToString
@Builder
@With
public class Order {

    private UUID id;
    private UUID userId;
    private OrderStatus status;
    private BigDecimal totalAmount;
    private Instant created;
    private Instant updated;
    private List<OrderItem> items;

    public static Order create(OrderCreateCommand command) {

        List<OrderItem> items = command.items().stream()
            .map(OrderItem::parseItemData)
            .toList();

        return Order.builder()
            .userId(command.userId())
            .created(Instant.now())
            .updated(null)
            .status(OrderStatus.CREATED)
            .items(items)
            .totalAmount(items.stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add))
            .build();
    }
}
