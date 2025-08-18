package com.bikebuilder.orderservice.application.port.usecase;

import com.bikebuilder.orderservice.application.port.in.DeleteOrdersByUserIdUseCase;
import com.bikebuilder.orderservice.application.port.out.DeleteOrdersPort;
import jakarta.transaction.Transactional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteOrdersByUserIdUseCaseImpl implements DeleteOrdersByUserIdUseCase {

    private final DeleteOrdersPort deleteOrdersPort;

    @Override
    @Transactional
    public void deleteOrdersByUserId(UUID userId) {
        deleteOrdersPort.deleteAllOrdersByUserId(userId);
    }
}
