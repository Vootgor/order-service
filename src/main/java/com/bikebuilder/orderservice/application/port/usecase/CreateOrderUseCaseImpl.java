package com.bikebuilder.orderservice.application.port.usecase;

import com.bikebuilder.orderservice.adapter.in.web.CreateOrderUseCase;
import com.bikebuilder.orderservice.application.port.in.command.OrderCreateCommand;
import com.bikebuilder.orderservice.application.port.out.SaveOrderPort;
import com.bikebuilder.orderservice.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateOrderUseCaseImpl implements CreateOrderUseCase {

    private final SaveOrderPort saveOrderPort;

    @Override
    public Order createOrder(OrderCreateCommand command) {
        Order order = Order.create(command);
        return saveOrderPort.save(order);
    }
}
