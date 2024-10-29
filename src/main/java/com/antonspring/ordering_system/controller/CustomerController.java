package com.antonspring.ordering_system.controller;

import com.antonspring.ordering_system.dto.CustomerDto;
import com.antonspring.ordering_system.repository.CustomerRepository;
import com.antonspring.ordering_system.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private CustomerService customerService;
    private final CustomerRepository customerRepository;

    @PostMapping
    public ResponseEntity<CustomerDto> addCustomer (@RequestBody CustomerDto customerDto) {
        CustomerDto savedCustomer = customerService.addCustomer(customerDto);

        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }
}
