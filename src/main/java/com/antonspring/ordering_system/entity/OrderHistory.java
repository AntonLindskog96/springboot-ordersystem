package com.antonspring.ordering_system.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class OrderHistory {
    @Id
    private String id;
    private String action; // created, updated,deleted
    private LocalDateTime timestamp;
    private String details;


    public OrderHistory(String id, String action, LocalDateTime timestamp, String details) {
        this.id = id;
        this.action = action;
        this.timestamp = timestamp;
        this.details = details;
    }
}
