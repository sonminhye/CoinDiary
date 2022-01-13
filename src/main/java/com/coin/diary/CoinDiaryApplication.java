package com.coin.diary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CoinDiaryApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CoinDiaryApplication.class, args);
	}
}
