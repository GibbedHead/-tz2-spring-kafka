package ru.chaplyginma.metricsconsumer.service;

import ru.chaplyginma.metricsconsumer.dto.AddMetricsDto;
import ru.chaplyginma.metricsconsumer.model.Metrics;

public interface MetricsService {
    Metrics save(AddMetricsDto addMetricsDto);
}
