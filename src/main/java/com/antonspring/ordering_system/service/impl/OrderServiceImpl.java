package com.antonspring.ordering_system.service.impl;

import com.antonspring.ordering_system.dto.OrderDto;
import com.antonspring.ordering_system.entity.Order;
import com.antonspring.ordering_system.exception.ResourceNotFoundException;
import com.antonspring.ordering_system.mapper.OrderMapper;
import com.antonspring.ordering_system.repository.OrderRepository;
import com.antonspring.ordering_system.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {


    private OrderRepository orderRepository;

    @Override
    public OrderDto addOrder(OrderDto orderDto) {

        Order order = OrderMapper.mapToOrder(orderDto);
        Order savedOrder = orderRepository.save(order);


        return OrderMapper.mapToOrderDto(savedOrder);
    }

    @Override
    public OrderDto getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Order not found with Id : " + id));
        return OrderMapper.mapToOrderDto(order);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map((order) -> OrderMapper.mapToOrderDto(order))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto updateOrder(Long orderId, OrderDto updatedOrder) {

        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new ResourceNotFoundException("Order not found with Id : " + orderId)
        );

        order.setOrderName(updatedOrder.getOrderName());
        order.setPrice(updatedOrder.getPrice());
        order.setQuantity(updatedOrder.getQuantity());
        order.setStatus(updatedOrder.getStatus());
        Order updatedOrderObj = orderRepository.save(order);
        return OrderMapper.mapToOrderDto(updatedOrderObj);
    }

    @Override
    public void deleteOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new ResourceNotFoundException("Order not found with Id : " + orderId)
        );
        orderRepository.deleteById(orderId);
    }
}
