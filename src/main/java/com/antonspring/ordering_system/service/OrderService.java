package com.antonspring.ordering_system.service;

import com.antonspring.ordering_system.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto addOrder(OrderDto order);

    OrderDto getOrderById(Long id);

    List<OrderDto> getAllOrders();

    OrderDto updateOrder(Long orderId, OrderDto updatedOrder);

    void deleteOrder(Long orderId);
}
