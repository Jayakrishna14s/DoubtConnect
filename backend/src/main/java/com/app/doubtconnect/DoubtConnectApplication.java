package com.app.doubtconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class DoubtConnectApplication {

	@GetMapping("/public/test")
	public String test1() {
		return "Hello World";
	}

	@GetMapping("/api/test")
	public String test2() {
		return "Hello World";
	}

	public static void main(String[] args) {
		System.out.println("Hello world");
		SpringApplication.run(DoubtConnectApplication.class, args);
		System.out.print("Hello World");
	}

}
