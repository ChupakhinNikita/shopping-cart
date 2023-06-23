package ru.practicum.ShoppingCart.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

// Товар
@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal price;
    private String description;
    private boolean inStock;
}