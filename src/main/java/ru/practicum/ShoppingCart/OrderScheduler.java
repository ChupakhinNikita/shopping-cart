package ru.practicum.ShoppingCart;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.practicum.ShoppingCart.model.Order;
import ru.practicum.ShoppingCart.model.OrderDetail;
import ru.practicum.ShoppingCart.repository.OrderDetailRepository;
import ru.practicum.ShoppingCart.service.OrderDetailService;
import ru.practicum.ShoppingCart.service.OrderService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderScheduler {

    private final OrderService orderService;

    private final OrderDetailRepository orderDetailRepository;

    @Value("${threshold.amount}")
    private BigDecimal thresholdAmount;

    @Scheduled(cron = "${scheduler.cronExpression}")
    public void processOrders() {
        LocalDate currentDate = LocalDate.now();
        LocalDate previousDate = currentDate.minusDays(1);

        List<Order> orders = orderService.getOrdersByDateRange(previousDate, currentDate);
        BigDecimal totalAmount = calculateTotalAmount(orders);

        if (totalAmount.compareTo(thresholdAmount) > 0) {
            log.info("Произведенные заказы за последний день: ");
            for (Order order : orders) {
                log.info(order.toString());
            }
            log.info("Общая сумма: {}", totalAmount);
        } else {
            log.info("Нет заказов, содержащих общую сумму, превышающую заданную сумму.");
        }
    }

    private BigDecimal calculateTotalAmount(List<Order> orders) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (Order order : orders) {
            List<OrderDetail> orderDetails = orderDetailRepository.findByOrderId(order.getId());
            for (OrderDetail orderDetail : orderDetails) {
                BigDecimal price = orderDetail.getPrice();
                totalAmount = totalAmount.add(price);
            }
        }
        return totalAmount;
    }
}
