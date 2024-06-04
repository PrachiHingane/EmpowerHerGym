package com.symbiosis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"com.controller","com.dao","com.model","com.service","com.symboisis"})	
@EntityScan("com.model")
@EnableJpaRepositories(basePackages="com.dao")
@SpringBootApplication
public class ProjectGymManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectGymManageApplication.class, args);
	}

}
