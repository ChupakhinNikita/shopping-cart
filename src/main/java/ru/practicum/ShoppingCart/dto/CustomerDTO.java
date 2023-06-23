package ru.practicum.ShoppingCart.dto;

@lombok.Data
public class CustomerDTO {
    private Long id;
    private String names;
    private String surname;
    private String address;
    private String email;
    private String phone;
}