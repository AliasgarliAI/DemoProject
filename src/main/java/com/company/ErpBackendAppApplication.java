package com.company;

import com.company.model.User;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class ErpBackendAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ErpBackendAppApplication.class, args);
	}
	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user = new User(0L,"Alakbar","Aliasgarli","AliasgarliAI","994553504857","eelesgerli98@gmail.com","123456",
				"test/",true,true, LocalDateTime.now(), LocalDateTime.now(),LocalDateTime.now());
		userRepository.insert(user);
	}
}
