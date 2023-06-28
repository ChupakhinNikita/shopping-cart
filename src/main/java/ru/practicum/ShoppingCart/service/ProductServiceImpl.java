package ru.practicum.ShoppingCart.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.ShoppingCart.model.Product;
import ru.practicum.ShoppingCart.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProductsInStock() {
        log.info("Получение всех доступных товаров в наличии");
        List<Product> availableProducts = productRepository.findByInStockTrue();
        log.info("Товары получены");
        return availableProducts;
    }
}