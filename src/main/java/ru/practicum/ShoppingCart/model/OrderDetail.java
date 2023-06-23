package ru.practicum.ShoppingCart.model;

import lombok.Data;

import javax.persistence.*;

import java.math.BigDecimal;

// Подробная информация о заказе
@Data
@Entity
@Table(name = "orderDetail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private BigDecimal price;
    private int quantity;
}