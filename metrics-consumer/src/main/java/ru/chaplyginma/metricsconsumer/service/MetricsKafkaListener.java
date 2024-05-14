package ru.chaplyginma.metricsconsumer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.chaplyginma.metricsconsumer.dto.AddMetricsDto;

@Service
@Slf4j
public class MetricsKafkaListener {

    @KafkaListener(id = "metricsGroup", topics = "metrics")
    public void listenMetrics(AddMetricsDto addMetricsDto) {
        log.info("Received add metrics: {}", addMetricsDto);
    }
}
