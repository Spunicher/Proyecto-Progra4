package com.alquiler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Alquilerprogramacion4Application implements CommandLineRunner{
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(Alquilerprogramacion4Application.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
String password="12345";
		
		for (int i = 1; i < 3; i++) {
			String bcrypt= passwordEncoder.encode(password);
			System.out.println(bcrypt);
		
		}
		
	}

}
