package com.antonspring.ordering_system.controller;

import com.antonspring.ordering_system.dto.OrderDto;
import com.antonspring.ordering_system.entity.OrderAction;
import com.antonspring.ordering_system.entity.OrderHistory;
import com.antonspring.ordering_system.repository.OrderHistoryRepository;
import com.antonspring.ordering_system.service.OrderMessageSender;
import com.antonspring.ordering_system.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

    @Autowired
    private OrderService orderService;
    private final OrderMessageSender orderMessageSender;
    private final OrderHistoryRepository orderHistoryRepository;



    // Build add order RESTAPI
    @PostMapping
    public ResponseEntity<OrderDto> addOrder(@RequestBody OrderDto orderDto) {
        OrderDto savedOrder = orderService.addOrder(orderDto);

        // Skicka order som meddelande till ActiveMQ
        orderMessageSender.sendOrderMessage(savedOrder.toString());
        // Varje gång jag skapar en ny order, ett orderHistory skickas till MongoDB.
        OrderHistory orderHistory = new OrderHistory(
                null,
                savedOrder.getId(),
                OrderAction.CREATED,
                LocalDateTime.now(),
                "Order created successfully."
        );
        orderHistoryRepository.insert(orderHistory);

        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    // Build getOrder RESTAPI
    @GetMapping("{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable("id") Long Id) {
        OrderDto orderDto = orderService.getOrderById(Id);
        return ResponseEntity.ok(orderDto);
    }

    // Build Get all orders REST
    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    // Build updated order REST
    @PutMapping("{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable("id") Long orderId,
                                                @RequestBody OrderDto updatedOrder) {
        OrderDto orderDto = orderService.updateOrder(orderId, updatedOrder);

        OrderHistory orderHistory = new OrderHistory(
                null,
                updatedOrder.getId(),
                OrderAction.UPDATED,
                LocalDateTime.now(),
                "Order updated successfully."
        );
        orderHistoryRepository.insert(orderHistory);
        return ResponseEntity.ok(orderDto);
    }


    // Delete Order REST
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok("Order deleted");
    }
}

