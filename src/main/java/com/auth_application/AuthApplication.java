package com.auth_application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class AuthApplication  implements CommandLineRunner {


	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting AuthApplication using Java " + System.getProperty("java.version") + " with PID " + ProcessHandle.current().pid() + " (/home/juan/projects/java/auth_application/build/classes/java/main started by juan in /home/juan/projects/java/auth_application)");
		log.info("Starting AuthApplication using Java " + System.getProperty("java.version") + " with PID " + ProcessHandle.current().pid() + " (/home/juan/projects/java/auth_application/build/classes/java/main started by juan in /home/juan/projects/java/auth_application)");
	}

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

}
