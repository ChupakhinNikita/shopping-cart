package ru.practicum.ShoppingCart.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ShoppingCart.model.Product;
import ru.practicum.ShoppingCart.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Api(tags = "Product Rest Controller")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @ApiOperation(value = "Получение всех доступных товаров", notes = "Возможность вывести все товары, которые есть в наличие")
    public List<Product> getAllProducts() {

        List<Product> resultProducts = productService.getAllProductsInStock();

        for(Product prod: resultProducts){
            System.out.println("\n" + prod.getName() + "\n");
        }

        return resultProducts;
    }
}