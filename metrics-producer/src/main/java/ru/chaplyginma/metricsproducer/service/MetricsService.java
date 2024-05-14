package ru.chaplyginma.metricsproducer.service;

import ru.chaplyginma.metricsproducer.dto.AddMetricsDto;

public interface MetricsService {
    String sendMetrics(AddMetricsDto addMetricsDto);
}
