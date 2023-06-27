package ru.practicum.ShoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.ShoppingCart.model.OrderDetail;

import org.springframework.stereotype.Repository;
import ru.practicum.ShoppingCart.model.Product;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    // Специфические методы для работы с сущностью Order
    List<OrderDetail> findByOrderId(Long orderId);
}