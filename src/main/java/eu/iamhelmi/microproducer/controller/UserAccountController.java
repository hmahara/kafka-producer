package eu.iamhelmi.microproducer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import eu.iamhelmi.microproducer.dto.UserAccount;
import eu.iamhelmi.microproducer.service.UserAccountMessageService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserAccountController {
	private ObjectMapper objectMapper;
	
	@Autowired
	UserAccountMessageService userAccountMessageService;

	@PostMapping("/add-user")
	public String addUserAccount(@RequestBody UserAccount userAccount) {
		log.info("Adding user account");
		objectMapper = new ObjectMapper();
		try {
			String userAccountMessage = objectMapper.writeValueAsString(userAccount);
			userAccountMessageService.sendMessageUserAccountCreate(userAccountMessage);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		}
		return "OK";

	}
	
	@PostMapping("/update-user")
	public String updateUserAccount(@RequestBody UserAccount userAccount) {
		log.info("Updating user account");
		objectMapper = new ObjectMapper();
		try {
			String userAccountMessage = objectMapper.writeValueAsString(userAccount);
			userAccountMessageService.sendMessageUserAccountUpdate(userAccountMessage);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		}
		return "OK";

	}
	
	@PostMapping("/delete-user")
	public String deleteUserAccount(@RequestBody UserAccount userAccount) {
		log.info("Updating user account");
		objectMapper = new ObjectMapper();
		try {
			String userAccountMessage = objectMapper.writeValueAsString(userAccount);
			userAccountMessageService.sendMessageUserAccountDelete(userAccountMessage);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		}
		return "OK";

	}
}
