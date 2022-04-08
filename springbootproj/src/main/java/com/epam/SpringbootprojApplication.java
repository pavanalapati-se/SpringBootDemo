package com.epam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.epam.service.Greetings;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
//@Import(value = Config.class)
@OpenAPIDefinition(info = @Info(title = "Online Course Management System", version = "1.0", description = "Creation Online Courses"))
public class SpringbootprojApplication implements CommandLineRunner {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootprojApplication.class, args);

		context.getBean(Greetings.class).greet();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Run method executing .....................");

	}

}
