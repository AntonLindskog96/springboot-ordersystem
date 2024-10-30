package com.antonspring.ordering_system.service;

import com.antonspring.ordering_system.dto.CustomerDto;
import com.antonspring.ordering_system.dto.OrderDto;

import java.util.List;

public interface CustomerService {
    CustomerDto addCustomer(CustomerDto customer);
    List<CustomerDto> getAllCustomers();
}
