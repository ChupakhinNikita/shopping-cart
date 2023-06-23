package ru.practicum.ShoppingCart.dto;

import java.math.BigDecimal;

@lombok.Data
public class OrderDetailDTO {
    private Long id;
    private Long orderId;
    private Long productId;
    private BigDecimal price;
    private int quantity;
}