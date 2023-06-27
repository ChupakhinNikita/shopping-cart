package ru.practicum.ShoppingCart.service;

import ru.practicum.ShoppingCart.dto.OrderDetailDTO;
import ru.practicum.ShoppingCart.model.OrderDetail;

import java.util.List;

public interface OrderDetailService {

    OrderDetail addOrderDetail(OrderDetail orderDetail);

    void deleteOrderDetail(Long orderDetailId);

    List<OrderDetail> getOrderDetailsByOrderId(Long orderId);
}
