package com.antonspring.ordering_system.repository;

import com.antonspring.ordering_system.entity.OrderHistory;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface OrderHistoryRepository extends MongoRepository<OrderHistory, String> {

}
