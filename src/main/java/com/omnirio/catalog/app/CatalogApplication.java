package com.omnirio.catalog.app;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;

@Configuration
@ComponentScan("com.omnirio.catalog.app.*")
@Slf4j
@SpringBootApplication
public class CatalogApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CatalogApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		log.info("Omnirio Catalog App started...");
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
