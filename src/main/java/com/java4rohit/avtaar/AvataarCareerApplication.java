package com.java4rohit.avtaar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AvataarCareerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvataarCareerApplication.class, args);
	}

}
