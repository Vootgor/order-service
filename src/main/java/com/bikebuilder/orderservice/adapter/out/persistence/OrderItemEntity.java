package com.bikebuilder.orderservice.adapter.out.persistence;

import com.bikebuilder.orderservice.domain.model.OrderItem;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_items")
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private OrderEntity order;

    @Column(name = "product_id", nullable = false)
    private UUID productId;

    @Column(nullable = false)
    private String name;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer quantity;

    public static OrderItemEntity fromDomain(OrderItem item, OrderEntity order) {
        OrderItemEntity entity = new OrderItemEntity();
        entity.setOrder(order);
        entity.setProductId(item.getProductId());
        entity.setName(item.getTitle());
        entity.setPrice(item.getPrice());
        entity.setQuantity(item.getQuantity());
        return entity;
    }

    public OrderItem toOrderItem() {
        return OrderItem.builder()
            .id(this.id)
            .productId(this.productId)
            .title(this.name)
            .price(this.price)
            .quantity(this.quantity)
            .build();
    }
}
