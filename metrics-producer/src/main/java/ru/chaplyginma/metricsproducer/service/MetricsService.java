package ru.chaplyginma.metricsproducer.service;


import ru.chaplyginma.addmetricsdto.dto.AddMetricDto;

public interface MetricsService {
    String sendMetrics(AddMetricDto addMetricDto);
}
