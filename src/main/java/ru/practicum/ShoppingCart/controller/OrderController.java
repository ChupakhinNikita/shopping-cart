package ru.practicum.ShoppingCart.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ShoppingCart.model.Order;
import ru.practicum.ShoppingCart.model.enums.OrderStatus;
import ru.practicum.ShoppingCart.service.OrderService;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@Api(tags = "Order Rest Controller")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ApiOperation(value = "Создать заказ", notes = "Создание заказа")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удалить заказ", notes = "Удаление определенного заказа")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/status")
    @ApiOperation(value = "Поменять статус заказа", notes = "Получение всех товаров, у которых поле InStock = true")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long id, @RequestParam("status") String status) {
        OrderStatus orderStatus = OrderStatus.valueOf(status.toUpperCase());
        Order updatedOrder = orderService.changeOrderStatus(id, orderStatus);
        return ResponseEntity.ok(updatedOrder);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Отобразить заказ по id", notes = "Отображение заказа по его id")
    public Order getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        return order;
    }
}
