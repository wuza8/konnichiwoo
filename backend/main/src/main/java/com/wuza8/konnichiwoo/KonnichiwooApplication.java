package com.wuza8.konnichiwoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class KonnichiwooApplication {

	public static void main(String[] args) {
		SpringApplication.run(KonnichiwooApplication.class, args);
	}

}
