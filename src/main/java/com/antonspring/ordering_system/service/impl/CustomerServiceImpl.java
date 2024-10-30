package com.antonspring.ordering_system.service.impl;

import com.antonspring.ordering_system.dto.CustomerDto;
import com.antonspring.ordering_system.dto.OrderDto;
import com.antonspring.ordering_system.entity.Customer;
import com.antonspring.ordering_system.entity.Order;
import com.antonspring.ordering_system.mapper.CustomerMapper;
import com.antonspring.ordering_system.mapper.OrderMapper;
import com.antonspring.ordering_system.repository.CustomerRepository;
import com.antonspring.ordering_system.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;


    @Override
    public CustomerDto addCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto);
        Customer savedCustomer = customerRepository.save(customer);



        return CustomerMapper.mapToCustomerDto(savedCustomer);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map((customer) -> CustomerMapper.mapToCustomerDto(customer))
                .collect(Collectors.toList());
    }
}
