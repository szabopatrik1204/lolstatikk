package com.patrik.lolstatikk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class LoLStatikkApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoLStatikkApplication.class, args);
	}

}
