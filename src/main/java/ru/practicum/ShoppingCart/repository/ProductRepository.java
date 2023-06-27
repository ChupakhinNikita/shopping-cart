package ru.practicum.ShoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.practicum.ShoppingCart.model.Product;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Специфические методы для работы с сущностью Product
    List<Product> findByInStockTrue(); // Поиск достпуных товаров
}
