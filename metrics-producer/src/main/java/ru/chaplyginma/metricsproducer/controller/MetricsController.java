package ru.chaplyginma.metricsproducer.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.chaplyginma.metricsproducer.dto.AddMetricsDto;

@RestController
@RequestMapping(path = "/metrics")
@Slf4j
public class MetricsController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String postMetrics(
            @Valid @RequestBody AddMetricsDto addMetricsDto
    ) {
        log.info(addMetricsDto.toString());
        return addMetricsDto.toString();
    }
}
