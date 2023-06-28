package ru.practicum.ShoppingCart.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ShoppingCart.dto.ProductDTO;
import ru.practicum.ShoppingCart.mapper.ProductMapper;
import ru.practicum.ShoppingCart.model.Product;
import ru.practicum.ShoppingCart.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Api(tags = "Product Rest Controller")
@Slf4j
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    @ApiOperation(value = "Получение всех доступных товаров", notes = "Возможность вывести все товары, которые есть в наличие")
    public List<ProductDTO> getAllProducts() {
        log.info("Запрос на получение всех доступных товаров");
        List<Product> resultProducts = productService.getAllProductsInStock();
        log.info("Получено {} товаров", resultProducts.size());
        return ProductMapper.INSTANCE.toDTOs(resultProducts);
    }
}