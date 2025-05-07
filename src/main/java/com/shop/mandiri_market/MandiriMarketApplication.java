package com.shop.mandiri_market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan(basePackages = "com.shop.mandiri_market.entity")
@EnableJpaRepositories(basePackages = "com.shop.mandiri_market.repository")
public class MandiriMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(MandiriMarketApplication.class, args);
	}

}
