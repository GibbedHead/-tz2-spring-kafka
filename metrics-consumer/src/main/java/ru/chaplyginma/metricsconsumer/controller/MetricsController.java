package ru.chaplyginma.metricsconsumer.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.chaplyginma.metricsconsumer.dto.MetricResponseDto;
import ru.chaplyginma.metricsconsumer.service.MetricsService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/metrics")
@Slf4j
@RequiredArgsConstructor
public class MetricsController {
    private final MetricsService metricsService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<String> getUniqueMetricNames() {
        return metricsService.getUniqueMetricNames();
    }

    @GetMapping("/{metricName}")
    @ResponseStatus(HttpStatus.OK)
    public List<MetricResponseDto> getMetrics(
            @PathVariable("metricName") String metricName,
            @RequestParam(required = false) LocalDateTime startDate,
            @RequestParam(required = false) LocalDateTime endDate
    ) {
        return metricsService.getMetricsByName(metricName, startDate, endDate);
    }
}
