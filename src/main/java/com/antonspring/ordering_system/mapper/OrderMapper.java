package com.antonspring.ordering_system.mapper;

import com.antonspring.ordering_system.dto.OrderDto;
import com.antonspring.ordering_system.entity.Order;

public class OrderMapper {

    // Converts Order to an OrderDto
    public static OrderDto mapToOrderDto(Order order) {
        // creates new OrderDto with fields from the Order
        return new OrderDto(
                order.getId(),
                order.getOrderName(),
                order.getQuantity(),
                order.getPrice(),
                order.getStatus()

        );
    }
    // Converts an OrderDto to an Order
    public static Order mapToOrder(OrderDto orderDto) {
        // creates an Order using data from OrderDto
        return new Order(
                orderDto.getId(),
                orderDto.getOrderName(),
                orderDto.getQuantity(),
                orderDto.getPrice(),
                orderDto.getStatus()
        );
    }
}
