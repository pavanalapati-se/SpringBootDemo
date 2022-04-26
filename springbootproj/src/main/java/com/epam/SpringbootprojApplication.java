package com.epam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.epam.dao.AuthGroupRepository;
import com.epam.dao.UserRepository;
import com.epam.entity.AuthGroup;
import com.epam.entity.User;
import com.epam.service.Greetings;

@SpringBootApplication
//@Import(value = Config.class)
public class SpringbootprojApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AuthGroupRepository authGroupRepository;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootprojApplication.class, args);

		context.getBean(Greetings.class).greet();
	}

	@Override
	public void run(String... args) throws Exception {

		PasswordEncoder encoder = new BCryptPasswordEncoder(11);

		User user1 = new User();
		user1.setId(100);
		user1.setUsername("pavan");
		user1.setPassword(encoder.encode("password"));

		User user2 = new User();
		user2.setId(101);
		user2.setUsername("kumar");
		user2.setPassword(encoder.encode("password"));

		userRepo.save(user1);
		userRepo.save(user2);

		AuthGroup authGroup = new AuthGroup();
		authGroup.setUsername("pavan");
		authGroup.setAuthGroup("ADMIN");

		AuthGroup authGroup1 = new AuthGroup();
		authGroup1.setUsername("kumar");
		authGroup1.setAuthGroup("USER");

		authGroupRepository.save(authGroup);
		authGroupRepository.save(authGroup1);
	}

}
