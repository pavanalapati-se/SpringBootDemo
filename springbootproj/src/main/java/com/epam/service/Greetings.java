package com.epam.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Greetings {

	
	private static Logger logger = LoggerFactory.getLogger(Greetings.class);
	
	@Value("${greetings.message:Have a Nice Day!}")
	private String message;
	
	public void greet() {
		logger.debug("Debug message");
		logger.info(message);
	}
}
