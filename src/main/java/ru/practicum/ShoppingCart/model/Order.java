package ru.practicum.ShoppingCart.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import javax.persistence.*;

import ru.practicum.ShoppingCart.model.enums.OrderStatus;
import ru.practicum.ShoppingCart.model.enums.PaymentMethod;

import java.util.Date;

// Заказ

@Data
@Entity
@Table(name = "orders")
@ApiModel(description = "Заказ")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus; // created, processing, cancelled, shipped
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod; // CREDIT_CARD, PAY_PAL, ON_RECEIPT

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}