package com.bikebuilder.orderservice.application.port.in;

import java.util.UUID;

public interface DeleteOrdersByUserIdUseCase {

    void deleteOrdersByUserId(UUID userId);
}
