package ru.practicum.ShoppingCart.service;

import ru.practicum.ShoppingCart.model.Product;

import java.util.List;

public interface ProductService {

    // Возможность вывести все товары, которые есть в наличие
    List<Product> getAllProductsInStock();
}
