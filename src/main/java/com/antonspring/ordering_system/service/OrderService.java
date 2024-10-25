package com.antonspring.ordering_system.service;

import com.antonspring.ordering_system.dto.OrderDto;

public interface OrderService {
    OrderDto addOrder(OrderDto order);
}
