package ru.practicum.ShoppingCart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.ShoppingCart.model.Product;
import ru.practicum.ShoppingCart.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProductsInStock() {
        List<Product> availableProducts = productRepository.findByInStockTrue();
        return availableProducts;
    }
}