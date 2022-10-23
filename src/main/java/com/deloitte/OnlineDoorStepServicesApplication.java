package com.deloitte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.deloitte.utils.CommonConstants;

/**
 * @author jaimahaprabhua
 *
 */
@SpringBootApplication
@EnableMongoRepositories
public class OnlineDoorStepServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineDoorStepServicesApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/").allowedOrigins(CommonConstants.SERVER_ADDRESS);
			}
		};
	}

}
