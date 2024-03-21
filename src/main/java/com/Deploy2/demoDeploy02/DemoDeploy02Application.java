package com.Deploy2.demoDeploy02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@SpringBootApplication
public class DemoDeploy02Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoDeploy02Application.class, args);
	}


	@RestController
	class RandomSumController {

		@GetMapping("/sum")
		public int getSum() {
			Random random = new Random();
			int num1 = random.nextInt(100);
			int num2 = random.nextInt(100);
			return num1 + num2;
		}
	}

	@Profile("prod")
	@RestController
	class ProdProfileController {

		@GetMapping("/profile")
		public String getProfile() {
			return "Active Profile: prod";
		}
	}

	@Profile("test")
	@RestController
	class TestProfileController {

		@GetMapping("/profile")
		public String getProfile() {
			return "Active Profile: test";
		}
	}
}
