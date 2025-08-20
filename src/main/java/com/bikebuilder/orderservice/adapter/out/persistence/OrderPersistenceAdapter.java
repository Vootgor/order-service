package com.bikebuilder.orderservice.adapter.out.persistence;

import com.bikebuilder.orderservice.application.port.out.DeleteOrdersPort;
import com.bikebuilder.orderservice.application.port.out.SaveOrderPort;
import com.bikebuilder.orderservice.domain.model.Order;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderPersistenceAdapter implements
    SaveOrderPort,
    DeleteOrdersPort
{

    private final OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        OrderEntity orderEntity = OrderEntity.create(order);
        OrderEntity saved = orderRepository.save(orderEntity);
        return saved.toOrder();
    }

    @Override
    public void deleteAllOrdersByUserId(UUID userId) {
        orderRepository.deleteAllByUserId(userId);
    }
}
