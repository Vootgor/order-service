package com.bikebuilder.orderservice.application.port.out;

import com.bikebuilder.orderservice.domain.model.Order;

public interface SaveOrderPort {

    Order save(Order order);
}
