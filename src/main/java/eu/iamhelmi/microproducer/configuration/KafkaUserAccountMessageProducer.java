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
public class KafkaUserAccountMessageProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value(value = "${kafka.topic.useraccount-create.name}")
    private String userAccountCreateTopicName;
    
    @Value(value = "${kafka.topic.useraccount-update.name}")
    private String userAccountUpdateTopicName;
    
    @Value(value = "${kafka.topic.useraccount-delete.name}")
    private String userAccountDeleteTopicName;

    public void sendMessageCreateUserAccount(String message) {
    	log.info("Sending message to Kafka with topic name {} and message content {}", userAccountCreateTopicName,  message);
    	kafkaTemplate.send(userAccountCreateTopicName, message);
    }
    
    public void sendMessageUpdateUserAccount(String message) {
    	log.info("Sending message to Kafka with topic name {} and message content {}", userAccountCreateTopicName,  message);
    	kafkaTemplate.send(userAccountUpdateTopicName, message);
    }
    
    public void sendMessageDeleteUserAccount(String message) {
    	log.info("Sending message to Kafka with topic name {} and message content {}", userAccountCreateTopicName,  message);
    	kafkaTemplate.send(userAccountDeleteTopicName, message);
    }

}
