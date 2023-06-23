package ru.practicum.ShoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.ShoppingCart.model.OrderDetail;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    // Специфические методы для работы с сущностью Order
}