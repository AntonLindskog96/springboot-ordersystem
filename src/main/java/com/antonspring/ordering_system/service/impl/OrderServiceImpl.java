package com.antonspring.ordering_system.service.impl;

import com.antonspring.ordering_system.dto.OrderDto;
import com.antonspring.ordering_system.entity.Order;
import com.antonspring.ordering_system.mapper.OrderMapper;
import com.antonspring.ordering_system.repository.OrderRepository;
import com.antonspring.ordering_system.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
