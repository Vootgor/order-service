package com.bikebuilder.orderservice.adapter.in.web;

import com.bikebuilder.orderservice.application.port.in.command.OrderCreateCommand;
import com.bikebuilder.orderservice.domain.model.Order;

public interface CreateOrderUseCase {

    Order createOrder(OrderCreateCommand command);
}
