package com.bikebuilder.orderservice.application.port.out;

import java.util.UUID;

public interface DeleteOrdersPort {

    void deleteAllOrdersByUserId(UUID userId);
}
