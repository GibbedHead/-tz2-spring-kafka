package ru.chaplyginma.metricsproducer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.chaplyginma.metricsproducer.dto.AddMetricsDto;
import ru.chaplyginma.metricsproducer.exception.model.SendToKafkaException;

import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaMetricsService implements MetricsService {
    private final KafkaTemplate<Object, Object> kafkaTemplate;
    @Value("${app.kafka.topic}")
    private String kafkaTopic;

    @Override
    public String sendMetrics(AddMetricsDto addMetricsDto) {
        try {
            kafkaTemplate.send(kafkaTopic, addMetricsDto).get();
            log.info("Metrics sent to Kafka successfully");
            return "Successfully sent to Kafka";
        } catch (InterruptedException | ExecutionException e) {
            log.error("Failed to send message to Kafka", e);
            throw new SendToKafkaException("Failed to send message to Kafka", e);
        }
    }
}
