package com.antonspring.ordering_system.controller;

import com.antonspring.ordering_system.dto.OrderDto;
import com.antonspring.ordering_system.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderService orderService;

    // Build add order RESTAPI
    @PostMapping
    public ResponseEntity<OrderDto> addOrder(@RequestBody OrderDto orderDto) {
        OrderDto savedOrder = orderService.addOrder(orderDto);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

}
