package com.antonspring.ordering_system;

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

	@Bean
	CommandLineRunner runner(OrderHistoryRepository repository) {
		return args -> {
			OrderHistory orderHistory = new OrderHistory(
					"1",
					"created",
					LocalDateTime.now(),
					"Order created successfully."
			);

		repository.insert(orderHistory);
		};
	}

}
