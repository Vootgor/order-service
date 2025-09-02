package com.bikebuilder.orderservice.adapter.in.web;


import com.bikebuilder.orderservice.adapter.in.web.dto.OrderCreateRequest;
import com.bikebuilder.orderservice.adapter.in.web.dto.OrderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/orders")
public class OrderController {

    private final CreateOrderUseCase createOrderUseCase;

    @PostMapping("/")
    public OrderResponse createOrder(@RequestBody @Valid OrderCreateRequest request){
        var command = request.toCommand();
        var response = createOrderUseCase.createOrder(command);
        return OrderResponse.fromOrder(response);
    }
}
