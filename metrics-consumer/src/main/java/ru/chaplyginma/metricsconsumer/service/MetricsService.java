package ru.chaplyginma.metricsconsumer.service;

import ru.chaplyginma.metricsconsumer.dto.AddMetricDto;

import java.util.List;

public interface MetricsService {
    void save(AddMetricDto addMetricDto);

    List<String> getUniqueMetricNames();
}
