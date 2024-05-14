package ru.chaplyginma.metricsproducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;

@Configuration
public class KafkaConfig {
    @Value("${app.kafka.topic}")
    private String kafkaTopic;

    @Bean
    public NewTopic metricsTopic() {
        return new NewTopic(kafkaTopic, 1, (short) 1);
    }

    @Bean
    public RecordMessageConverter converter() {
        return new JsonMessageConverter();
    }
}
