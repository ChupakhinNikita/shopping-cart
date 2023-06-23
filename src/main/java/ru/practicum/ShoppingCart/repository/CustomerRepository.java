package ru.practicum.ShoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.ShoppingCart.model.Customer;

import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Специфические методы для работы с сущностью Customer
}
