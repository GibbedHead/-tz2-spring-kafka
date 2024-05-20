package ru.chaplyginma.metricsproducer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.chaplyginma.addmetricsdto.dto.AddMetricDto;
import ru.chaplyginma.metricsproducer.service.MetricsService;

@RestController
@RequestMapping(path = "/metrics")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Metrics", description = "Endpoint for managing metrics")
public class MetricsController {
    private final MetricsService metricsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add Metrics", description = "Add new metrics data to kafka")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Metrics added successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    public String postMetrics(
            @Parameter(description = "Metrics data to add", required = true, schema = @Schema(implementation = AddMetricDto.class))
            @Valid @RequestBody AddMetricDto addMetricDto
    ) {
        log.info("Received add metrics: {}", addMetricDto);
        return metricsService.sendMetrics(addMetricDto);
    }
}
