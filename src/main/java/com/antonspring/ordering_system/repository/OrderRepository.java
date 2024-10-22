package com.antonspring.ordering_system.repository;

import com.antonspring.ordering_system.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order, Long> {

}
