package com.antonspring.ordering_system.service;

import com.antonspring.ordering_system.dto.CustomerDto;

public interface CustomerService {
    CustomerDto addCustomer(CustomerDto customer);
}
