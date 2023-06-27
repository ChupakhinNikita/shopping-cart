package ru.practicum.ShoppingCart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.ShoppingCart.model.Customer;
import ru.practicum.ShoppingCart.model.Order;
import ru.practicum.ShoppingCart.model.enums.OrderStatus;
import ru.practicum.ShoppingCart.repository.CustomerRepository;
import ru.practicum.ShoppingCart.repository.OrderRepository;

import javax.persistence.EntityNotFoundException;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    // - для orders – создать заказ
    public Order createOrder(Order order) {
        // Преобразование OrderDTO в Order с использованием маппера

        // Получение покупателя по его идентификатору
        Customer customer = customerRepository.findById(order.getId())
                .orElseThrow(() -> new EntityNotFoundException("Клиент не найден"));

        // Установка связи между заказом и покупателем
        order.setCustomer(customer);

        // Сохранение заказа в базе данных
        Order savedOrder = orderRepository.save(order);

        // Преобразование сохраненного заказа в OrderDTO с использованием маппера

        return order;
    }

    // - для orders – удалить заказ
    public void deleteOrder(Long orderId) {
        // Проверка существования заказа по его идентификатору
        if (!orderRepository.existsById(orderId)) {
            throw new EntityNotFoundException("Заказ не найден");
        }

        // Удаление заказа из базы данных
        orderRepository.deleteById(orderId);
    }

    // - для orders – поменять статус заказа
    public Order changeOrderStatus(Long orderId, OrderStatus newStatus) {
        // Получение заказа по его идентификатору
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Заказ не найден"));

        // Изменение статуса заказа
        order.setOrderStatus(newStatus);

        // Сохранение изменений в базе данных
        Order updatedOrder = orderRepository.save(order);

        // Преобразование обновленного заказа в OrderDTO с использованием маппера

        return updatedOrder;
    }

    // - для orders – отобразить заказ по id
    public Order getOrderById(Long orderId) {
        // Получение заказа по его идентификатору
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Заказ не найден"));

        // Преобразование заказа в OrderDTO с использованием маппера

        return order;
    }
}