package com.epam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import com.epam.service.Greetings;

@SpringBootApplication
//@Import(value = Config.class)
public class SpringbootprojApplication implements CommandLineRunner {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(SpringbootprojApplication.class, args);
		
		context.getBean(Greetings.class).greet();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Run method executing .....................");
		
	}
	
	

}
