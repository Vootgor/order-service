package com.bikebuilder.orderservice.adapter.out.messaging;

import com.bikebuilder.orderservice.adapter.in.web.dto.UserDeletedEvent;
import com.bikebuilder.orderservice.application.port.in.DeleteOrdersByUserIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDeletedEventListener {

    private final DeleteOrdersByUserIdUseCase deleteOrdersUseCase;

    @KafkaListener(topics = "user-deleted", groupId = "order-service-group")
    public void listenUserDeleted(UserDeletedEvent event) {
        deleteOrdersUseCase.deleteOrdersByUserId(event.getUserId());
    }
}
