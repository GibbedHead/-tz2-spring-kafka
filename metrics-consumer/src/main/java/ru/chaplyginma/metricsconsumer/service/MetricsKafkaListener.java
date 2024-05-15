package ru.chaplyginma.metricsconsumer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.chaplyginma.metricsconsumer.dto.AddMetricsDto;

@Service
@Slf4j
@RequiredArgsConstructor
public class MetricsKafkaListener {
    private final MetricsService metricsService;

    @KafkaListener(id = "metricsGroup", topics = "metrics")
    public void listenMetrics(AddMetricsDto addMetricsDto) {
        log.info("Listened add metrics: {}", addMetricsDto);
        metricsService.save(addMetricsDto);
    }
}
