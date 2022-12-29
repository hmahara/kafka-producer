package eu.iamhelmi.microproducer.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@ConditionalOnProperty("kafka.enabled")
@Configuration
public class KafkaUserAccountProducerConfig {

    @Value(value = "${spring.kafka.producer.bootstrap-servers}")
    private String bootstrapAddress;

    @Value(value = "${kafka.topic.useraccount-create.name}")
    private String userAccountCreateTopicName;
    
    @Value(value = "${kafka.topic.useraccount-update.name}")
    private String userAccountUpdateTopicName;
    
    @Value(value = "${kafka.topic.useraccount-delete.name}")
    private String userAccountDeleteTopicName;


    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic userAccountCreateTopic() {
        return new NewTopic(userAccountCreateTopicName, 2, (short) 2);
    }
    
    @Bean
    public NewTopic userAccountUpdateTopic() {
        return new NewTopic(userAccountUpdateTopicName, 2, (short) 2);
    }
    
    @Bean
    public NewTopic userAccountDeleteTopic() {
        return new NewTopic(userAccountDeleteTopicName, 2, (short) 2);
    }


}




