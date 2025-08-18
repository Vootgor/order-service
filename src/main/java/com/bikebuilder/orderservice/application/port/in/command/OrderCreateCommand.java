package com.bikebuilder.orderservice.application.port.in.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record OrderCreateCommand(
    UUID userId,
    List<OrderItemData> items
) {

    public record OrderItemData(
        @NotNull UUID productId,
        @NotBlank String name,
        @NotBlank BigDecimal price,
        @NotBlank Integer quantity
    ) {

    }

}
