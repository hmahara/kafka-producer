package eu.iamhelmi.microproducer.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ConditionalOnProperty("kafka.enabled")
@Component
public class SearchEngineKafkaMessageProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value(value = "${kafka.topic.search-engine.name}")
    private String searchEngineTopicName;
    
    @Value(value = "${kafka.topic.useraccount-update.name}")
    private String userAccountUpdateTopicName;
    
    @Value(value = "${kafka.topic.useraccount-delete.name}")
    private String userAccountDeleteTopicName;

    public void sendMessageSearchEngine(String message) {
    	log.info("Sending message to Kafka with topic name {} and message content {}", searchEngineTopicName,  message);
    	kafkaTemplate.send(searchEngineTopicName, message);
    }
    
    

}
