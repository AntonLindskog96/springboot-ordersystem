package com.antonspring.ordering_system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private String orderName;
    private Integer quantity;
    private Double price;
    private Boolean status;
}
