package ru.practicum.ShoppingCart.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ShoppingCart.dto.OrderDetailDTO;
import ru.practicum.ShoppingCart.model.OrderDetail;
import ru.practicum.ShoppingCart.service.OrderDetailService;

import java.util.List;

@RestController
@RequestMapping("/api/order-details")
@RequiredArgsConstructor
public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    @PostMapping
    public ResponseEntity<OrderDetail> addOrderDetail(@RequestBody OrderDetail orderDetail) {
        OrderDetail addedOrderDetail = orderDetailService.addOrderDetail(orderDetail);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedOrderDetail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderDetail(@PathVariable Long id) {
        orderDetailService.deleteOrderDetail(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{orderId}/details")
    public List<OrderDetail> getOrderDetailsByOrderId(@PathVariable Long orderId) {
        List<OrderDetail> orders = orderDetailService.getOrderDetailsByOrderId(orderId);
        return orders;
    }

}