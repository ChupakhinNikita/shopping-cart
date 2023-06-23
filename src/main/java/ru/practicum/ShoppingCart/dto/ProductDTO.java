package ru.practicum.ShoppingCart.dto;

import java.math.BigDecimal;

@lombok.Data
public class ProductDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private boolean inStock;
}