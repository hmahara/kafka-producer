package eu.iamhelmi.microproducer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.iamhelmi.microproducer.dto.UserAccount;

@RestController
public class HelloController {
	private ObjectMapper objectMapper;

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		UserAccount ua = new UserAccount();
		ua.setLogin("alice");
		ua.setPin("1234");
		objectMapper = new ObjectMapper();

		try {
			return String.format("Hello %s! %s", name, objectMapper.writeValueAsString(ua));
		} catch (JsonProcessingException e) {

			return e.toString();
		}
	}
}
