package com.moshiur457.tutorial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TutorialApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(TutorialApplication.class) ;
	public static void main(String[] args) {
		LOGGER.info("===========================");
		LOGGER.info("|   Application starts     |");
		LOGGER.info("============================");
		SpringApplication.run(TutorialApplication.class, args);
	}

}
