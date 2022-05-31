package com.store_locator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StoreLocatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreLocatorApplication.class, args);
	}

}
