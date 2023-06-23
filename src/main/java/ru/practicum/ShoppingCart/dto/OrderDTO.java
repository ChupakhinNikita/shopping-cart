package ru.practicum.ShoppingCart.dto;

import java.util.Date;

@lombok.Data
public class OrderDTO {
    private Long id;
    private Date orderDate;
    private String orderStatus;
    private String paymentMethod;
    private Long customerId;
}