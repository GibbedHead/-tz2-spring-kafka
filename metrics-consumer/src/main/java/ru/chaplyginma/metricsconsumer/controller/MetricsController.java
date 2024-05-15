package ru.chaplyginma.metricsconsumer.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.chaplyginma.metricsconsumer.service.MetricsService;

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
}
