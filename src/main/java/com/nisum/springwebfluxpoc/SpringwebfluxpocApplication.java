package com.nisum.springwebfluxpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class SpringwebfluxpocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringwebfluxpocApplication.class, args);
	}
}
