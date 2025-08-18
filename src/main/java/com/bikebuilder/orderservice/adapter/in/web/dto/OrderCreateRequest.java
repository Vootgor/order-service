package com.bikebuilder.orderservice.adapter.in.web.dto;

import com.bikebuilder.orderservice.application.port.in.command.OrderCreateCommand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record OrderCreateRequest(
    @NotNull UUID userId,
    @NotEmpty List<OrderItemRequestDto> items
) {

    public record OrderItemRequestDto(
        @NotNull UUID productId,
        @NotBlank String name,
        @NotBlank BigDecimal price,
        @NotBlank Integer quantity
    ) {

        public OrderCreateCommand.OrderItemData toItemData() {
            return new OrderCreateCommand.OrderItemData(productId, name, price, quantity);
        }
    }

    public OrderCreateCommand toCommand() {
        List<OrderCreateCommand.OrderItemData> commandItems = items.stream()
            .map(OrderItemRequestDto::toItemData)
            .toList();
        return new OrderCreateCommand(userId, commandItems);
    }
}
