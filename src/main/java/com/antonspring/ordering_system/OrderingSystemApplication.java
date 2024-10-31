package com.antonspring.ordering_system;

import com.antonspring.ordering_system.entity.OrderAction;
import com.antonspring.ordering_system.entity.OrderHistory;
import com.antonspring.ordering_system.repository.OrderHistoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class    OrderingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderingSystemApplication.class, args);
	}



}
