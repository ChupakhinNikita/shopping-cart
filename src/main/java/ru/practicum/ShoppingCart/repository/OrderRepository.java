package ru.practicum.ShoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.ShoppingCart.model.Order;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Специфические методы для работы с сущностью Order
    List<Order> findByOrderDateBetween(Date startDate, Date endDate);
}
