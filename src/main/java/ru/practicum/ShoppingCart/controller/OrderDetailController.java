package ru.practicum.ShoppingCart.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "OrderDetail Rest Controller")
public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    @PostMapping
    @ApiOperation(value = "Добавить позицию", notes = "Добавление подробной информации о заказе")
    public ResponseEntity<OrderDetail> addOrderDetail(@RequestBody OrderDetail orderDetail) {
        OrderDetail addedOrderDetail = orderDetailService.addOrderDetail(orderDetail);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedOrderDetail);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удалить позицию", notes = "Удаление определенного заказа")
    public ResponseEntity<Void> deleteOrderDetail(@PathVariable Long id) {
        orderDetailService.deleteOrderDetail(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{orderId}/details")
    @ApiOperation(value = "Отобразить все позиции по order_id", notes = "Получение подробной информации определенного заказа")
    public List<OrderDetail> getOrderDetailsByOrderId(@PathVariable Long orderId) {
        List<OrderDetail> orders = orderDetailService.getOrderDetailsByOrderId(orderId);
        return orders;
    }

}