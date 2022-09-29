package com.company.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class NewsTrackerApplication implements WebMvcConfigurer {

	private static final Logger logger = LoggerFactory.getLogger(NewsTrackerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(NewsTrackerApplication.class, args);

		logger.info("this is a info message");
		logger.warn("this is a warn message");
		logger.error("this is a error message");

	}
}