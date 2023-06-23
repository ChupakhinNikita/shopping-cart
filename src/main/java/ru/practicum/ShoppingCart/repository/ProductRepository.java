package ru.practicum.ShoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.ShoppingCart.model.Product;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Специфические методы для работы с сущностью Product
}
