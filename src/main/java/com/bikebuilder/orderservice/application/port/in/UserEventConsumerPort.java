package com.bikebuilder.orderservice.application.port.in;

import java.util.UUID;

public interface UserEventConsumerPort {

    void handleUserDeleted(UUID userId);
}
