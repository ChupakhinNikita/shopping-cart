package ru.practicum.ShoppingCart.service;

import ru.practicum.ShoppingCart.model.Order;
import ru.practicum.ShoppingCart.model.enums.OrderStatus;

public interface OrderService {

    // - для orders – cоздать заказ
    Order createOrder(Order order);

    // - для orders – удалить заказ
    void deleteOrder(Long orderId);

    // - для orders – поменять статус заказа
    Order changeOrderStatus(Long orderId, OrderStatus newStatus);

    // - для orders – отобразить заказ по id
    Order getOrderById(Long orderId);
}
