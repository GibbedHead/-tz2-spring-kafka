package ru.chaplyginma.metricsconsumer.service;

import ru.chaplyginma.metricsconsumer.dto.AddMetricDto;
import ru.chaplyginma.metricsconsumer.dto.MetricResponseDto;

import java.time.LocalDateTime;
import java.util.List;

public interface MetricsService {
    void save(AddMetricDto addMetricDto);

    List<String> getUniqueMetricNames();

    List<MetricResponseDto> getMetricsByName(String metricName, LocalDateTime startDate, LocalDateTime endDate);
}
