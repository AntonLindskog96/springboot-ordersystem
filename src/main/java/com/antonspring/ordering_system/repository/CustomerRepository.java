package com.antonspring.ordering_system.repository;

import com.antonspring.ordering_system.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
