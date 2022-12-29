package eu.iamhelmi.microproducer.service;

import org.springframework.stereotype.Service;

import eu.iamhelmi.microproducer.configuration.KafkaUserAccountMessageProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserAccountMessageService {

	private final KafkaUserAccountMessageProducer userAccountMessageProducer;
	
	public void sendMessageUserAccountCreate(String serAccountString) {
		userAccountMessageProducer.sendMessageCreateUserAccount(serAccountString);
	}
	
	public void sendMessageUserAccountUpdate(String serAccountString) {
		userAccountMessageProducer.sendMessageUpdateUserAccount(serAccountString);
	}
	
	public void sendMessageUserAccountDelete(String serAccountString) {
		userAccountMessageProducer.sendMessageDeleteUserAccount(serAccountString);
	}
	
}
