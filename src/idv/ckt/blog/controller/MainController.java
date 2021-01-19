package idv.ckt.blog.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class MainController {
	@RequestMapping("/")
	String basic() {
		return "welcome";
	}
	
	@RequestMapping("/test")
	String test() {
		return "hello world";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MainController.class, args);
	}
}
