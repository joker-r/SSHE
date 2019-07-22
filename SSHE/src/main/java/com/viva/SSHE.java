package com.viva;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.viva.service.ImsiService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

@SpringBootApplication
public class SSHE extends SpringBootServletInitializer implements ApplicationRunner{
	
	
	private static final Logger logger = LogManager.getLogger(SSHE.class);
	public static void main(String[] args) {
		
		SpringApplication.run(SSHE.class, args);
		
	}

	public void run(ApplicationArguments applicationArguments) throws Exception {
		
        logger.debug("Debugging log");
        logger.info("Info log");
        logger.warn("Hey, This is a warning!");
        logger.error("Oops! We have an Error. OK");
        logger.fatal("Damn! Fatal error. Please fix me.");
    }
}
