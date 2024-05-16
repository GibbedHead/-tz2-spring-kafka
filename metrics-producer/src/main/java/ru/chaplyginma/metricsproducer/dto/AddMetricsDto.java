package ru.chaplyginma.metricsproducer.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddMetricsDto {
    @NotBlank
    @Schema(description = "Name of the metric", example = "CPU Usage")
    String metricName;
    @Schema(description = "Value of the metric", example = "0.75")
    Double value;
    @NotNull
    @Schema(description = "Timestamp of the metric data", example = "2024-05-16T12:00:00")
    LocalDateTime timestamp;
}
