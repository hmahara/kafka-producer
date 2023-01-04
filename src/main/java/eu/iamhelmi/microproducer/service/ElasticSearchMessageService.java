package eu.iamhelmi.microproducer.service;

import org.springframework.stereotype.Service;

import eu.iamhelmi.microproducer.configuration.SearchEngineKafkaMessageProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ElasticSearchMessageService {

	private final SearchEngineKafkaMessageProducer searchEngineMessageProducer;
	
	public void sendMessageSearchEngine(String message) {
		log.info("Sending message to message streamer with message {}", message);
		searchEngineMessageProducer.sendMessageSearchEngine(message);
	}
	
	
}
