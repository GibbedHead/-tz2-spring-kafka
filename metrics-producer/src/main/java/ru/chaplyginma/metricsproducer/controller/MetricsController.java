package ru.chaplyginma.metricsproducer.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.chaplyginma.metricsproducer.dto.AddMetricsDto;
import ru.chaplyginma.metricsproducer.service.MetricsService;

@RestController
@RequestMapping(path = "/metrics")
@Slf4j
@RequiredArgsConstructor
public class MetricsController {
    private final MetricsService metricsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String postMetrics(
            @Valid @RequestBody AddMetricsDto addMetricsDto
    ) {
        log.info("Received add metrics: {}", addMetricsDto);
        return metricsService.sendMetrics(addMetricsDto);
    }
}
