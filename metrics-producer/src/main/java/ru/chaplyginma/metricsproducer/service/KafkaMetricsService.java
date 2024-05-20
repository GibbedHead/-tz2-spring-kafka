package ru.chaplyginma.metricsproducer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.chaplyginma.addmetricsdto.dto.AddMetricDto;
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
    public String sendMetrics(AddMetricDto addMetricDto) {
        try {
            kafkaTemplate.send(kafkaTopic, addMetricDto).get();
            log.info("Metrics sent to Kafka successfully");
            return "Successfully sent to Kafka";
        } catch (InterruptedException | ExecutionException e) {
            log.error("Failed to send message to Kafka", e);
            throw new SendToKafkaException("Failed to send message to Kafka", e);
        }
    }
}
