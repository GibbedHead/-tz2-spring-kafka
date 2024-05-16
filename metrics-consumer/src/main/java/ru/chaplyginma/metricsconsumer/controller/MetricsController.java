package ru.chaplyginma.metricsconsumer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Metrics", description = "Endpoints for getting metrics")
public class MetricsController {
    private final MetricsService metricsService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get unique metric names", description = "Returns a list of unique metric names")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successful operation",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(type = "array", example = "[\"CPU Usage\", \"Disk free\"]")))
    })
    public List<String> getUniqueMetricNames() {
        return metricsService.getUniqueMetricNames();
    }

    @GetMapping("/{metricName}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get metrics by name",
            description = "Retrieve metrics by metric name with optional date range filter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successful operation",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = MetricResponseDto.class)))),
            @ApiResponse(responseCode = "400",
                    description = "Invalid parameters supplied",
                    content = @Content)
    })
    public List<MetricResponseDto> getMetrics(
            @Parameter(description = "Name of the metric", required = true)
            @PathVariable("metricName") String metricName,
            @Parameter(description = "Start date for filtering metrics (optional)", example = "2023-01-01T00:00:00")
            @RequestParam(required = false) LocalDateTime startDate,
            @Parameter(description = "End date for filtering metrics (optional)", example = "2023-12-31T23:59:59")
            @RequestParam(required = false) LocalDateTime endDate
    ) {
        return metricsService.getMetricsByName(metricName, startDate, endDate);
    }
}
