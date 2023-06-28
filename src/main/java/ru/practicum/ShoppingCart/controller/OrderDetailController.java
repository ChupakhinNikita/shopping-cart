package ru.practicum.ShoppingCart.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ShoppingCart.dto.OrderDetailDTO;
import ru.practicum.ShoppingCart.mapper.OrderDetailMapper;
import ru.practicum.ShoppingCart.mapper.OrderMapper;
import ru.practicum.ShoppingCart.model.OrderDetail;
import ru.practicum.ShoppingCart.service.OrderDetailService;

import java.util.List;

@RestController
@RequestMapping("/api/order-details")
@RequiredArgsConstructor
@Api(tags = "OrderDetail Rest Controller")
@Slf4j
public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    @PostMapping
    @ApiOperation(value = "Добавить позицию", notes = "Добавление подробной информации о заказе")
    public ResponseEntity<OrderDetailDTO> addOrderDetail(@RequestBody OrderDetailDTO orderDetailDTO) {
        log.info("Запрос на добавление позиции: {}", orderDetailDTO);
        OrderDetail addedOrderDetail = orderDetailService.addOrderDetail(OrderDetailMapper.INSTANCE.toEntity(orderDetailDTO));
        log.info("Позиция успешно добавлена: {}", addedOrderDetail);
        return ResponseEntity.status(HttpStatus.CREATED).body(OrderDetailMapper.INSTANCE.toDTO(addedOrderDetail));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удалить позицию", notes = "Удаление определенного заказа")
    public ResponseEntity<Void> deleteOrderDetail(@PathVariable Long id) {
        log.info("Запрос на удаление позиции с id: {}", id);
        orderDetailService.deleteOrderDetail(id);
        log.info("Позиция с id {} успешно удалена", id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{orderId}/details")
    @ApiOperation(value = "Отобразить все позиции по order_id", notes = "Получение подробной информации определенного заказа")
    public List<OrderDetailDTO> getOrderDetailsByOrderId(@PathVariable Long orderId) {
        log.info("Запрос на получение всех позиций для заказа с id: {}", orderId);
        List<OrderDetail> orders = orderDetailService.getOrderDetailsByOrderId(orderId);
        log.info("Получено {} позиций для заказа с id {}", orders.size(), orderId);
        return OrderDetailMapper.INSTANCE.toDTOs(orders);
    }

}