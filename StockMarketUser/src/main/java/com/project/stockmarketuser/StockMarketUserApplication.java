package com.project.stockmarketuser;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class StockMarketUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockMarketUserApplication.class, args);
	}

}
