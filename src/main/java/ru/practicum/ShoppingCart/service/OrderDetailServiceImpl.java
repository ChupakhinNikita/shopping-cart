package ru.practicum.ShoppingCart.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.ShoppingCart.dto.OrderDetailDTO;
import ru.practicum.ShoppingCart.model.Customer;
import ru.practicum.ShoppingCart.model.Order;
import ru.practicum.ShoppingCart.model.OrderDetail;
import ru.practicum.ShoppingCart.model.Product;
import ru.practicum.ShoppingCart.repository.CustomerRepository;
import ru.practicum.ShoppingCart.repository.OrderDetailRepository;
import ru.practicum.ShoppingCart.repository.OrderRepository;
import ru.practicum.ShoppingCart.repository.ProductRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;

    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;

    // - для orderDetail – добавить позицию
    public OrderDetail addOrderDetail(OrderDetail orderDetail) {
        // Преобразование OrderDetailDTO в OrderDetail с использованием маппера
        //OrderDetail orderDetail = orderDetailMapper.toEntity(orderDetailDTO);

        log.info("Добавление позиции в заказ");

        // Получение заказа по его идентификатору
        Order order = orderRepository.findById(orderDetail.getOrder().getId())
                .orElseThrow(() -> new EntityNotFoundException("Заказ не найден"));

        Product product = productRepository.findById(orderDetail.getProduct().getId())
                .orElseThrow(() -> new EntityNotFoundException("Продукт не найден"));

        // Установка связи
        orderDetail.setOrder(order);
        orderDetail.setProduct(product);

        // Сохранение детали заказа в базе данных
        OrderDetail savedOrderDetail = orderDetailRepository.save(orderDetail);
        log.info("Сохранение позиции в базе данных");

        // Преобразование сохраненной детали заказа в OrderDetailDTO с использованием маппера
        //OrderDetailDTO savedOrderDetailDTO = orderDetailMapper.toDTO(savedOrderDetail);

        log.info("Позиция добавлена успешно");

        return orderDetail;
    }

    // - для orderDetail – удалить позицию
    public void deleteOrderDetail(Long orderDetailId) {
        log.info("Удаление позиции заказа");
        // Проверка существования детали заказа по ее идентификатору
        if (!orderDetailRepository.existsById(orderDetailId)) {
            throw new EntityNotFoundException("Позиция не найдена");
        }

        // Удаление детали заказа из базы данных
        orderDetailRepository.deleteById(orderDetailId);
        log.info("Позиция успешно удалена");
    }

    // - для orderDetail – отобразить все позиции по order_id
    public List<OrderDetail> getOrderDetailsByOrderId(Long orderId) {
        log.info("Получение всех позиций по идентификатору заказа");
        List<OrderDetail> orderDetails = orderDetailRepository.findByOrderId(orderId);
        log.info("Позиции получены");

        // Преобразование деталей заказа в список OrderDetailDTO с использованием маппера
        // List<OrderDetail> orderDetailDTOs = orderDetailMapper.toDTOs(orderDetails);

        return orderDetails;
    }
}