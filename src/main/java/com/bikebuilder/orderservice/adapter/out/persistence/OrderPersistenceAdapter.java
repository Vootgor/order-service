package com.bikebuilder.orderservice.adapter.out.persistence;

import com.bikebuilder.orderservice.application.port.out.SaveOrderPort;
import com.bikebuilder.orderservice.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderPersistenceAdapter implements
    SaveOrderPort {

    private final OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        OrderEntity orderEntity = OrderEntity.create(order);
        OrderEntity saved = orderRepository.save(orderEntity);
        return saved.toOrder();
    }
}
