package eu.iamhelmi.microproducer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.iamhelmi.microproducer.dto.UserAccount;
import eu.iamhelmi.microproducer.service.ElasticSearchMessageService;
import eu.iamhelmi.microproducer.service.UserAccountMessageService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/user")
public class UserAccountController {
	private ObjectMapper objectMapper;
	
	@Autowired
	UserAccountMessageService userAccountMessageService;
	
	@Autowired
	ElasticSearchMessageService searchEngineService;

	@PostMapping("/add")
	public String addUserAccount(@RequestBody UserAccount userAccount) {
		log.info("Adding user account");
		objectMapper = new ObjectMapper();
		try {
			String userAccountMessage = objectMapper.writeValueAsString(userAccount);
			userAccountMessageService.sendMessageUserAccountCreate(userAccountMessage);
			searchEngineService.sendMessageSearchEngine(userAccountMessage);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		}
		return "OK";

	}
	
	@PostMapping("/update")
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
	
	@PostMapping("/delete")
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
