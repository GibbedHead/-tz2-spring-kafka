package ru.chaplyginma.metricsconsumer.service;

import ru.chaplyginma.metricsconsumer.dto.AddMetricDto;
import ru.chaplyginma.metricsconsumer.model.Metric;

public interface MetricsService {
    Metric save(AddMetricDto addMetricDto);
}
