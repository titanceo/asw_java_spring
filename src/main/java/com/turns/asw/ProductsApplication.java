package com.turns.asw;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ProductsApplication {
	
	 @PostConstruct
     void started() {
       TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
     }
	 
	public static void main(String[] args) {
		SpringApplication.run(ProductsApplication.class, args);
	}
	

}
