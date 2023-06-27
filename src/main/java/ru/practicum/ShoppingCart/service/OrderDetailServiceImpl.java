package ru.practicum.ShoppingCart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.ShoppingCart.dto.OrderDetailDTO;
import ru.practicum.ShoppingCart.model.OrderDetail;
import ru.practicum.ShoppingCart.repository.OrderDetailRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;

    // - для orderDetail – добавить позицию
    public OrderDetail addOrderDetail(OrderDetail orderDetail) {
        // Преобразование OrderDetailDTO в OrderDetail с использованием маппера
        //OrderDetail orderDetail = orderDetailMapper.toEntity(orderDetailDTO);

        // Сохранение детали заказа в базе данных
        OrderDetail savedOrderDetail = orderDetailRepository.save(orderDetail);

        // Преобразование сохраненной детали заказа в OrderDetailDTO с использованием маппера
        //OrderDetailDTO savedOrderDetailDTO = orderDetailMapper.toDTO(savedOrderDetail);

        return orderDetail;
    }

    // - для orderDetail – удалить позицию
    public void deleteOrderDetail(Long orderDetailId) {
        // Проверка существования детали заказа по ее идентификатору
        if (!orderDetailRepository.existsById(orderDetailId)) {
            throw new EntityNotFoundException("Order detail not found");
        }

        // Удаление детали заказа из базы данных
        orderDetailRepository.deleteById(orderDetailId);
    }

    // - для orderDetail – отобразить все позиции по order_id
    public List<OrderDetail> getOrderDetailsByOrderId(Long orderId) {
        // Получение деталей заказа по идентификатору заказа
        List<OrderDetail> orderDetails = orderDetailRepository.findByOrderId(orderId);

        // Преобразование деталей заказа в список OrderDetailDTO с использованием маппера
        // List<OrderDetail> orderDetailDTOs = orderDetailMapper.toDTOs(orderDetails);

        return orderDetails;
    }
}