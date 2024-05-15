package ru.chaplyginma.metricsconsumer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.chaplyginma.metricsconsumer.dto.AddMetricDto;

@Service
@Slf4j
@RequiredArgsConstructor
public class MetricsKafkaListener {
    private final MetricsService metricsService;

    @KafkaListener(id = "metricsGroup", topics = "metrics")
    @Transactional
    public void listenMetrics(AddMetricDto addMetricDto) {
        log.info("Listened add metrics: {}", addMetricDto);
        metricsService.save(addMetricDto);
    }
}
