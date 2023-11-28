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

    //@Value(value = "${spring.kafka.producer.bootstrap-servers}")
    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Value(value = "${kafka.topic.useraccount-create.name}")
    private String userAccountCreateTopicName;
    
    @Value(value = "${kafka.topic.useraccount-create.number-of-partition}")
    private int userAccountCreateNumberOfPartition;
    
    @Value(value = "${kafka.topic.useraccount-create.replication-factor}")
    private int userAccountCreateReplicationFactor;
    
    @Value(value = "${kafka.topic.useraccount-update.name}")
    private String userAccountUpdateTopicName;
    
    @Value(value = "${kafka.topic.useraccount-update.number-of-partition}")
    private int userAccountUpdateNumberOfPartition;
    
    @Value(value = "${kafka.topic.useraccount-update.replication-factor}")
    private int userAccountUpdateReplicationFactor;
    
    @Value(value = "${kafka.topic.useraccount-delete.name}")
    private String userAccountDeleteTopicName;
    
    @Value(value = "${kafka.topic.useraccount-delete.number-of-partition}")
    private int userAccountDeleteNumberOfPartition;
    
    @Value(value = "${kafka.topic.useraccount-delete.replication-factor}")
    private int userAccountDeleteReplicationFactor;


    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic userAccountCreateTopic() {
        return new NewTopic(userAccountCreateTopicName, userAccountCreateNumberOfPartition, (short) userAccountCreateReplicationFactor);
    }
    
    @Bean
    public NewTopic userAccountUpdateTopic() {
        return new NewTopic(userAccountUpdateTopicName, userAccountUpdateNumberOfPartition, (short) userAccountUpdateReplicationFactor);
    }
    
    @Bean
    public NewTopic userAccountDeleteTopic() {
        return new NewTopic(userAccountDeleteTopicName, userAccountDeleteNumberOfPartition, (short) userAccountDeleteReplicationFactor);
    }


}




