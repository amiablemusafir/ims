package com.apsposting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.apsposting.repository") 
@EntityScan("com.apsposting.entity")
@SpringBootApplication
public class ApspostingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApspostingApplication.class, args);
	}
}
